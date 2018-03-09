package com.myecom.onlineshop.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myecom.onlineshop.model.UserModel;
import com.myecom.onshop_backend.dao.CartLineDao;
import com.myecom.onshop_backend.dao.ProductDao;
import com.myecom.onshop_backend.dto.Cart;
import com.myecom.onshop_backend.dto.CartLine;
import com.myecom.onshop_backend.dto.Product;

@Service("userService")
public class CartService 
{
	@Autowired
	private CartLineDao cartLineDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private HttpSession session;
	
	//return the cart of the user who has logged in
	public Cart getCart()
	{
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	//returns the entire cartLines
	public List<CartLine> getCartLines()
	{
		Cart cart=this.getCart(); //above method calling
		return cartLineDao.listAll(cart.getId());
		
		//write this way 1 line--> return cartLineDao.listAll(this.getCart().getId());
		
	}

	public String updateCartLine(int cartLineId, int count)
	{
		//fetch the cartLine
		
		CartLine cartLine=cartLineDao.get(cartLineId);
		if(cartLine == null)
		{
			return "result=error";
		}
		else
		{
			Product product=cartLine.getProduct();
			double oldTotal = cartLine.getTotal();
			
			if(product.getQuantity() <= count)
			{
				count=product.getQuantity();
			}
			
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * count);
			
			cartLineDao.update(cartLine);
			
			Cart cart=this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal +cartLine.getTotal());
			cartLineDao.updateCart(cart);
			
			
			return "result=updated";
		}
		
	}

	public String deleteCartLine(int cartLineId)
	{
		// fetch the cartLine
		
		CartLine cartLine=cartLineDao.get(cartLineId);
		
		if(cartLine == null)
		{		
			return "result=error";
		}
		else
		{
			
			Cart cart=this.getCart(); 
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			
			cartLineDao.updateCart(cart);
			
			//remove the cartLine 
			//first update the cart and then deleted
			cartLineDao.delete(cartLine);
			
			return "result=deleted";
			
		}

	}

	public String addCartLine(int productId)
	{
		String response = null;
        Cart cart=this.getCart();  // here getting cart from seesion
        
        CartLine cartLine=cartLineDao.getByCartandProduct(cart.getId(), productId);
        
        if(cart == null)
        {
        	//add a new cartLine
        	cartLine = new CartLine();
        	
        	//fetch the product
        	Product product=productDao.get(productId);
        	
        	cartLine.setCartId(cart.getId());
        	cartLine.setProduct(product);
        	cartLine.setBuyingPrice(product.getUnitPrice());
        	cartLine.setProductCount(1);
        	cartLine.setTotal(product.getUnitPrice());
        	cartLine.setAvailable(true);
        	
        	//now here we persisit the code
        	cartLineDao.add(cartLine);
        	
        	cart.setCartLines(cart.getCartLines() + 1);  //1 coz its new
        	cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
        	
        	cartLineDao.updateCart(cart);
        	
        	response= "result = added";
        	
        }
		
		
		return response;
	}

}
