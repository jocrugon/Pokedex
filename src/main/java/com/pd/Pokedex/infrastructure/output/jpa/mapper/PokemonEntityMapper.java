package com.pd.Pokedex.infrastructure.output.jpa.mapper;

import com.pd.Pokedex.domain.model.Pokemon;
import com.pd.Pokedex.infrastructure.output.jpa.entity.PokemonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PokemonEntityMapper {

    PokemonEntity toEntity(Pokemon pokemon);

    Pokemon toPokemon(PokemonEntity pokemonEntity);

    List<Pokemon> toPokemonList(List<PokemonEntity> pokemonEntityList);
}