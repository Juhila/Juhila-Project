package com.electronics.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	
		@RequestMapping("/")
		   public String getHome()
		   {
		    return "home";
		}
		
		
		@RequestMapping("/aboutUs")
		   public String getAboutUs()
		   {
		    return "aboutUs";
		}
		
		@RequestMapping("/contactUs")
		   public String getContactUs()
		   {
		    return "contactUs";
		}
		@RequestMapping("/FAQ")
		   public String getFAQ()
		   {
		    return "FAQ";
		}
		
		
		@RequestMapping("/register")
		   public String getRegister()
		   {
		    return "index";
		}
		
		@RequestMapping("/login")
		   public String getLogin()
		   {
		    return "index";
		}
		
		@RequestMapping("/admin")
		   public String getAdmin()
		   {
		    return "admin";
		}
		
	}


