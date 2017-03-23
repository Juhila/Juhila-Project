package com.electronics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.electronics.daoimpl.CategoryDaoImpl;
import com.electronics.model.Category;

@Transactional
@Service
	public class CategoryService 
	{
		
		@Autowired
	   private CategoryDaoImpl categoryDaoImpl;
	   
		
		public void addCategory(Category category)
		{
			categoryDaoImpl.addCategory(category);
		}
		
		
		public List<Category> getAllCategories() 
		{
		return categoryDaoImpl.getAllCategories();
		}
		
		
		public String getAllCategoriesByJson() 
		{
		return categoryDaoImpl.getAllCategoriesByJson();
		}
		
		
	
		
		public Category getCategoryById(int categoryId)
		{
			return categoryDaoImpl.getCategoryById(categoryId);
		}
		
		
		public void deleteCategory(int categoryId)
		{
			categoryDaoImpl.deleteCategory(categoryId);
		}
		
		
	}
		

	
