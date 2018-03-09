package com.myecom.onlineshop.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.myecom.onlineshop.model.UserModel;
import com.myecom.onshop_backend.dao.UserDao;
import com.myecom.onshop_backend.dto.User;

@ControllerAdvice
public class GlobalController
{
	@Autowired
	HttpSession session;
	
	@Autowired
	UserDao userDao;
	
	UserModel userModel=null;
	
	@ModelAttribute("userModel")
	public UserModel getUserModel()
	{
		
		if(session.getAttribute("userModel")==null)
		{
			//add the user model
			Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
			
			User user=userDao.userGetByEmail(authentication.getName());
			
			if(user!=null)
			{
				//create a new usermodel object to pass the user details
				
				userModel=new UserModel();
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullname(user.getFirstName()+user.getLastName());
				
				if(userModel.getRole().equals("USER"))
				{
					//set cart only if user is buyer
					userModel.setCart(user.getCart());
				}
				
				//set the usermodel in session
				
				session.setAttribute("userModel",userModel);
				
				return userModel;
			}
			
			
		}
		
		return (UserModel) session.getAttribute("userModel");
		
	}

}
