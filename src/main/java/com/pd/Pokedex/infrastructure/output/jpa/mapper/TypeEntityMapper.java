package com.pd.Pokedex.infrastructure.output.jpa.mapper;

import com.pd.Pokedex.domain.model.Type;
import com.pd.Pokedex.infrastructure.output.jpa.entity.TypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TypeEntityMapper {
    TypeEntity toEntity(Type type);

    Type toType(TypeEntity typeEntity);

    List<Type> toTypeList(List<TypeEntity> typeEntityList);
}