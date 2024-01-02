package com.pd.Pokedex.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokedexResponse {
    private Long number;
    private String name;
    private TypeDto type;
    private String photo;
}
