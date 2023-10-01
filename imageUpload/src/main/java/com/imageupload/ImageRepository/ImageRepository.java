package com.imageupload.ImageRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imageupload.entities.ImageEntity;
@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, Long>{

}
