package com.myecom.onshop_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myecom.onshop_backend.dao.ProductDao;
import com.myecom.onshop_backend.dto.Product;

public class ProductTestCase
{

	private static AnnotationConfigApplicationContext context;

	
	private static ProductDao productDao;
	
	private Product product;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.myecom.onshop_backend");
		
		context.refresh();
		productDao=(ProductDao) context.getBean("productDao");
		
	}
	/*
	@Test
	public void testProductlist()
	{
		assertEquals("something goes wrong to show",5,productDao.list().size());
	}
	*/
/*	@Test
	public void testProductAdd()
	{
		product=new Product();
		product.setName("Oppo Selfie");
		product.setBrand("Oppo");
		product.setDescription("this is oppro brand product");
		product.setUnitPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("something goes wrong",true,productDao.add(product));
		
	}*/
	/*@Test
	public void testProductUpdate(){
		
		product=productDao.get(3);
		product.setName("Google Pixel");
		
		
		assertEquals("something goes wrong with update",true,productDao.update(product));
		
	}
	*/
	/*@Test
	public void testCrudProduct()
	{
		product=new Product();
		product.setName("Tech mahindra");
		product.setBrand("MAhindra");
		product.setDescription("this is omahindra brand product");
		product.setUnitPrice(5000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("something goes wrong",true,productDao.add(product));
		
		product=productDao.get(5);
		product.setName("Not dell");
		//for update
		assertEquals("something goes wrong",true,productDao.update(product));
		
		assertEquals("something goes wrong",7,productDao.list().size());
		
	}
	
*/
	@Test
	public void deleteProduct()
	{
	
		product=productDao.get(33);
		assertEquals("something goes wrong delete",true,productDao.delete(product));
	}
	
}
