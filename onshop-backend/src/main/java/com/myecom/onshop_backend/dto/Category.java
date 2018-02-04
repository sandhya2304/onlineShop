package com.myecom.onshop_backend.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Category implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String description;
	private String name;
	@Column(name="image_url")
	private String imageURL;
	@Column(name="is_active")
	private boolean active =true;
	
	
	
	public Category(int id, String description, String name, String imageURL, boolean active) {
		super();
		this.id = id;
		this.description = description;
		this.name = name;
		this.imageURL = imageURL;
		this.active = active;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	//now encapsulation setter and getters
	
	
	public Category() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", description=" + description + ", name=" + name + ", imageURL=" + imageURL
				+ ", active=" + active + "]";
	}
	
	

}
