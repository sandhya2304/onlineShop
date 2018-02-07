package com.myecom.onshop_backend.dao;

import java.util.List;

import com.myecom.onshop_backend.dto.Product;

public interface ProductDao
{
	
	List<Product> list();
	Product get(int productId);
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	
	//business methods

	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int caregoryId);
	List<Product> getLatestActiveProducts(int count);

}
