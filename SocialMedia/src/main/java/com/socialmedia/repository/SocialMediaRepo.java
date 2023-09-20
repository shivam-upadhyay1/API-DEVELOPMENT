package com.socialmedia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.socialmedia.entities.SocialMedia;

@Repository
public interface SocialMediaRepo extends CrudRepository<SocialMedia, Integer>{

}
