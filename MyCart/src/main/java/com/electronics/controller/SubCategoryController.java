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
import com.electronics.model.SubCategory;
import com.electronics.service.CategoryService;
import com.electronics.service.SubCategoryService;

@Controller
public class SubCategoryController 
{
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	
	@RequestMapping("/subcategory")
	public String getSubCategoryPage(Model model)
	{
		model.addAttribute("subCategory",new SubCategory());
		model.addAttribute("categoryList", categoryService.getAllCategories());
		//model.addAttribute("subCategoryList", subCategoryService.getAllSubCategories());
		model.addAttribute("subCategoryListByJson", subCategoryService.getAllSubCategoriesByJson());
		model.addAttribute("categoryListByJson", categoryService.getAllCategoriesByJson());
		
		model.addAttribute("buttonLabel","Add SubCategory");
		return "subCategoryPage";
	}
	
	
	
	@RequestMapping("/addsubcategory")
	public String addSubCategory(@Valid @ModelAttribute("subCategory") SubCategory subCategory,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
		model.addAttribute("categoryList", categoryService.getAllCategories());
		//model.addAttribute("subCategoryList", subCategoryService.getAllSubCategories());
			model.addAttribute("categoryListByJson", categoryService.getAllCategoriesByJson());
			model.addAttribute("subCategoryListByJson", subCategoryService.getAllSubCategoriesByJson());
			
			model.addAttribute("buttonLabel","Add SubCategory");
			return "subCategoryPage";
		}
		subCategoryService.addSubCategory(subCategory);
		return "redirect:/subcategory";
	}
	
	
	@RequestMapping("/editsubcategory-{subCategoryId}")
	public String editSubCategory(@PathVariable("subCategoryId") int subCategoryId, Model model)
	{
	   model.addAttribute("subCategory",subCategoryService.getSubCategoryById(subCategoryId));
	   model.addAttribute("categoryList", categoryService.getAllCategories());
	   model.addAttribute("buttonLabel","Update SubCategory");
	   
	   model.addAttribute("subCategoryListByJson", subCategoryService.getAllSubCategoriesByJson());
		
	   model.addAttribute("categoryListByJson", categoryService.getAllCategoriesByJson());
		
	  // model.addAttribute("subCategoryList", subCategoryService.getAllSubCategories());
		return "subCategoryPage";
	}
	
	@RequestMapping("/deletesubcategory-{subCategoryId}")
	public String deleteSubCategory(@PathVariable("subCategoryId") int subCategoryId)
	{
		
		subCategoryService.deleteSubCategory(subCategoryId);
		return "redirect:/subcategory";
	}
}

