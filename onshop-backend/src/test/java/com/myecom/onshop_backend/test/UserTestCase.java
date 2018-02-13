package com.myecom.onshop_backend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myecom.onshop_backend.dao.UserDao;
import com.myecom.onshop_backend.dto.Address;
import com.myecom.onshop_backend.dto.Cart;
import com.myecom.onshop_backend.dto.User;

public class UserTestCase
{
	@Autowired
	public static AnnotationConfigApplicationContext context;
	
	
	@Autowired
	public static UserDao userDao;
	
	Address address;
	
	User user;
	
	Cart cart;
	
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.myecom.onshop_backend");
		context.refresh();
		
		userDao=(UserDao) context.getBean("userDao");
	
	}
	
	/*@Test
	public void testUserCrud()
	{
		Address billing=new Address("m77","abc","delhi","UP","India","20111",false,true);
		
		Address shipping=new Address("t99","zzz","jaipur","Pujnab","India","211",true,false);
	
		assertEquals("something goes worng",true,userDao.addAddress(shipping));
		
	}
	*/
	
/*	@Test
	public void testUserCrud()
	{
		User user=new User();
		user.setFirstName("Ram");
		user.setLastName("Sharma");
		user.setEmail("ram@gmail.com");
		user.setContactNumber("98730000");
		user.setRole("USER");
		user.setPassword("1234");
		
		//add the user
		assertEquals("something goes wrong",true,userDao.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		//link the user with the address using user id
		
		address.setUserId(user.getId());
		
		//failed to add biillling  address
		assertEquals("Failed to add address",true,userDao.addAddress(address));
		
		if(user.getRole().equals("USER"))
		{
			
			//create a cart for this user
			cart=new Cart();
			cart.setUser(user);
			
			assertEquals("Failed to add cart",true,userDao.addCart(cart));
			
			//create a shipping address for this user
			

			address = new Address();
			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
			address.setAddressLineTwo("Near Kudrat Store");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
			//set shipping to true
			address.setShipping(true);
			
			//link it with user
			
			address.setUserId(user.getId());
			

			//failed to add shiipping address
			assertEquals("Failed to add shipping address",true,userDao.addAddress(address));
			
		}
	}	
		*
		*/
	
	
	/*@Test
	public void testUserCrud()
	{
		User user=new User();
		user.setFirstName("Ram");
		user.setLastName("Sharma");
		user.setEmail("ram@gmail.com");
		user.setContactNumber("98730000");
		user.setRole("USER");
		user.setPassword("1234");
		
		
		
		if(user.getRole().equals("USER"))
		{
			
			//create a cart for this user
			cart=new Cart();
			cart.setUser(user);
			
			//attach cart with user
			user.setCart(cart);
			
		}
		
		assertEquals("Failed to add cart",true,userDao.addUser(user));
	
	}*/
	@Test
	public void testUpdateCart()
	{
		user=userDao.userGetByEmail("ram@gmail.com");
		
		cart=user.getCart();
		
		cart.setGrandTotal(7000);
		cart.setCartLines(2);
		
		assertEquals("Failed to update cart",true,userDao.updateCart(cart));
		
		
	}
	
	
	/*public void testAddAddress()
	{
		
	 
		//we need to add an user
		
		User user=new User();
		user.setFirstName("Ram");
		user.setLastName("Sharma");
		user.setEmail("ram@gmail.com");
		user.setContactNumber("98730000");
		user.setRole("USER");
		user.setPassword("1234");
		
		//add the user
		assertEquals("something goes wrong",true,userDao.addUser(user));
		
		// we are going to address

		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		//attach the use to the address
		address.setUser(user);
		
		
		assertEquals("failed to add billing address",true,userDao.addAddress(address));
		
		
		//we are also going to add shipping address
		
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		//set shipping to true
		address.setShipping(true);
		
		//here user not attached
		assertEquals("failed to add shipping address",true,userDao.addAddress(address));
		
	}*/
	
	/*@Test
	public void testAddAddress()
	{
		//es user pr ek aur address add kro
		user=userDao.userGetByEmail("ram@gmail.com");
		
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		//set shipping to true
		address.setShipping(true);
		
		//attahced the user to address
		address.setUser(user);
		
		//here user not attached
		assertEquals("failed to add shipping address",true,userDao.addAddress(address));
		
	}*/
	
	@Test
	public void testListAddress()
	{
		user=userDao.userGetByEmail("ram@gmail.com");
		
		assertEquals("failed to fecth list of shipping address",2,userDao.listShippingAddress(user).size());
		
		assertEquals("failed to fecth billing of address","Mumbai",userDao.getBillingAddress(user).getCity());
		
	}
	
	

}
