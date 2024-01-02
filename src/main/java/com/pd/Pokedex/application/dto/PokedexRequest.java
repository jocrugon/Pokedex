package com.pd.Pokedex.application.dto;

import com.pd.Pokedex.domain.model.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokedexRequest {
    private Long number;
    private String name;
    private Type type;
    private String photo;
}
