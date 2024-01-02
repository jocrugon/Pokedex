package com.pd.Pokedex.infrastructure.output.jpa.adapter;

import com.pd.Pokedex.domain.model.Pokemon;
import com.pd.Pokedex.domain.spi.IPokemonPersistencePort;
import com.pd.Pokedex.infrastructure.exception.NoDataFoundException;
import com.pd.Pokedex.infrastructure.exception.PokemonAlreadyExistsException;
import com.pd.Pokedex.infrastructure.exception.PokemonNotFoundException;
import com.pd.Pokedex.infrastructure.output.jpa.entity.PokemonEntity;
import com.pd.Pokedex.infrastructure.output.jpa.mapper.PokemonEntityMapper;
import com.pd.Pokedex.infrastructure.output.jpa.repository.IPokemonRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PokemonJpaAdapter implements IPokemonPersistencePort {

    private final IPokemonRepository pokemonRepository;
    private final PokemonEntityMapper pokemonEntityMapper;

    @Override
    public void savePokemon(Pokemon pokemon) {
        if(pokemonRepository.findByNumber(pokemon.getNumber()).isPresent()){
            throw new PokemonAlreadyExistsException();
        }
        pokemonRepository.save(pokemonEntityMapper.toEntity(pokemon));
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        List<PokemonEntity> pokemonEntityList = pokemonRepository.findAll();
        if(pokemonEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return pokemonEntityMapper.toPokemonList(pokemonEntityList);
    }

    @Override
    public Pokemon getPokemon(Long pokemonNumber) {
        return pokemonEntityMapper.toPokemon(pokemonRepository.findByNumber(pokemonNumber).orElseThrow(PokemonNotFoundException::new));
    }

    @Override
    public void updatePokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemonEntityMapper.toEntity(pokemon));
    }

    @Override
    public void deletePokemon(Long pokemonNumber) {
        pokemonRepository.deleteByNumber(pokemonNumber);
    }
}
