package com.blogapp.service;

import java.util.List;

import com.blogapp.model.BlogPost;

public interface BlogPostService {

	//to Get All Blogs
	 List<BlogPost> getAllBlogPosts();
	 
	 //to get Single blog
	    BlogPost getBlogPostById(Long id);
	    
	    //create a new blog
	    BlogPost createBlogPost(BlogPost blogPost);
	    
	    //update a blog
	    BlogPost updateBlogPost(Long id, BlogPost blogPost);
	    
	    //delete a blog
	    void deleteBlogPost(Long id);
}
