package com.blogapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogapp.model.BlogPost;
import com.blogapp.repository.BlogPostRepository;
import com.blogapp.service.BlogPostService;

@Service
public class BlogPostServiceImpl implements BlogPostService{

	@Autowired
	private BlogPostRepository blogPostRepository;

	
	@Override
    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    @Override
    public BlogPost getBlogPostById(Long id) {
        return blogPostRepository.findById(id).orElse(null);
    }

    @Override
    public BlogPost createBlogPost(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    @Override
    public BlogPost updateBlogPost(Long id, BlogPost blogPost) {
        if (blogPostRepository.existsById(id)) {
            blogPost.setId(id);
            return blogPostRepository.save(blogPost);
        }
        return null;
    }

    @Override
    public void deleteBlogPost(Long id) {
        blogPostRepository.deleteById(id);
    }
}
