package com.pd.Pokedex.domain.api;

import com.pd.Pokedex.domain.model.Type;

import java.util.List;

public interface ITypeServicePort {
    void saveType(Type Type);
    List<Type> getAllType();
    Type getType(Long TypeNumber);
    void updateType(Type Type);
    void deleteType(Long TypeNumber);
}
