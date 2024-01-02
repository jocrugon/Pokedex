package com.pd.Pokedex.domain.usecase;

import com.pd.Pokedex.domain.api.IPhotoServicePort;
import com.pd.Pokedex.domain.model.Photo;
import com.pd.Pokedex.domain.spi.IPhotoPersistencePort;

import java.util.List;

public class PhotoUseCase implements IPhotoServicePort {
    private final IPhotoPersistencePort photoPersistencePort;

    public PhotoUseCase(IPhotoPersistencePort PhotoPersistencePort) {
        this.photoPersistencePort = PhotoPersistencePort;
    }

    @Override
    public Photo savePhoto(Photo photo) {
        return photoPersistencePort.savePhoto(photo);
    }

    @Override
    public List<Photo> getAllPhoto() {
        return photoPersistencePort.getAllPhoto();
    }

    @Override
    public Photo getPhoto(String photoNumber) {
        return photoPersistencePort.getPhoto(photoNumber);
    }

    @Override
    public void updatePhoto(Photo Photo) {
        photoPersistencePort.updatePhoto(Photo);
    }

    @Override
    public void deletePhoto(String photoNumber) {
        photoPersistencePort.deletePhoto(photoNumber);
    }
}
