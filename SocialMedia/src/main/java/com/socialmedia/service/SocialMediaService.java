package com.socialmedia.service;

import java.util.List;


import com.socialmedia.entities.SocialMedia;

public interface SocialMediaService {
	
	//get single content
	public SocialMedia getContent(int id);
	
	//get all content
	public List<SocialMedia> getAllContent();
	
	//add post
	public SocialMedia addPost(SocialMedia socialMedia);
	
	//update
	public SocialMedia updatePost(int id, SocialMedia socialMedia);
	
	//delete
	public void deletePost(int id);
	
	

}
