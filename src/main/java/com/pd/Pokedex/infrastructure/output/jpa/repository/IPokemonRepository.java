package com.pd.Pokedex.infrastructure.output.jpa.repository;

import com.pd.Pokedex.infrastructure.output.jpa.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPokemonRepository extends JpaRepository<PokemonEntity,Long> {
    Optional<PokemonEntity> findByNumber(Long pokemonNumber);

    void deleteByNumber(Long pokemonNumber);
}
