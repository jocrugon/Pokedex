package com.pd.Pokedex.domain.usecase;

import com.pd.Pokedex.domain.api.ITypeServicePort;
import com.pd.Pokedex.domain.model.Type;
import com.pd.Pokedex.domain.spi.ITypePersistencePort;

import java.util.List;

public class TypeUseCase implements ITypeServicePort {
    private final ITypePersistencePort typePersistencePort;

    public TypeUseCase(ITypePersistencePort typePersistencePort) {
        this.typePersistencePort = typePersistencePort;
    }

    @Override
    public Type saveType(Type type) {
        return typePersistencePort.saveType(type);
    }

    @Override
    public List<Type> getAllType() {
        return typePersistencePort.getAllType();
    }

    @Override
    public Type getType(Long typeNumber) {
        return typePersistencePort.getType(typeNumber);
    }

    @Override
    public void updateType(Type type) {
        typePersistencePort.updateType(type);
    }

    @Override
    public void deleteType(Long typeNumber) {
        typePersistencePort.deleteType(typeNumber);
    }
}
