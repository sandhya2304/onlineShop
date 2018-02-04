package com.myecom.onshop_backend.test;


import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myecom.onshop_backend.dao.CategoryDao;
import com.myecom.onshop_backend.dto.Category;


public class CategoryTest
{
	
	private static AnnotationConfigApplicationContext context;
	
	
	private static CategoryDao categoryDao;
	
	private Category category;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.myecom.onshop_backend");
		context.refresh();
		
		categoryDao=(CategoryDao) context.getBean("categoryDao");
		
		
	}
	
	/*@Test
	public void addTestCategory()
	{
		category=new Category();
		category.setName("bpl");
		category.setDescription("this is bpl laptop");
		category.setImageURL("imag.png");
		
		assertEquals("not succesully added",true,categoryDao.addCategory(category));
		
	}
*/
/*	@Test
	public void addGetCategory()
	{
		category=categoryDao.get(1);
		
		assertEquals("not added single","Laptop",category.getName());
	}
	
	
	
	@Test
	public void testupdateCategory()
	{
		category=categoryDao.get(1);
		
		category.setName("suno");
		
		assertEquals("not added single",true,categoryDao.updateCategory(category));
	}
	
	@Test
	public void testdeleteCategory()
	{
		category=categoryDao.get(1);
	
		
		assertEquals("not added single",true,categoryDao.deleteCategory(category));
	}
	
	@Test
	public void testListCategory()
	{
		assertEquals("not added single",2,categoryDao.listAll().size());
	}
	
	@Test
	public void testCrudCategory()
	{
		
		//add the category
		category=new Category();
		category.setName("bpl");
		category.setDescription("this is bpl laptop");
		category.setImageURL("imag.png");
		
		assertEquals("not succesully added",true,categoryDao.addCategory(category));
		
		
		//update
        category=categoryDao.get(1);
		
		category.setName("dekho");
		
		assertEquals("not added single",true,categoryDao.updateCategory(category));
		
		
		//deelete the category
		assertEquals("not added single",true,categoryDao.deleteCategory(category));
		
		//list alll 
		assertEquals("not added single",2,categoryDao.listAll().size());
		
		
	}
	*/
	
}
