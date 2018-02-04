package com.myecom.onlineshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myecom.onshop_backend.dao.CategoryDao;
import com.myecom.onshop_backend.dto.Category;


@Controller
public class PageController 
{
	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index(){
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Home");
		mv.addObject("categories",categoryDao.listAll());		
		mv.addObject("userClickHome",true);
		
		return mv;
		
	}
	

	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts(){
		
		ModelAndView mv=new ModelAndView("page");
		
		mv.addObject("title","All Products");
		
		//list of all catgeories
		mv.addObject("categories",categoryDao.listAll());	
		
		mv.addObject("userClickAllProducts",true);
		
		return mv;
		
	}
	
	

	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable int id){
		
		ModelAndView mv=new ModelAndView("page");
		
		//categorydao to fetch single categroy
		Category category=null;
		
		category=categoryDao.get(id);
			
		mv.addObject("title",category.getName());  //show in title name
		
		//list of all catgeories
		mv.addObject("categories",categoryDao.listAll());	
		
		//passing single category object
		mv.addObject("category",category);
		
		mv.addObject("userClickCategoryProducts",true);
		
		return mv;
		
	}
	

	@RequestMapping(value="/about")
	public ModelAndView about(){
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","about us");
		mv.addObject("userClickAbout",true);
		
		return mv;
		
	}
	

	@RequestMapping(value="/contact")
	public ModelAndView contact(){
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","contact us");
		mv.addObject("userClickcontact",true);
		
		return mv;
		
	}
	

	

}
