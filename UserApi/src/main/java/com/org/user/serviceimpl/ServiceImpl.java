package com.org.user.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.org.user.entities.User;
import com.org.user.exceptions.NotFoundException;
import com.org.user.repository.UserRepository;
import com.org.user.service.Service;
@org.springframework.stereotype.Service
public class ServiceImpl implements Service {

	
	@Autowired
	private UserRepository userRepository;
	@Override
	public User getUser(int userId) {
		    
		return userRepository.findById(userId);
	}

	@Override
	public Iterable<User> getAllUser() {
              return userRepository.findAll();
         
	
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	

		 
		   

	
	@Override
	public void deleteUser(int id) {

		userRepository.deleteById(id);
	}

	@Override
	public User updateUser(int id, User updatedUser) {
		// Fetch the existing user by ID
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findById(id));

        if (!optionalUser.isPresent()) {
            throw new NotFoundException("User not found with ID: " + id);
        }

        User existingUser = optionalUser.get();

        // Update the existing user with the new information
        String newUsername = updatedUser.getUserName();
        String newEmail = updatedUser.getEmail();

        if (newUsername != null) {
            existingUser.setUserName(newUsername);
        }

        if (newEmail != null) {
            existingUser.setEmail(newEmail);
        }

        // Save the updated user to the database
        return userRepository.save(existingUser);
    }
	}




