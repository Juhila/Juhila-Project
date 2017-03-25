package com.electronics.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.electronics.model.Supplier;
import com.electronics.model.User;
import com.electronics.service.SupplierService;
import com.electronics.service.UserService;

@Controller
public class UserController 
{
	@Autowired
	UserService userService;

	@RequestMapping("/reg-user")
	public String getRegistrationPage(Model model) 
	{
		model.addAttribute("user", new User());
		
		return "registration";
	}
	
	
	@RequestMapping("/user")
	public String getUserPage(Model model) 
	{
		//model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("user", new User());
		
		
		model.addAttribute("userListByJson", userService.getAllUsersByJson());
		

		return "userListPage";
	}

	
	@RequestMapping(value="/reg-adduser",  method=RequestMethod.POST)
	public String addRegUser(@Valid @ModelAttribute("user") User user,BindingResult result, Model model) 
	{   
		if(result.hasErrors())
		{ 
		
		model.addAttribute("buttonLabel", "Retry");
			return "registration";
		}
		userService.addUser(user);
	
		return "redirect:/login";
	}

	
	
	@RequestMapping(value="/adduser",  method=RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("user") User user,BindingResult result, Model model) 
	{   
		if(result.hasErrors())
		{ 
			model.addAttribute("userListByJson", userService.getAllUsersByJson());
			
		model.addAttribute("buttonLabel", "Retry");
			return "userListPage";
		}
		userService.addUser(user);
		return "redirect:/user";
	}

	@RequestMapping("/edituser-{userId}")
	public String editUser(@PathVariable("userId") int userId, Model model) 
	{
		//model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("userListByJson", userService.getAllUsersByJson());
		model.addAttribute("user", userService.getUserById(userId));
		model.addAttribute("buttonLabel", "Update User");

		return "userListPage";
	}
	
	@RequestMapping("/enableuser-{userId}")
	public String toggleUser(@PathVariable("userId") int userId)
	{
		userService.enableDisableUser(userId);
		
		return "redirect:/user";	
	}
	
	
	
	
	@RequestMapping(value="/perform_logout")
	public String LogoutPage(HttpServletRequest request, HttpServletResponse response)
	{
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null)
		{
			new SecurityContextLogoutHandler().logout(request,response,auth);
		}
		return "redirect:/home";
		
	}
	
	@RequestMapping(value="/login")
	public String loginPage()
	{
		return "login";
	}
	

}
