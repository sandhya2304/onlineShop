package com.myecom.onshop_backend.dao;

import java.util.List;

import com.myecom.onshop_backend.dto.Cart;
import com.myecom.onshop_backend.dto.CartLine;

public interface CartLineDao
{
	public CartLine get(int id);  //cartLine use for single cartLine 
	
	public boolean delete(CartLine cartLine);
	
	public boolean add(CartLine cartLine);
	
	public boolean update(CartLine cartLine);
	
	
	public List<CartLine> listAll(int cartId);
	
	public List<CartLine>  listAvailable(int cartId);
	
	
	public CartLine getByCartandProduct(int cartId,int productId); //cartLine use for single cartLine 
	
	
	public boolean updateCart(Cart cart);

}
