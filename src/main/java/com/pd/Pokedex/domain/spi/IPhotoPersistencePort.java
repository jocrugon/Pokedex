package com.pd.Pokedex.domain.spi;

import com.pd.Pokedex.domain.model.Photo;

import java.util.List;

public interface IPhotoPersistencePort {
    void savePhoto(Photo Photo);
    List<Photo> getAllPhoto();
    Photo getPhoto(Long PhotoNumber);
    void updatePhoto(Photo Photo);
    void deletePhoto(Long PhotoNumber);
}
