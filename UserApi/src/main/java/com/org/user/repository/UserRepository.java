package com.org.user.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.org.user.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	//public List<User> getAll(User user);
	public User findById(int userId);
	
	
}
