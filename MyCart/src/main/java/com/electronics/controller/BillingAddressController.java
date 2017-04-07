package com.electronics.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronics.model.BillingAddress;
import com.electronics.model.User;
import com.electronics.service.BillingAddressService;
import com.electronics.service.UserService;

@Controller
public class BillingAddressController
{
	@Autowired
	BillingAddressService billingAddressService;
	
	@Autowired
	UserService userService;
    
	
	@RequestMapping("/billingaddress-{productId}-{quantity}")
	public String getBillingAddressPage(Authentication auth, Model model, HttpSession session, @PathVariable("productId") int productId,@PathVariable("quantity") int quantity) 
	{
		
		if(auth!=null)
		{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		model.addAttribute("buttonLabel","Submit");
		model.addAttribute("message",0);
		session.setAttribute("productId",productId);
		session.setAttribute("quantity",quantity);
		model.addAttribute("billingAddress", new BillingAddress());
		return "billingAddress";
		}
		else
		{
			
			model.addAttribute("message", " Please Login!");
			return "login";	
		}
	
		
	}
	
	
	
	@RequestMapping("/billingaddress-{cartItemsId}")
	public String getBillingAddressPagee(Authentication auth, Model model,@PathVariable("cartItemsId") int cartItemsId,HttpSession session) 
	{
		
		if(auth!=null)
		{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		model.addAttribute("buttonLabel","Submit");
		model.addAttribute("message",0);
		session.setAttribute("cartItemsId",cartItemsId);
		model.addAttribute("billingAddress", new BillingAddress());
		return "billingAddress";
		}
		else
		{
			
			model.addAttribute("message", " Please Login!");
			return "login";	
		}
	
		
	}
	
	
	
	@RequestMapping("/addbillingaddress")
	public String addBillingAddress(@Valid @ModelAttribute("billingAddress")BillingAddress billingAddress,Authentication auth, BindingResult result, Model model)
	{
		
		//if(auth!=null)
		//{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		
		
		if(result.hasErrors())
			
		{  
			model.addAttribute("message",0);
			//model.addAttribute("billingAddressList", billingAddress.getAllBillingAddress());
			model.addAttribute("buttonLabel","Add BillingAddress");
			model.addAttribute("buttonLabel","Submit");

			return "billingAddress";
		}
		
		model.addAttribute("buttonLabel","Submit");
          
		model.addAttribute("message",0);
		billingAddressService.addBillingAddress(billingAddress,userId);
		return "redirect:/shippingaddress";
	//}
		//return "redirect:/billingaddress";
	
	}
	
	
	@RequestMapping("/editbillingaddress")
	public String editBillingAddress( Model model,Authentication auth)
	{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		model.addAttribute("billing", billingAddressService.getBillingAddressById(userId));
		model.addAttribute("buttonLabel","Update");
	
		return "billingAddress";
	}
	
	
	
}
