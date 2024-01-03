package com.pd.Pokedex.infrastructure.configuration;

import com.pd.Pokedex.domain.api.IPhotoServicePort;
import com.pd.Pokedex.domain.api.IPokemonServicePort;
import com.pd.Pokedex.domain.api.ITypeServicePort;
import com.pd.Pokedex.domain.spi.IPhotoPersistencePort;
import com.pd.Pokedex.domain.spi.IPokemonPersistencePort;
import com.pd.Pokedex.domain.spi.ITypePersistencePort;
import com.pd.Pokedex.domain.usecase.PhotoUseCase;
import com.pd.Pokedex.domain.usecase.PokemonUseCase;
import com.pd.Pokedex.domain.usecase.TypeUseCase;
import com.pd.Pokedex.infrastructure.output.jpa.adapter.PokemonJpaAdapter;
import com.pd.Pokedex.infrastructure.output.jpa.adapter.TypeJpaAdapter;
import com.pd.Pokedex.infrastructure.output.jpa.mapper.PokemonEntityMapper;
import com.pd.Pokedex.infrastructure.output.jpa.mapper.TypeEntityMapper;
import com.pd.Pokedex.infrastructure.output.jpa.repository.IPokemonRepository;
import com.pd.Pokedex.infrastructure.output.jpa.repository.ITypeRepository;
import com.pd.Pokedex.infrastructure.output.mongodb.adapter.PhotoMongodbAdapter;
import com.pd.Pokedex.infrastructure.output.mongodb.mapper.PhotoEntityMapper;
import com.pd.Pokedex.infrastructure.output.mongodb.repository.IPhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IPokemonRepository pokemonRepository;
    private final PokemonEntityMapper pokemonEntityMapper;
    private final ITypeRepository typeRepository;
    private final TypeEntityMapper typeEntityMapper;
    private final IPhotoRepository photoRepository;
    private final PhotoEntityMapper photoEntityMapper;

    @Bean
    public IPokemonPersistencePort pokemonPersistencePort(){
        return new PokemonJpaAdapter(pokemonRepository, pokemonEntityMapper);
    }

    @Bean
    public IPokemonServicePort pokemonServicePort(){
        return new PokemonUseCase(pokemonPersistencePort());
    }

    @Bean
    public ITypePersistencePort typePersistencePort() {
        return new TypeJpaAdapter(typeRepository, typeEntityMapper);
    }

    @Bean
    public ITypeServicePort typeServicePort() {
        return new TypeUseCase(typePersistencePort());
    }
    @Bean
    public IPhotoPersistencePort photoPersistencePort() {
        return new PhotoMongodbAdapter(photoRepository, photoEntityMapper);
    }

    @Bean
    public IPhotoServicePort photoServicePort() {
        return new PhotoUseCase(photoPersistencePort());
    }
}
