package com.pd.Pokedex.application.mapper;

import com.pd.Pokedex.application.dto.PokedexRequest;
import com.pd.Pokedex.domain.model.Photo;
import com.pd.Pokedex.domain.model.Pokemon;
import com.pd.Pokedex.domain.model.Type;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Base64;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PokedexRequestMapper {
    Pokemon toPokemon(PokedexRequest pokedexRequest);

    @Mapping(target = "firstType",source = "type.firstType")
    @Mapping(target = "secondType",source = "type.secondType")
    Type toType(PokedexRequest pokedexRequest);

    @Mapping(target = "photo", qualifiedByName = "base64ToByteArray")
    Photo toPhoto(PokedexRequest pokedexRequest);

    @Named("base64ToByteArray")
    static byte[] base64ToByteArray(String base64Photo){
        return Base64.getDecoder().decode(base64Photo);
    }

}
