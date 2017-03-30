package com.electronics.controller;




import javax.servlet.http.HttpSession;

import org.apache.tools.ant.taskdefs.condition.Http;
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
	
	
	
		@RequestMapping(value={"/","home"})
		   public String getHome()
		   {
			
		    // model.addAttribute("categoryList", categoryService.getAllCategories());
			//model.addAttribute("subCategoryList", subCategoryService.getAllSubCategories());
			
			//model.addAttribute("productList", productService.getAllProducts());
			//model.addAttribute("brandList", brandService.getAllBrands());
			return "home";
				
		}
		
	   
	
	
	/**

		@RequestMapping(value={"/","home"})
		   public String getHome(HttpSession session)
		   {
			
		     session.setAttribute("categoryList", categoryService.getAllCategories());
			session.setAttribute("subCategoryList", subCategoryService.getAllSubCategories());
			
			session.setAttribute("productList", productService.getAllProducts());
			session.setAttribute("brandList", brandService.getAllBrands());
			
		    return "home";
		}
		
		**/
		
		@RequestMapping("/404")
		   public String get404Page()
		   {
		    return "404Page";
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
		
		

		
}


