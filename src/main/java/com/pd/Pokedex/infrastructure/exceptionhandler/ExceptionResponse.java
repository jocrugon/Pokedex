package com.pd.Pokedex.infrastructure.exceptionhandler;

public enum ExceptionResponse {
    POKEMON_NOT_FOUND("No Pokemon was found with that number"),
    POKEMON_ALREADY_EXISTS("There is already a pokemon with that number"),
    TYPE_NOT_FOUND("No type was found for a pokemon"),
    NO_DATA_FOUND("No data found for the requested petition"),
    PHOTO_NOT_FOUND("No photo was found for a pokemon");

    private String message;

    ExceptionResponse(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
