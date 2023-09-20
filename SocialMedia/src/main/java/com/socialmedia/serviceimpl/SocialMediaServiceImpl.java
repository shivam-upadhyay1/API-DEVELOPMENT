package com.socialmedia.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialmedia.entities.SocialMedia;
import com.socialmedia.repository.SocialMediaRepo;
import com.socialmedia.service.SocialMediaService;
@Service
public class SocialMediaServiceImpl implements SocialMediaService {

	@Autowired
	private SocialMediaRepo socialMediaRepository;
	@Override
	public SocialMedia getContent(int id) {
		return socialMediaRepository.findById(id).orElse(new SocialMedia());
	}

	@Override
	public List<SocialMedia> getAllContent() {
		List<SocialMedia> allContent=(List<SocialMedia>) socialMediaRepository.findAll();
		return allContent;
	}

	@Override
	public SocialMedia addPost(SocialMedia socialMedia) {
		return socialMediaRepository.save(socialMedia);
	}

	@Override
	public SocialMedia updatePost(int id, SocialMedia socialMedia) {
		SocialMedia existMedia = socialMediaRepository.findById(id).orElse(null);
		if(existMedia != null)
		{
			//update existing media with new data
			existMedia.setId(socialMedia.getId());
			existMedia.setEmail(socialMedia.getEmail());
			existMedia.setContent(socialMedia.getContent());
			existMedia.setUserName(socialMedia.getContent());
			
			return socialMediaRepository.save(existMedia);
		}
		return null;
	}

	@Override
	public void deletePost(int id) {
		socialMediaRepository.deleteById(id);		
	}

}
