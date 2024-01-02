package com.pd.Pokedex.domain.api;

import com.pd.Pokedex.domain.model.Type;

import java.util.List;

public interface ITypeServicePort {
    Type saveType(Type type);
    List<Type> getAllType();
    Type getType(Long typeNumber);
    void updateType(Type type);
    void deleteType(Long typeNumber);
}
