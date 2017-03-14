package com.electronics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electronics.daoimpl.CategoryDaoImpl;
import com.electronics.daoimpl.SubCategoryDaoImpl;
import com.electronics.model.SubCategory;


@Service
	public class SubCategoryService 
	{
		
	
		@Autowired
		   private SubCategoryDaoImpl subCategoryDaoImpl;
			
	   
		@Transactional
		public void addSubCategory(SubCategory subCategory)
		{
			subCategoryDaoImpl.addSubCategory(subCategory);
		}
		
		@Transactional
		public List<SubCategory> getAllSubCategories() 
		{
		return subCategoryDaoImpl.getAllSubCategories();
		}
		
		
		
		@Transactional
		public SubCategory getSubCategoryById(int subCategoryId)
		{
			return subCategoryDaoImpl.getSubCategoryById(subCategoryId);
		}
		
		@Transactional
		public void deleteSubCategory(int subCategoryId)
		{
			subCategoryDaoImpl.deleteSubCategory(subCategoryId);
		}
		
		@Transactional
		public String getAllSubCategoriesByJson() 
		{
		return subCategoryDaoImpl.getAllSubCategoriesByJson();
		}
		
		
	}
		


