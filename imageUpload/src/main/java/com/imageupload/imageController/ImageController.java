package com.imageupload.imageController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.imageupload.entities.ImageEntity;
import com.imageupload.exceptions.ImageNotFoundException;
import com.imageupload.imageServiceImpl.ImageServiceImpl;

@RestController
@RequestMapping("/images")
public class ImageController {

	@Autowired
	private ImageServiceImpl serviceImpl;
	
	
	//get Image
	@GetMapping("/{imageId}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long imageId) {
        try {
            ImageEntity imageEntity = serviceImpl.getImageById(imageId);
            return ResponseEntity.ok()
                    .header("Content-Disposition", "inline; filename=\"" + imageEntity.getImageName() + "\"")
                    .body(imageEntity.getImageData());
        } catch (ImageNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	//upload Image
	@PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return new ResponseEntity<>("Please select a file to upload", HttpStatus.BAD_REQUEST);
        }

        String imageName = file.getOriginalFilename();
        byte[] imageData = file.getBytes();

        ImageEntity savedImage = serviceImpl.saveImage(imageName, imageData);

        if (savedImage != null) {
            return new ResponseEntity<>("Image uploaded successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to upload image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	//update Image
	 @PutMapping("/{imageId}")
	    public ResponseEntity<String> updateImage(
	            @PathVariable Long imageId,
	            @RequestParam("newImageName") String newImageName,
	            @RequestParam("newImageData") MultipartFile newImageData
	    ) throws IOException {
	        try {
	            byte[] newImageDataBytes = newImageData.getBytes();
	            serviceImpl.updateImage(imageId, newImageName, newImageDataBytes);
	            return new ResponseEntity<>("Image updated successfully", HttpStatus.OK);
	        } catch (ImageNotFoundException e) {
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	        }
	    }
	
	//Delete Image
	@DeleteMapping("/{imageId}")
    public ResponseEntity<String> deleteImage(@PathVariable Long imageId) {
        try {
        	serviceImpl.deleteImage(imageId);
            return new ResponseEntity<>("Image deleted successfully", HttpStatus.OK);
        } catch (ImageNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
