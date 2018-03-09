package com.myecom.onshop_backend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myecom.onshop_backend.dao.CartLineDao;
import com.myecom.onshop_backend.dao.ProductDao;
import com.myecom.onshop_backend.dao.UserDao;
import com.myecom.onshop_backend.dto.Cart;
import com.myecom.onshop_backend.dto.CartLine;
import com.myecom.onshop_backend.dto.Product;
import com.myecom.onshop_backend.dto.User;

public class CartLineTestCase
{
	
	private static AnnotationConfigApplicationContext context;
	
	private static CartLineDao cartLineDao=null;
	
	private static UserDao userDao=null;
	
	private static ProductDao productDao=null;
	
	
	private Product product=null;
	private Cart cart=null;
	private User user=null;
	private CartLine cartLine=null;
	
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.myecom.onshop_backend");
		context.refresh();
		productDao=(ProductDao) context.getBean("productDao");
		userDao=(UserDao) context.getBean("userDao");
		cartLineDao=(CartLineDao) context.getBean("cartLineDao");
		
		
	}
	

	@Test
	public void test() 
	{
		// 1. get the user-->existing user
		user=userDao.userGetByEmail("kn@gmail.com");
				
		// 2. fetch the cart
		cart=user.getCart();
			
		//3.get the product--> any product you want to add
	    product= productDao.get(1);	
	    
	    //4.create a new cartLine
	    
	    cartLine=new CartLine();
   		
		cartLine.setBuyingPrice(product.getUnitPrice());
		
		cartLine.setProductCount(cartLine.getProductCount() +1);
		
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		
		cartLine.setCartId(cart.getId());
		
		cartLine.setAvailable(true);
		
		cartLine.setProduct(product);
		
		assertEquals("Failed to add the cartLine",true ,cartLineDao.add(cartLine));
		
		//Update the cart
		
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		
		cart.setCartLines(cart.getCartLines() +1);
		
		assertEquals("Failed to update the cart",true ,cartLineDao.updateCart(cart));
	}

}
