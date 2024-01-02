package com.pd.Pokedex.domain.spi;

import com.pd.Pokedex.domain.model.Type;

import java.util.List;

public interface ITypePersistencePort {
    Type saveType(Type type);
    List<Type> getAllType();
    Type getType(Long typeNumber);
    void updateType(Type type);
    void deleteType(Long typeNumber);

}
