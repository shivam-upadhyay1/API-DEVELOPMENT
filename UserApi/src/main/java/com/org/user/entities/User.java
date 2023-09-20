package com.org.user.entities;

import javax.persistence.Id;

@javax.persistence.Entity
public class User {
     @Id
	private int id;
	private String userName;
	private int age;
	private String address;
	private int contact;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String userName, int age, String address, int contact, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.age = age;
		this.address = address;
		this.contact = contact;
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", age=" + age + ", address=" + address + ", contact="
				+ contact + ", email=" + email + "]";
	}
	
	
}
