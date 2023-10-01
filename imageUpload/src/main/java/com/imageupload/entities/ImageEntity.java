package com.imageupload.entities;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="upload_image")
public class ImageEntity {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
    private String imageName;
    private byte[] imageData;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public byte[] getImageData() {
		return imageData;
	}
	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}
	public ImageEntity(Long id, String imageName, byte[] imageData) {
		super();
		this.id = id;
		this.imageName = imageName;
		this.imageData = imageData;
	}
	@Override
	public String toString() {
		return "ImageEntity [id=" + id + ", imageName=" + imageName + ", imageData=" + Arrays.toString(imageData) + "]";
	}
	public ImageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
