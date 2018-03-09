package com.myecom.onlineshop.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.myecom.onlineshop.model.RegisterModel;
import com.myecom.onshop_backend.dao.UserDao;
import com.myecom.onshop_backend.dto.*;

public class RegisterHandler 
{
	
 @Autowired
 private UserDao userDAO;
 @Autowired
 private BCryptPasswordEncoder passwordEncoder;
 
 public RegisterModel init() { 
  return new RegisterModel();
 } 
 public void addUser(RegisterModel registerModel, User user) {
  registerModel.setUser(user);
 } 
 public void addBilling(RegisterModel registerModel, Address billing) {
  registerModel.setBilling(billing);
 }

 public String validateUser(User user, MessageContext error) {
  String transitionValue = "success";
   if(!user.getPassword().equals(user.getConfirmPassword())) {
    error.addMessage(new MessageBuilder().error().source(
      "confirmPassword").defaultText("Password does not match confirm password!").build());
    transitionValue = "failure";    
   }  
   if(userDAO.userGetByEmail(user.getEmail())!=null) {
    error.addMessage(new MessageBuilder().error().source(
      "email").defaultText("Email address is already taken!").build());
    transitionValue = "failure";
   }
  return transitionValue;
 }
 
 public String saveAll(RegisterModel registerModel) {
  String transitionValue = "success";
  User user = registerModel.getUser();
  if(user.getRole().equals("USER")) {
   // create a new cart
   Cart cart = new Cart();
   cart.setUser(user);
   user.setCart(cart);
  }
   
  // encode the password
  user.setPassword(passwordEncoder.encode(user.getPassword()));
  
  // save the user
  userDAO.addUser(user);
  // save the billing address
  Address billing = registerModel.getBilling();
  billing.setUser(user);
  billing.setBilling(true);  
  userDAO.addAddress(billing);
  return transitionValue ;
 } 
}

