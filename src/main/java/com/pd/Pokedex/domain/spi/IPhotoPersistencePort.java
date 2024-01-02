package com.pd.Pokedex.domain.spi;

import com.pd.Pokedex.domain.model.Photo;

import java.util.List;

public interface IPhotoPersistencePort {
    Photo savePhoto(Photo photo);
    List<Photo> getAllPhoto();
    Photo getPhoto(String photoNumber);
    void updatePhoto(Photo photo);
    void deletePhoto(String photoNumber);
}
