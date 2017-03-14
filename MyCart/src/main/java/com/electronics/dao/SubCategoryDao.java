package com.electronics.dao;

import java.util.List;

import com.electronics.model.Category;
import com.electronics.model.SubCategory;

public interface SubCategoryDao
{
	public void addSubCategory(SubCategory subCategory);
	public List<SubCategory> getAllSubCategories();
 
	public String getAllSubCategoriesByJson();

	public void deleteSubCategory(int subCategoryId);
	public SubCategory getSubCategoryById(int subCategoryId);
	//public SubCategory getSubCategoryByName(String subCategoryName);
}

