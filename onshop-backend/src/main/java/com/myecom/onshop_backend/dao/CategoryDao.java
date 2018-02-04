package com.myecom.onshop_backend.dao;

import java.util.List;

import com.myecom.onshop_backend.dto.Category;

public interface CategoryDao
{
	
	public List<Category> listAll();

	public Category get(int id);
	
	public boolean addCategory(Category category);
	
	public boolean updateCategory(Category category);
	
	public boolean deleteCategory(Category category);
	
	

}
