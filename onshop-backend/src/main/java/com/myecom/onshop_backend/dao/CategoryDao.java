package com.myecom.onshop_backend.dao;

import java.util.List;

import com.myecom.onshop_backend.dto.Category;

public interface CategoryDao
{
	
	public List<Category> listAll();

	public Category get(int id);
	
	
	
	

}
