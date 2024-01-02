package com.pd.Pokedex.application.mapper;

import com.pd.Pokedex.application.dto.TypeDto;
import com.pd.Pokedex.domain.model.Type;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TypeDtoMapper {
    TypeDto toDto(Type type);

}
