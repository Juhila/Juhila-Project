package com.electronics.daoimpl;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electronics.dao.CategoryDao;
import com.electronics.model.Category;

	
@Repository
	public class CategoryDaoImpl implements CategoryDao
	{
		@Autowired
		private SessionFactory sessionFactory;
		
		public void addCategory(Category category)
		{
			
			sessionFactory.getCurrentSession().saveOrUpdate(category);
		
		}
		
		public void deleteCategory(int categoryId)
		{
			sessionFactory.getCurrentSession().delete(getCategoryById(categoryId));
			
		}
		
		
		public List<Category> getAllCategories() 
		{
			List<Category> categoryList = sessionFactory.getCurrentSession().createQuery("from Category").getResultList();
			return categoryList;
		}
		
		
	
		
		
		public Category getCategoryById(int categoryId)
		{
			
			String sql = "from Category where categoryId=" +categoryId;
			List<Category> list = sessionFactory.getCurrentSession().createQuery(sql).getResultList();
			
				return list.get(0);
			
		}
	}

