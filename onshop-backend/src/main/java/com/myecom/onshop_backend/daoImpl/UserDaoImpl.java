package com.myecom.onshop_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myecom.onshop_backend.dao.UserDao;
import com.myecom.onshop_backend.dto.Address;
import com.myecom.onshop_backend.dto.Cart;
import com.myecom.onshop_backend.dto.User;


@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addAddress(Address address) {
      
		try
		{
			
			sessionFactory.getCurrentSession().persist(address);
			return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		
		
	}

	@Override
	public boolean addUser(User user) {
		 
		try
		{
			
			sessionFactory.getCurrentSession().persist(user);
			return true;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}

	

	@Override
	public User userGetByEmail(String email) {
		
		String query="from User where email =:email";
		try
		{		
			return sessionFactory.getCurrentSession()
					     .createQuery(query,User.class)
					          .setParameter("email",email).getSingleResult();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Address getBillingAddress(User user) {
	   
		String query="from Address where user =:user and billing =:billing";
		
		try
		{
			return sessionFactory
					 .getCurrentSession()
					       .createQuery(query,Address.class)
			                   .setParameter("user",user)
			                     .setParameter("billing",true)
			                       .getSingleResult();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public List<Address> listShippingAddress(User user) {
String query="from Address where user =:user and shipping =:shipping";
		
		try
		{
			return sessionFactory
					 .getCurrentSession()
					       .createQuery(query,Address.class)
			                   .setParameter("user",user)
			                     .setParameter("shipping",true)
			                       .getResultList();
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
	}
	
	

}
