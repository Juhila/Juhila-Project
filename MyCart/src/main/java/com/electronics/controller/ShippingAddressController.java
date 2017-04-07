package com.electronics.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronics.model.BillingAddress;
import com.electronics.model.ShippingAddress;
import com.electronics.model.User;
import com.electronics.service.BillingAddressService;
import com.electronics.service.ShippingAddressService;
import com.electronics.service.UserService;

@Controller
public class ShippingAddressController
{
	
	@Autowired
	ShippingAddressService shippingAddressService;
	
	@Autowired
	BillingAddressService billingAddressService;
	
	@Autowired
	UserService userService;

	@RequestMapping("/shippingaddress")
	public String getShippingAddressPage(Authentication auth,Model model) 
	{
		
		if(auth!=null)
		{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();	
		
		
		try
		{
			BillingAddress b=billingAddressService.getBillingAddressById(userId);


			if(b!=null)
			{

		model.addAttribute("buttonLabel","Submit");
		model.addAttribute("message",0);
			model.addAttribute("shippingAddress", new ShippingAddress());
			return "shippingAddress";
			
		}
		}
		
		catch(Exception e)
		{   model.addAttribute("billingAddress", new BillingAddress());
		model.addAttribute("buttonLabel","Submit");
			model.addAttribute("message",1);
			return "billingAddress";
		}
		
		
		}
		
		else
		{
			model.addAttribute("message", " Please Login!");
			return "login";	
		}
		return null;
	}
	
	
	@RequestMapping("/addshippingaddress")
	public String addShippingAddress(@Valid @ModelAttribute("shippingAddress")ShippingAddress shippingAddress, BindingResult result, Model model,Authentication auth)
	{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		
		if(result.hasErrors())
			
		{  		
			
			model.addAttribute("buttonLabel","Submit");

			
			model.addAttribute("buttonLabel"," ShippingAddress");
			return "shippingAddress";
		}
		
		model.addAttribute("buttonLabel","Submit");

		shippingAddressService.addShippingAddress(shippingAddress,userId);
		
		return "redirect:/payment";
	}
	
	

	@RequestMapping("/editshippingaddress")
	public String editBillingAddress( Model model,Authentication auth)
	{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		model.addAttribute("shipping", shippingAddressService.getShippingAddressById(userId));
		model.addAttribute("buttonLabel","Update");
	
		return "shippingAddress";
	}
	

}
