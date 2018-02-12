package com.myecom.onlineshop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myecom.onlineshop.utility.FileUploadUtility;
import com.myecom.onlineshop.validator.ProductValidator;
import com.myecom.onshop_backend.dao.*;
import com.myecom.onshop_backend.dto.Category;
import com.myecom.onshop_backend.dto.Product;

@Controller
@RequestMapping(value="/manage")
public class ManagementController
{
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	private static final Logger logger=LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false)String operation )
	{
		ModelAndView mv=new ModelAndView("page");
		
		mv.addObject("title","manage Products");
		mv.addObject("userClickManageProducts",true);
		
		Product nProduct=new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product",nProduct);
		
		 if(operation!=null)
		 {
			 
			 if(operation.equals("product"))
			 {
				 mv.addObject("message","Product submited sucessfully!!!");
			 }
			 else if(operation.equals("category"))
			 {
				 mv.addObject("message","Category submited sucessfully!!!");
			 }
		 }	
		
		return mv;
	}
	
	
	@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id )
	{
		ModelAndView mv=new ModelAndView("page");
		
		mv.addObject("title","manage Products");
		mv.addObject("userClickManageProducts",true);
		
		//fetch the product from db
		Product fProduct=productDao.get(id);
		//set the product fetch  from db
		mv.addObject("product",fProduct);
		
		
		return mv;
	}
	
	
	
	
	
	
	
	//returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDao.listAll();
	}
	
	@ModelAttribute("category")
	public Category getCatgeory()
	{
		return new Category();
	}
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission (@Valid @ModelAttribute("product")Product mProduct,BindingResult result,
			Model model,HttpServletRequest request)
	{
		
		if(mProduct.getId() == 0)
		{
		  new ProductValidator().validate(mProduct,result);
		}
		else
		{
			if(!mProduct.getFile().getOriginalFilename().equals(""))
			{
				new ProductValidator().validate(mProduct,result);
			}
		}
		  
		  
		//check if there errors
		if(result.hasErrors())
		{
			model.addAttribute("title","manage Products");
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("message","validation failed for product submission!!");
			
			return "page";
		}
		
		logger.info(mProduct.toString());
		
		if(mProduct.getId() == 0)
		{
			//cerate a new product if id is 0
		   productDao.add(mProduct);
		}
		else
		{
			//update the product if available id not 0
			productDao.update(mProduct);
		}
		
		//for image
		if(!mProduct.getFile().getOriginalFilename().equals(""))
		{
			
			FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public String handleCategorySubmiison(@ModelAttribute Category category)
	{
		categoryDao.addCategory(category);
		
		return "redirect:/manage/products?operation=category";
	}
	
	@RequestMapping(value="/product/{id}/activation",method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id)
	{
		//fetch product from db
		Product product=productDao.get(id);
		
		boolean active=product.isActive();
		//activating and deactivating based on value of field
		product.setActive(!product.isActive());
		//updating the product
		productDao.update(product);
		
		return (active)?"you have succesfully deactivated the product"+product.getId()
		                :"you have succesfully activated the product"+product.getId() ;
		
	}
}
