package com.electronics.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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

public class PaymentController
{
	@Autowired
	ShippingAddressService shippingAddressService;
	
	@Autowired
	BillingAddressService billingAddressService;
	
	@Autowired
	UserService userService;

	@RequestMapping("/payment")
	public String getPaymentPage(Authentication auth,Model model) 
	{
		
		/**if(auth!=null)
		{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();	
		
		
		try
		{
			ShippingAddress s=shippingAddressService.getShippingAddressById(userId);


			if(s!=null)
			{
 
		model.addAttribute("shippingAddress",  shippingAddressService.getShippingAddressById(userId));
		 model.addAttribute("billingAddress",  billingAddressService.getBillingAddressById(userId));
		return "paymentGateway";
			
		}
		}
		
		catch(Exception e)
		{  
			
		model.addAttribute("shippingAddress", new ShippingAddress());

		model.addAttribute("buttonLabel","Submit");
		model.addAttribute("message",1);
			return "shippingAddress";
		}
		
		
		}
		
		else
		{
			model.addAttribute("message", " Please Login!");
			return "login";	
		}
		return null;**/
		
		
		return "paymentGateway";
	}
	
	
	@RequestMapping("/addpayment")
	public String addPayment( Model model,Authentication auth)
	{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		

		//paymentService.addShippingAddress(shippingAddress,userId);
		
		return "redirect:/ordersummary";
	}
	
	

}
