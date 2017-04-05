package com.electronics.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronics.model.Brand;
import com.electronics.service.UserService;

@Controller
public class BillingAddress
{
	@Autowired
	UserService userService;

	@RequestMapping("/billingaddress")
	public String getBillingAddressPage(Model model) 
	{
		model.addAttribute("billingAddress", new BillingAddress());
		
		return "billingAddress";
	}
	
	
	@RequestMapping("/addbillingaddress")
	public String addBrand(@Valid @ModelAttribute("billingAddress")BillingAddress billingAddress, BindingResult result, Model model)
	{
		
		if(result.hasErrors())
			
		{  
			
			//model.addAttribute("billingAddressList", billingAddress.getAllBillingAddress());
			
			return "billingAddress";
		}
		//billingAddressService.addBillingAddress(billingAddress);
		return "redirect:/billingaddress";
	}
	
}
