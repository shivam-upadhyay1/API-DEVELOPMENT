package com.blogapp.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="blog_App")
public class BlogPost {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    private String heading;
    private String title;
    private String description;
    private String subDescription;
    private Date date;
    private String image;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSubDescription() {
		return subDescription;
	}
	public void setSubDescription(String subDescription) {
		this.subDescription = subDescription;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public BlogPost(Long id, String heading, String title, String description, String subDescription, Date date,
			String image) {
		super();
		this.id = id;
		this.heading = heading;
		this.title = title;
		this.description = description;
		this.subDescription = subDescription;
		this.date = date;
		this.image = image;
	}
	@Override
	public String toString() {
		return "BlogPost [id=" + id + ", heading=" + heading + ", title=" + title + ", description=" + description
				+ ", subDescription=" + subDescription + ", date=" + date + ", image=" + image + "]";
	}
	public BlogPost() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
