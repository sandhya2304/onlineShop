package com.myecom.onshop_backend.dao;

import java.util.List;

import com.myecom.onshop_backend.dto.*;

public interface UserDao
{
	
	public boolean addAddress(Address address);
	
	public Address getBillingAddress(User user);
	
	public List<Address> listShippingAddress(User user);
	
	public User userGetByEmail(String email);
	
	public boolean addUser(User user);
	
	
	

}
