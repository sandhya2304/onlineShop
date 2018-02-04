package com.myecom.onshop_backend.dto;

import java.io.Serializable;

public class Category implements Serializable
{
	
	private int id;
	private String description;
	private String name;
	private String imageURL;
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

}
