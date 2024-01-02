package com.pd.Pokedex.domain.usecase;

import com.pd.Pokedex.domain.api.IPokemonServicePort;
import com.pd.Pokedex.domain.model.Pokemon;
import com.pd.Pokedex.domain.spi.IPokemonPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PokemonUseCase  implements IPokemonServicePort {
    private final IPokemonPersistencePort pokemonPersistencePort;

    public PokemonUseCase(IPokemonPersistencePort pokemonPersistencePort) {
        this.pokemonPersistencePort = pokemonPersistencePort;
    }

    @Override
    public void savePokemon(Pokemon pokemon) {
        pokemonPersistencePort.savePokemon(pokemon);
    }

    @Override
    public List<Pokemon> getAllPokemon() {
        return pokemonPersistencePort.getAllPokemon();
    }

    @Override
    public Pokemon getPokemon(Long pokemonNumber) {
        return pokemonPersistencePort.getPokemon(pokemonNumber);
    }

    @Override
    public void updatePokemon(Pokemon pokemon) {
        pokemonPersistencePort.updatePokemon(pokemon);
    }

    @Override
    public void deletePokemon(Long pokemonNumber) {
        pokemonPersistencePort.deletePokemon(pokemonNumber);
    }
}
