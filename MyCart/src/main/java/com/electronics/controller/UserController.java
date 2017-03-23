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

import com.electronics.model.Supplier;
import com.electronics.model.User;
import com.electronics.service.SupplierService;
import com.electronics.service.UserService;

@Controller
public class UserController 
{
	@Autowired
	UserService userService;

	@RequestMapping("/user")
	public String getUserPage(Model model) 
	{
		//model.addAttribute("userList", supplierService.getAllUsers());
		model.addAttribute("user", new User());
		//model.addAttribute("buttonLabel", "Add User");
		
		//model.addAttribute("userListByJson", userService.getAllUsersByJson());
		

		return "registration";
	}
	
	
	@RequestMapping("/adduser")
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
		//return "redirect:/user";
		return "redirect:/";
	}

	
	/**@RequestMapping("/edituser-{userId}")
	public String editUser(@PathVariable("userId") int userId, Model model) 
	{
		//model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("userListByJson", userService.getAllUsersByJson());
		model.addAttribute("user", userService.getUserById(userId));
		model.addAttribute("buttonLabel", "Update User");

		return "userPage";
	}**/
	
	@RequestMapping("/enableuser-{userId}")
	public String toggleUser(@PathVariable("userId") int userId)
	{
		userService.enableDisableUser(userId);
		
		return "redirect:/user";	
	}
	
	
	
	
	@RequestMapping("/userlist")
	public String getUserList(Model model) 
	{
		//model.addAttribute("userList", supplierService.getAllUsers());
		model.addAttribute("userListByJson", userService.getAllUsersByJson());
		
		return "userListPage";
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
	
	/**@RequestMapping("/register-adduser")
	public String addRegisterUser(@Valid @ModelAttribute("user") User user,BindingResult result, Model model) 
	{   
		if(result.hasErrors())
		{ 
			//model.addAttribute("userListByJson", userService.getAllUsersByJson());
			//model.addAttribute("supplierList", supplierService.getAllSuppliers());
		
			return "registration";
		}
		userService.addUser(user);
		return "login";
	}
**/

}
