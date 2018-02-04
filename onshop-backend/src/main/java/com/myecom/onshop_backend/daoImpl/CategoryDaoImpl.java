package com.myecom.onshop_backend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.myecom.onshop_backend.dao.CategoryDao;
import com.myecom.onshop_backend.dto.Category;


@Repository("categoryDao")  
public class CategoryDaoImpl implements CategoryDao
{
	
	List<Category> dummyData;

	@Override
	public List<Category> listAll() 
	{
		dummyData=new ArrayList<>();
		dummyData.add(new Category(1,"tv hd","Televisoin","img",true));
		dummyData.add(new Category(2,"fridge hd","Fridge","img",true));
		dummyData.add(new Category(3,"cart hd","Phone","img",true));
		
		return dummyData;
	}

	@Override
	public Category get(int id) 
	{
		for(Category category:dummyData)
		{
			if(category.getId()==id) return category; 
		}
		
		return null;  //if ther is no category particular to that id thate return null
	}

}
