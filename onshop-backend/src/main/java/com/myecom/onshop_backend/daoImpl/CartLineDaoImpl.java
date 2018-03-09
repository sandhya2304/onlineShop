package com.myecom.onshop_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myecom.onshop_backend.dao.CartLineDao;
import com.myecom.onshop_backend.dto.Cart;
import com.myecom.onshop_backend.dto.CartLine;

@Repository("cartLineDao")
@Transactional
public class CartLineDaoImpl implements CartLineDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public CartLine get(int id)
	{
		return sessionFactory.getCurrentSession().get(CartLine.class,id);	
	}

	@Override
	public boolean delete(CartLine cartLine)
	{	
		try
		{
			sessionFactory.getCurrentSession().delete(cartLine);
			return true;
			
		}catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean add(CartLine cartLine) {
		try
		{
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
			
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public boolean update(CartLine cartLine) {

		try
		{
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
			
		}catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<CartLine> listAll(int cartId)
	{
	   String query="from CartLine where cartId=:cartId";
		
			return sessionFactory
					.getCurrentSession()
					   .createQuery(query,CartLine.class)
					    .setParameter("cartId",cartId)
			             .getResultList();
		
	}

	@Override
	public List<CartLine> listAvailable(int cartId) {
		String query="from CartLine where cartId=:cartId and available =:available";
		
		return sessionFactory
				.getCurrentSession()
				   .createQuery(query,CartLine.class)
				    .setParameter("cartId",cartId)
				    .setParameter("available",true)
		             .getResultList();
	
	}

	@Override
	public CartLine getByCartandProduct(int cartId, int productId)
	{
     String query="from CartLine where cartId=:cartId and product.id =:productId";
		
     try
     {
		return sessionFactory
				.getCurrentSession()
				   .createQuery(query,CartLine.class)
				    .setParameter("cartId",cartId)
				    .setParameter("productId",productId)
		             .getSingleResult();
     }
     catch(Exception e)
     {
    	 e.printStackTrace();
    	 return null;
     }
     
	}
	
	//related to cart
	@Override
	public boolean updateCart(Cart cart) {
		 
		try
		{
			
			sessionFactory.getCurrentSession().update(cart);
			return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	

}
