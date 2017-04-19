package com.electronics.controller;




import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronics.model.Product;
import com.electronics.model.User;
import com.electronics.service.BrandService;
import com.electronics.service.CategoryService;
import com.electronics.service.ProductService;
import com.electronics.service.SubCategoryService;
import com.electronics.service.UserService;

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
		   public String getHome(Model model)
		   {
			
			
          
			List<Product> productList=productService.getAllTVProducts();
			model.addAttribute("pList",productList);
            
			List<Product> productLists=productService.getAllMobileProducts();
			model.addAttribute("pLists",productLists);
            
			List<Product> productListss=productService.getAllRefrigeratorProducts();
			model.addAttribute("pListss",productListss);
            
			List<Product> productListsss=productService.getAllACProducts();
			model.addAttribute("pListsss",productListsss);
             
			
			return "home";
				
		   }
		
	
		
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


