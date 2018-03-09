package com.myecom.onshop_backend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myecom.onshop_backend.dao.CategoryDao;
import com.myecom.onshop_backend.dto.Category;

@Transactional
@Repository("categoryDao")  
public class CategoryDaoImpl implements CategoryDao
{
	@Autowired
     private SessionFactory sessionFactory;	

	@Override
	public List<Category> listAll() 
	{
		
		String selectActiveCategory="From Category where active =:x";
		
		Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("x",true);
		
		return query.getResultList();
	}
	
	/*
	 * 
	 * get single category based on id
	 */

	@Override
	public Category get(int id) 
	{		
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));  
	}

	@Override
	
	public boolean addCategory(Category category)
	{
         try
         {
        	 sessionFactory.getCurrentSession().persist(category);
        	 return true;
        	 
         }catch(Exception e)
         {
        	 e.printStackTrace();
        	 return false;
     	}
         
    }

	/*
	 * updating a single category
	 * (non-Javadoc)
	 * @see com.myecom.onshop_backend.dao.CategoryDao#updateCategory(com.myecom.onshop_backend.dto.Category)
	 */
	@Override
	public boolean updateCategory(Category category) {
		
		 try
         {
        	 sessionFactory.getCurrentSession().update(category);
        	 return true;
        	 
         }catch(Exception e)
         {
        	 e.printStackTrace();
        	 return false;
     	}
	}

	@Override
	public boolean deleteCategory(Category category) {
		
		category.setActive(false);
		
		 try
         {
        	 sessionFactory.getCurrentSession().update(category);
        	 return true;
        	 
         }catch(Exception e)
         {
        	 e.printStackTrace();
        	 return false;
     	}
	}
	
	
		

}
