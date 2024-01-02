package com.pd.Pokedex.domain.api;

import com.pd.Pokedex.domain.model.Photo;

import java.util.List;

public interface IPhotoServicePort {
    Photo savePhoto(Photo photo);
    List<Photo> getAllPhoto();
    Photo getPhoto(String photoNumber);
    void updatePhoto(Photo Photo);
    void deletePhoto(String photoNumber);
}
