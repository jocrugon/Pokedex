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
    public void savePhoto(Photo Photo) {
        photoPersistencePort.savePhoto(Photo);
    }

    @Override
    public List<Photo> getAllPhoto() {
        return photoPersistencePort.getAllPhoto();
    }

    @Override
    public Photo getPhoto(Long PhotoNumber) {
        return photoPersistencePort.getPhoto(PhotoNumber);
    }

    @Override
    public void updatePhoto(Photo Photo) {
        photoPersistencePort.updatePhoto(Photo);
    }

    @Override
    public void deletePhoto(Long PhotoNumber) {
        photoPersistencePort.deletePhoto(PhotoNumber);
    }
}
