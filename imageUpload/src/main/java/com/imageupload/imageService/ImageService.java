package com.imageupload.imageService;

import com.imageupload.entities.ImageEntity;

public interface ImageService {
	
	
	//get Image 
    ImageEntity getImageById(Long imageId);

	//save Image
	ImageEntity saveImage(String imageName, byte[] imageData);
	
	//update Image
    ImageEntity updateImage(Long imageId, String newImageName, byte[] newImageData);


	//delete Image
    void deleteImage(Long imageId);

}
