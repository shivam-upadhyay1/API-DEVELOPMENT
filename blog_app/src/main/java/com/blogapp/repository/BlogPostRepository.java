package com.blogapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogapp.model.BlogPost;
@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long>{

}
