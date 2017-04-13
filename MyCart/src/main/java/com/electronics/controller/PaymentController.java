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
public class PaymentController
{
	@Autowired
	ShippingAddressService shippingAddressService;
	
	@Autowired
	BillingAddressService billingAddressService;
	
	@Autowired
	UserService userService;
	
	
	
	@RequestMapping("/payment")
	public String makePayment(Authentication auth, Model model)
	{
		if(auth!=null)
		{
			//CartItems c=cartItemsService.getCartItemById(cartItemsId);
			//c.setFlag(false);
			
			//cartItemsService.addCartItem(c);
			
			model.addAttribute("message", "Item is successfully Removed");
			return "redirect:/confirmorder";
		}
		else
		{
			model.addAttribute("message", " Please  Login First!");
			return "redirect:/login";
		}
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
