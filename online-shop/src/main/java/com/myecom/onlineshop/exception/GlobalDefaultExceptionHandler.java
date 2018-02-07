package com.myecom.onlineshop.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler
{
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException()
	{
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle","This page is not constructed!!");
		mv.addObject("errorDescription","The page your are looking not available now!!!");
		mv.addObject("title","404 Error Page");
		
		return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView ProductNoHandlerFoundException()
	{
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle","Product not available!!");
		mv.addObject("errorDescription","The product your are looking not available now!!!");
		mv.addObject("title","404 Error Page");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle","Error!!!");
		mv.addObject("errorDescription",ex.toString());
		mv.addObject("title","Error");
		
		return mv;
	}

}
