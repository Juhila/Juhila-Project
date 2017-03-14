package com.electronics.dao;

import java.util.List;

import com.electronics.model.Category;

public interface CategoryDao
{
	public void addCategory(Category category);
	public List<Category> getAllCategories();
	
	public String getAllCategoriesByJson();

	
	public void deleteCategory(int categoryId);
	public Category getCategoryById(int categoryId);
}


