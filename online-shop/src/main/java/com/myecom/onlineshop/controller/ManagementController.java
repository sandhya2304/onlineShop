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
				 mv.addObject("message","Product submited sucefully!!!");
			 }
		 }	
		
		return mv;
	}
	//returning categories for all the request mapping
	@ModelAttribute("categories")
	public List<Category> getCategory()
	{
		return categoryDao.listAll();
	}
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public String handleProductSubmission (@Valid @ModelAttribute("product")Product mProduct,BindingResult result,
			Model model,HttpServletRequest request)
	{
		
		new ProductValidator().validate(mProduct,result);
		
		//check if there errors
		if(result.hasErrors())
		{
			model.addAttribute("title","manage Products");
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("message","validation failed for product submission!!");
			
			return "page";
		}
		
		logger.info(mProduct.toString());
		
		productDao.add(mProduct);
		
		//for image
		if(!mProduct.getFile().getOriginalFilename().equals(""))
		{
			
			FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
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
