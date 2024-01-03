package com.pd.Pokedex.infrastructure.output.mongodb.adapter;

import com.pd.Pokedex.domain.model.Photo;
import com.pd.Pokedex.domain.spi.IPhotoPersistencePort;
import com.pd.Pokedex.infrastructure.exception.NoDataFoundException;
import com.pd.Pokedex.infrastructure.exception.PhotoNotFoundException;
import com.pd.Pokedex.infrastructure.output.mongodb.entity.PhotoEntity;
import com.pd.Pokedex.infrastructure.output.mongodb.mapper.PhotoEntityMapper;
import com.pd.Pokedex.infrastructure.output.mongodb.repository.IPhotoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PhotoMongodbAdapter implements IPhotoPersistencePort {

    private final IPhotoRepository photoRepository;
    private final PhotoEntityMapper photoEntityMapper;

    @Override
    public Photo savePhoto(Photo photo) {
        return photoEntityMapper.toPhoto(photoRepository.save(photoEntityMapper.toEntity(photo)));
    }

    @Override
    public List<Photo> getAllPhotos() {
        List<PhotoEntity> photoEntityList = photoRepository.findAll();
        if (photoEntityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return photoEntityMapper.toPhotoList(photoEntityList);
    }

    @Override
    public Photo getPhoto(String photoId) {
        return photoEntityMapper.toPhoto(photoRepository.findById(photoId).orElseThrow(PhotoNotFoundException::new));
    }

    @Override
    public void updatePhoto(Photo photo) {
        photoRepository.save(photoEntityMapper.toEntity(photo));
    }

    @Override
    public void deletePhoto(String photoId) {
        photoRepository.deleteById(photoId);
    }
}
