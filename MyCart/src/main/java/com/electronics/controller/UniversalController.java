package com.electronics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.electronics.service.CartItemsService;
import com.electronics.service.CategoryService;
import com.electronics.service.SubCategoryService;
import com.electronics.service.UserService;

@ControllerAdvice
	public class UniversalController {

		@Autowired
		private CategoryService categoryService;
		
		@Autowired
		private SubCategoryService subCategoryService;
		
	
		
		
		
	//  ModelAttributes for the whole website	
		@ModelAttribute
		public void globalAttribute(Model model)
		{
	        
		
			model.addAttribute("categoryGlobalList", categoryService.getAllCategories());		
		
			
			model.addAttribute("subCategoryGlobalList", subCategoryService.getAllSubCategories());		
		
			
			
		}
		
	
	}


