package com.socialmedia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="social_media")
public class SocialMedia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private String email;
	private String content;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public SocialMedia(int id, String userName, String email, String content) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.content = content;
	}
	@Override
	public String toString() {
		return "SocialMedia [id=" + id + ", userName=" + userName + ", email=" + email + ", content=" + content + "]";
	}
	public SocialMedia() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
