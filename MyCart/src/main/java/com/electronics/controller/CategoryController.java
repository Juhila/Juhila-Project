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
		model.addAttribute("category",new Category());
		model.addAttribute("categoryList", categoryService.getAllCategories());
		return "categoryPage";
	}
	
	
	
	@RequestMapping("/addcategory")
	public String addCategory(@Valid @ModelAttribute("category") Category category,BindingResult result)
	{
		if(result.hasErrors())
		{
			return "categoryPage";
		}
		categoryService.addCategory(category);
		return "redirect:/category";
	}
	
	
	@RequestMapping("/editcategory-{categoryId}")
	public String getCategoryById(@PathVariable("categoryId") int categoryId, Model model)
	{
	   model.addAttribute("category",categoryService.getCategoryById(categoryId));
	   model.addAttribute("categoryList", categoryService.getAllCategories());
		return "categoryPage";
	}
	
	@RequestMapping("/deletecategory-{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int categoryId)
	{
		
		categoryService.deleteCategory(categoryId);
		return "redirect:/category";
	}
}

