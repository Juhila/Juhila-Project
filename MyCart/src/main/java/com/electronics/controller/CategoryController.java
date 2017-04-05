package com.electronics.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronics.model.Category;
import com.electronics.service.CategoryService;


@Controller
public class CategoryController 
{
	@Autowired
	CategoryService categoryService;
	
	
	
	@RequestMapping("/category")
	public String getCategoryPage(Model model)
	{
		model.addAttribute("buttonLabel","Add Category");
		model.addAttribute("category",new Category());
		//model.addAttribute("categoryList", categoryService.getAllCategories());
		model.addAttribute("categoryListByJson", categoryService.getAllCategoriesByJson());
		return "categoryPage";
	}
	
	
	
	@RequestMapping("/addcategory")
	public String addCategory(@Valid @ModelAttribute("category") Category category,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			
			//model.addAttribute("categoryList", categoryService.getAllCategories());
			model.addAttribute("categoryListByJson", categoryService.getAllCategoriesByJson());
			model.addAttribute("buttonLabel","Add Category");
			return "categoryPage";
		}
		categoryService.addCategory(category);
		return "redirect:/category";
	}
	
	
	@RequestMapping("/editcategory-{categoryId}")
	public String editCategory(@PathVariable("categoryId") int categoryId, Model model)
	{
		model.addAttribute("buttonLabel","Update Category");
	   model.addAttribute("category",categoryService.getCategoryById(categoryId));
	 //  model.addAttribute("categoryList", categoryService.getAllCategories());
	   model.addAttribute("categoryListByJson", categoryService.getAllCategoriesByJson());
		return "categoryPage";
	}
	
	@RequestMapping("/deletecategory-{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int categoryId)
	{
		
		categoryService.deleteCategory(categoryId);
		return "redirect:/category";
	}
}

