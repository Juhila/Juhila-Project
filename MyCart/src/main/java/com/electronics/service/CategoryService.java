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
	   private CategoryDaoImpl categoryDaoImpl;
	   
		@Transactional
		public void addCategory(Category category)
		{
			categoryDaoImpl.addCategory(category);
		}
		
		@Transactional
		public List<Category> getAllCategories() 
		{
		return categoryDaoImpl.getAllCategories();
		}
		
		@Transactional
		public String getAllCategoriesByJson() 
		{
		return categoryDaoImpl.getAllCategoriesByJson();
		}
		
		
		
		@Transactional
		public Category getCategoryById(int categoryId)
		{
			return categoryDaoImpl.getCategoryById(categoryId);
		}
		
		@Transactional
		public void deleteCategory(int categoryId)
		{
			categoryDaoImpl.deleteCategory(categoryId);
		}
		
		
	}
		

	
