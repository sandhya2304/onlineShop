package com.myecom.onlineshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myecom.onshop_backend.dao.ProductDao;
import com.myecom.onshop_backend.dto.Product;


//this controller is created only to return data in the form of json format

@Controller
@RequestMapping(value="/json/data")
public class JsonDataController 
{
	@Autowired
	private ProductDao productDao;
	
	@RequestMapping(value="/all/products")
	@ResponseBody              // so automatically it will look for a converter that we already added in ourclass path
	                           //this entrire product will return in form on json if add this annotation
	public List<Product> allProduct()
	{
		return productDao.listActiveProducts();
	}
	
	@RequestMapping(value="/admin/all/products")
	@ResponseBody              
	public List<Product> allProductForAdmin()
	{
		return productDao.list();
	}
	

	@RequestMapping(value="/category/{id}/products")
	@ResponseBody             
	public List<Product> allProductbycatgeory(@PathVariable int id)
	{
		return productDao.listActiveProductsByCategory(id);
	}

}
