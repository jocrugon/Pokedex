package com.pd.Pokedex.application.handler;

import com.pd.Pokedex.application.dto.PokedexRequest;
import com.pd.Pokedex.application.dto.PokedexResponse;
import com.pd.Pokedex.application.mapper.PokedexRequestMapper;
import com.pd.Pokedex.application.mapper.PokedexResponseMapper;
import com.pd.Pokedex.application.mapper.TypeDtoMapper;
import com.pd.Pokedex.domain.api.IPhotoServicePort;
import com.pd.Pokedex.domain.api.IPokemonServicePort;
import com.pd.Pokedex.domain.api.ITypeServicePort;
import com.pd.Pokedex.domain.model.Photo;
import com.pd.Pokedex.domain.model.Pokemon;
import com.pd.Pokedex.domain.model.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class PokedexHandler implements IPokedexHandler{

    private final IPokemonServicePort pokemonServicePort;
    private final ITypeServicePort typeServicePort;
    private final IPhotoServicePort photoServicePort;
    private final PokedexRequestMapper pokedexRequestMapper;
    private final PokedexResponseMapper pokedexResponseMapper;
    private final TypeDtoMapper typeDtoMapper;
    @Override
    public void savePokemonInPokedex(PokedexRequest pokedexRequest) {
        Type type = typeServicePort.saveType(pokedexRequestMapper.toType(pokedexRequest));
        Photo photo= photoServicePort.savePhoto(pokedexRequestMapper.toPhoto(pokedexRequest));
        Pokemon pokemon = pokedexRequestMapper.toPokemon(pokedexRequest);
        pokemon.setTypeId(type.getId());
        pokemon.setPhotoId(photo.getId());
        pokemonServicePort.savePokemon(pokemon);
    }

    @Override
    public List<PokedexResponse> getAllPokemonFromPokedex() {
        return pokedexResponseMapper.toResponseList(pokemonServicePort.getAllPokemon(),typeServicePort.getAllType(),photoServicePort.getAllPhotos());
    }

    @Override
    public PokedexResponse getPokemonFromPokedex(Long pokemonNumber) {
        Pokemon pokemon = pokemonServicePort.getPokemon(pokemonNumber);
        return pokedexResponseMapper.toResponse(pokemon,typeServicePort.getType(pokemon.getTypeId()),photoServicePort.getPhoto(pokemon.getPhotoId()));
    }

    @Override
    public void updatePokemonInPokedex(PokedexRequest pokedexRequest) {
        Pokemon oldPokemon = pokemonServicePort.getPokemon(pokedexRequest.getNumber());
        Type newType = pokedexRequestMapper.toType(pokedexRequest);
        Photo newPhoto = pokedexRequestMapper.toPhoto(pokedexRequest);
        newType.setId(oldPokemon.getTypeId());
        newPhoto.setId(oldPokemon.getPhotoId());
        typeServicePort.updateType(newType);
        photoServicePort.updatePhoto(newPhoto);

        Pokemon newPokemon = pokedexRequestMapper.toPokemon(pokedexRequest);
        newPokemon.setId(oldPokemon.getId());
        newPokemon.setTypeId(oldPokemon.getTypeId());
        newPokemon.setPhotoId(oldPokemon.getPhotoId());

        pokemonServicePort.updatePokemon(newPokemon);
    }

    @Override
    public void deletePokemonFromPokedex(Long pokemonNumber) {
        Pokemon pokemon = pokemonServicePort.getPokemon(pokemonNumber);
        typeServicePort.deleteType(pokemon.getTypeId());
        photoServicePort.deletePhoto(pokemon.getPhotoId());
        pokemonServicePort.deletePokemon(pokemon.getId());
    }
}
