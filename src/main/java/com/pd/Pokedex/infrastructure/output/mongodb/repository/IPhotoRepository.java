package com.pd.Pokedex.infrastructure.output.mongodb.repository;

import com.pd.Pokedex.infrastructure.output.mongodb.entity.PhotoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPhotoRepository extends MongoRepository<PhotoEntity,String> {
}
