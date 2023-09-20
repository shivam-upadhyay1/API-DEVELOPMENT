package com.socialmedia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialmedia.entities.SocialMedia;
import com.socialmedia.serviceimpl.SocialMediaServiceImpl;

@RestController
@RequestMapping("/social")
public class SocialController {

	@Autowired
	private SocialMediaServiceImpl socialMediaServiceImpl;

	//get single content
	@GetMapping("/{id}")
	public SocialMedia getSingleContent(@PathVariable("id") int id)
	{
		SocialMedia content = socialMediaServiceImpl.getContent(id);
		return content;
	}
	
	//getAll content
	@GetMapping("/getall")
	public List<SocialMedia> getAllContent()
	{
		List<SocialMedia> allContent = socialMediaServiceImpl.getAllContent();
		return allContent;
	}
	
	//add content
	@PostMapping("/add")
	public SocialMedia addContent(@RequestBody SocialMedia socialMedia)
	{
		SocialMedia addPost = socialMediaServiceImpl.addPost(socialMedia);
		return addPost;
	}
	
	//update post
	@PutMapping("/{id}")
	public ResponseEntity<SocialMedia> updatePost(@PathVariable("id") int id,@RequestBody SocialMedia socialMedia)
	{
		SocialMedia update = socialMediaServiceImpl.updatePost(id, socialMedia);
		if(update != null)
		{
			return ResponseEntity.ok(update);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	//delete post
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable("id") int id)
	{
		socialMediaServiceImpl.deletePost(id);
		System.out.println("this user is permanently deleted.   "+id);
	}

}
