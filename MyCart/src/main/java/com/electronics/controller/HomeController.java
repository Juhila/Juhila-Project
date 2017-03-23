package com.electronics.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronics.service.BrandService;
import com.electronics.service.CategoryService;
import com.electronics.service.ProductService;
import com.electronics.service.SubCategoryService;

@Controller
public class HomeController 
{

	@Autowired
	CategoryService categoryService;

	@Autowired
	SubCategoryService subCategoryService;

	@Autowired
	ProductService productService;

	@Autowired
	BrandService brandService;
	
	
		@RequestMapping("/")
		   public String getHome(Model model)
		   {
			
		     model.addAttribute("categoryListByJson", categoryService.getAllCategoriesByJson());
			model.addAttribute("subCategoryListByJson", subCategoryService.getAllSubCategoriesByJson());
			
			model.addAttribute("productListByJson", productService.getAllProductsByJson());
			model.addAttribute("brandListByJson", brandService.getAllBrandsByJson());
			
		    return "home";
		}
		
		
		@RequestMapping("/cart")
		public String getCart()
		{
			return "cart";
		}
		
		
		@RequestMapping("/aboutus")
		   public String getAboutUs()
		   {
		    return "aboutUs";
		}
		
		@RequestMapping("/contactus")
		   public String getContactUs()
		   {
		    return "contactUs";
		}
		@RequestMapping("/FAQ")
		   public String getFAQ()
		   {
		    return "FAQ";
		}
		
		
		/**@RequestMapping("/register")
		   public String getRegister()
		   {
		    return "registration";
		}
		
		@RequestMapping("/login")
		   public String getLogin()
		   {
		    return "login";
		}**/
		
		@RequestMapping("/admin")
		   public String getAdmin()
		   {
		    return "admin";
		}
		
	}


