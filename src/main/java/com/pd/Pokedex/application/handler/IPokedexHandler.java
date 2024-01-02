package com.pd.Pokedex.application.handler;

import com.pd.Pokedex.application.dto.PokedexRequest;
import com.pd.Pokedex.application.dto.PokedexResponse;

import java.util.List;

public interface IPokedexHandler {
    void savePokemonInPokedex(PokedexRequest pokedexRequest);
    List<PokedexResponse> getAllPokemonFromPokedex();
    PokedexResponse getPokemonFromPokedex(Long pokemonNumber);
    void updatePokemonInPokedex(PokedexRequest pokedexRequest);
    void deletePokemonFromPokedex(Long pokemonNumber);
}
