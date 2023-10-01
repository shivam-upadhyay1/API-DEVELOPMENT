package com.imageupload.imageServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imageupload.ImageRepository.ImageRepository;
import com.imageupload.entities.ImageEntity;
import com.imageupload.exceptions.ImageNotFoundException;
import com.imageupload.imageService.ImageService;

import jakarta.transaction.Transactional;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository repository;
	
	
	//get Image
	@Override
    public ImageEntity getImageById(Long imageId) {
        Optional<ImageEntity> imageEntityOptional = repository.findById(imageId);
        if (imageEntityOptional.isPresent()) {
            return imageEntityOptional.get();
        } else {
            throw new ImageNotFoundException("Image with ID " + imageId + " not found.");
        }
    }

    @Override
    @Transactional
    public ImageEntity saveImage(String imageName, byte[] imageData) {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImageName(imageName);
        imageEntity.setImageData(imageData);
        return repository.save(imageEntity);
    }
    
    
    //update Image
    @Override
    @Transactional
    public ImageEntity updateImage(Long imageId, String newImageName, byte[] newImageData) {
        Optional<ImageEntity> imageEntityOptional = repository.findById(imageId);
        if (imageEntityOptional.isPresent()) {
            ImageEntity imageEntity = imageEntityOptional.get();
            imageEntity.setImageName(newImageName);
            imageEntity.setImageData(newImageData);
            return repository.save(imageEntity);
        } else {
            throw new ImageNotFoundException("Image with ID " + imageId + " not found.");
        }
    }
    @Override
    @Transactional
    public void deleteImage(Long imageId) {
        Optional<ImageEntity> imageEntityOptional = repository.findById(imageId);
        if (imageEntityOptional.isPresent()) {
            ImageEntity imageEntity = imageEntityOptional.get();
            repository.delete(imageEntity);
        } else {
            throw new ImageNotFoundException("Image with ID " + imageId + " not found.");
        }
    }

}
