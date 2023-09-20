package com.org.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.user.entities.User;
import com.org.user.serviceimpl.ServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private ServiceImpl serviceImpl;
	//get single user
	@GetMapping("/{id}")
	public ResponseEntity<User> getSingleUser(@PathVariable("id") int id)
	{
		User get = serviceImpl.getUser(id);
		return ResponseEntity.status(HttpStatus.OK).body(get);
	}
	//get all user
	@GetMapping("/all")
	public Iterable<User> getAllUser()
	{
		return serviceImpl.getAllUser();
	}
	
	@PostMapping("/add")
	public User createUser(@RequestBody User user)
	{
		return serviceImpl.addUser(user);
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id)
	{
          serviceImpl.deleteUser(id);
          
	}
	
	@PutMapping("/update/{id}")
	public User updateUser(@PathVariable("id") int id, User user)
	{
		return serviceImpl.updateUser(id, user);
		
	}
	
}
