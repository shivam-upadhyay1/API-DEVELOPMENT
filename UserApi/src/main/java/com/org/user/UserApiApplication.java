package com.org.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.org.user.entities.User;
import com.org.user.repository.UserRepository;
import com.org.user.serviceimpl.ServiceImpl;

@SpringBootApplication
public class UserApiApplication implements CommandLineRunner{

	@Autowired
	private ServiceImpl serviceImpl;
	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
		System.out.println("your app is starting..");
	}

	@Override
	public void run(String... args) throws Exception {

              User user=new User();
              user.setId(1);
              user.setAge(20);
              user.setAddress("Delhi");
              user.setContact(12345);
              user.setEmail("shiva@gmail.com");
              user.setUserName("Shivam Upadhyay");
              serviceImpl.addUser(user);
             
	}

}
