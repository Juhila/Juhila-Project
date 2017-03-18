package com.electronics.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronics.model.Supplier;
import com.electronics.model.User;
import com.electronics.service.SupplierService;
import com.electronics.service.UserService;

@Controller
public class UserController 
{
	@Autowired
	UserService userService;

	@RequestMapping("/register-user")
	public String getUserPage(Model model) 
	{
		//model.addAttribute("userList", supplierService.getAllUsers());
		model.addAttribute("user", new User());
		model.addAttribute("buttonLabel", "Add User");
		
		model.addAttribute("userListByJson", userService.getAllUsersByJson());
		

		return "registration";
	}
	
	
	@RequestMapping("/register-adduser")
	public String addUser(@Valid @ModelAttribute("user") User user,BindingResult result, Model model) 
	{   
		if(result.hasErrors())
		{ 
			//model.addAttribute("userListByJson", userService.getAllUsersByJson());
			//model.addAttribute("supplierList", supplierService.getAllSuppliers());
		
			model.addAttribute("buttonLabel", "Retry");
			return "registration";
		}
		userService.addUser(user);
		return "redirect:/register-user";
		//return "login";
	}

	
	@RequestMapping("/register-edituser-{userId}")
	public String editUser(@PathVariable("userId") int userId, Model model) 
	{
		//model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("userListByJson", userService.getAllUsersByJson());
		model.addAttribute("user", userService.getUserById(userId));
		model.addAttribute("buttonLabel", "Update Supplier");

		return "registration";
	}
	
	
}
