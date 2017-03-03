package com.electronics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.electronics.daoimpl.CategoryDaoImpl;
import com.electronics.model.Category;

@Service
	public class CategoryService 
	{
		
		@Autowired
	   private CategoryDaoImpl categoryDAOImpl;
	   
		@Transactional
		public void addCategory(Category category)
		{
			categoryDAOImpl.addCategory(category);
		}
		
		@Transactional
		public List<Category> getAllCategories() 
		{
		return categoryDAOImpl.getAllCategories();
		}
		
		
		
		
		@Transactional
		public Category getCategoryById(int categoryId)
		{
			return categoryDAOImpl.getCategoryById(categoryId);
		}
		
		@Transactional
		public void deleteCategory(int categoryId)
		{
			categoryDAOImpl.deleteCategory(categoryId);
		}
		
		
	}
		

	
