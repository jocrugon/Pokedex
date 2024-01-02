package com.pd.Pokedex.infrastructure.output.jpa.adapter;

import com.pd.Pokedex.domain.model.Type;
import com.pd.Pokedex.domain.spi.ITypePersistencePort;
import com.pd.Pokedex.infrastructure.exception.NoDataFoundException;
import com.pd.Pokedex.infrastructure.exception.TypeNotFoundException;
import com.pd.Pokedex.infrastructure.output.jpa.entity.TypeEntity;
import com.pd.Pokedex.infrastructure.output.jpa.mapper.TypeEntityMapper;
import com.pd.Pokedex.infrastructure.output.jpa.repository.ITypeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor

public class TypeJpaAdapter implements ITypePersistencePort {

    private final TypeEntityMapper typeEntityMapper;
    private final ITypeRepository typeRepository;

    @Override
    public Type saveType(Type type) {
        return typeEntityMapper.toType(typeRepository.save(typeEntityMapper.toEntity(type)));
    }

    @Override
    public List<Type> getAllType() {
        List<TypeEntity> typeEntityList = typeRepository.findAll();
        if(typeEntityList.isEmpty()){
            throw new NoDataFoundException();
        }
        return typeEntityMapper.toTypeList(typeEntityList);
    }

    @Override
    public Type getType(Long typeNumber) {

        return typeEntityMapper.toType(typeRepository.findById(typeNumber).orElseThrow(TypeNotFoundException::new));
    }

    @Override
    public void updateType(Type type) {
        typeRepository.save(typeEntityMapper.toEntity(type));
    }

    @Override
    public void deleteType(Long typeNumber) {
        typeRepository.deleteById(typeNumber);
    }
}
