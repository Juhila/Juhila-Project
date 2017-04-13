package com.electronics.controller;

import java.util.List;

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
import com.electronics.model.CartItems;
import com.electronics.model.ShippingAddress;
import com.electronics.model.User;
import com.electronics.service.BillingAddressService;
import com.electronics.service.CartItemsService;
import com.electronics.service.ShippingAddressService;
import com.electronics.service.UserService;

@Controller
public class BillingAddressController
{
	@Autowired
	BillingAddressService billingAddressService;
	
	@Autowired
	ShippingAddressService shippingAddressService;
	
	
	@Autowired
	UserService userService;
	
	@Autowired
	private CartItemsService cartItemsService; 
	
    
	
	@RequestMapping("/billingaddress-{productId}-{quantity}")
	public String getBillingAddressPage( @PathVariable("productId") int productId,@PathVariable("quantity") int quantity, Authentication auth, Model model,HttpSession session) 
	{
		
		if(auth!=null)
		{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		model.addAttribute("buttonLabel","Submit");
		model.addAttribute("message",1);
		
		
		
		model.addAttribute("msg","PQ");
		model.addAttribute("PRODUCTID",productId);
		model.addAttribute("QUANTITY",quantity);
		
		model.addAttribute("billingAddress", new BillingAddress());
		return "billingAddress";
		}
		else
		{
			
			model.addAttribute("message", " Please Login!");
			return "login";	
		}
	
		
	}
	
	
	
	@RequestMapping("/billingaddress")
	public String getBillingAddressPagee(Authentication auth, Model model) 
	{
		
		if(auth!=null)
		{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		model.addAttribute("buttonLabel","Submit");
		model.addAttribute("message",1);
		
		
		
		model.addAttribute("msg","C");
		//model.addAttribute("CARTITEMSID",cartItemsId);
		
		model.addAttribute("billingAddress", new BillingAddress());
		return "billingAddress";
		}
		else
		{
			
			model.addAttribute("message", " Please Login!");
			return "login";	
		}
	
		
	}
	
	
	
	@RequestMapping("/addbillingaddress-{productId}-{quantity}")
	public String addBillingAddress(@Valid @ModelAttribute("billingAddress") BillingAddress billingAddress,BindingResult result,Authentication auth,Model model, @PathVariable("productId") int productId,@PathVariable("quantity") int quantity)
	{
		
		//if(auth!=null)
		//{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		
		
		if(result.hasErrors())
			
		{  
			model.addAttribute("message",0);
			model.addAttribute("msg","PQ");
			model.addAttribute("PRODUCTID",productId);
			model.addAttribute("QUANTITY",quantity);
			
			model.addAttribute("buttonLabel","Add BillingAddress");
			model.addAttribute("buttonLabel","Submit");

			return "billingAddress";
		}
		
		model.addAttribute("buttonLabel","Submit");
          
		model.addAttribute("message",0);
		model.addAttribute("msg","PQ");
		model.addAttribute("PRODUCTID",productId);
		model.addAttribute("QUANTITY",quantity);
		
		billingAddressService.addBillingAddress(billingAddress,userId);
		return "redirect:/shippingaddress-{productId}-{quantity}";
	
	
	}
	
	
	
	@RequestMapping("/addbillingaddress")
	public String addBillingAddresss(@Valid @ModelAttribute("billingAddress")BillingAddress billingAddress,BindingResult result, Authentication auth, Model model)
	{
		
		
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		
		
		if(result.hasErrors())
			
		{  
			model.addAttribute("message",0);
			model.addAttribute("msg","C");
			//model.addAttribute("CARTITEMSID",cartItemsId);
			
			
			model.addAttribute("buttonLabel","Submit");

			return "billingAddress";
		}
		
		model.addAttribute("buttonLabel","Submit");
          
		model.addAttribute("message",0);
		model.addAttribute("msg","C");
		//model.addAttribute("CARTITEMSID",cartItemsId);
		
		billingAddressService.addBillingAddress(billingAddress,userId);
		return "redirect:/shippingaddress";
	
	}
	
	

	
	@RequestMapping("/editbillingaddress-{productId}-{quantity}")
	public String editBillingAddress( Model model,Authentication auth, @PathVariable("productId") int productId,@PathVariable("quantity") int quantity)
	{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		
		//model.addAttribute("message",0);
		model.addAttribute("msg","PQ");
		model.addAttribute("PRODUCTID",productId);
		model.addAttribute("QUANTITY",quantity);
		
		model.addAttribute("billingAddress", billingAddressService.getBillingAddressById(userId));
		model.addAttribute("buttonLabel","Update");
	    
		return "billingAddress";
	}
	
	@RequestMapping("/editbillingaddress")
	public String editBillingAddress( Model model,Authentication auth)
	{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		
		//model.addAttribute("message",0);
		model.addAttribute("msg","C");
		
	//	model.addAttribute("CARTITEMSID",cartItemsId);
		model.addAttribute("billingAddress", billingAddressService.getBillingAddressById(userId));
		model.addAttribute("buttonLabel","Update");
	    
		return "billingAddress";
	}
	
			
}
