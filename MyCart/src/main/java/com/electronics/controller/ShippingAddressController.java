package com.electronics.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronics.model.BillingAddress;
import com.electronics.model.CartItems;
import com.electronics.model.Product;
import com.electronics.model.ShippingAddress;
import com.electronics.model.User;
import com.electronics.service.BillingAddressService;
import com.electronics.service.CartItemsService;
import com.electronics.service.ProductService;
import com.electronics.service.ShippingAddressService;
import com.electronics.service.UserService;



@Controller
public class ShippingAddressController
{
	
	@Autowired
	ShippingAddressService shippingAddressService;
	
	@Autowired
	private CartItemsService cartItemsService; 
	
	@Autowired
	ProductService productService;
	
	@Autowired
	BillingAddressService billingAddressService;
	
	@Autowired
	 private SessionFactory sessionFactory;
	
	@Autowired
	UserService userService;

	@RequestMapping("/shippingaddress-{productId}-{quantity}")
	public String getShippingAddressPage(Authentication auth,Model model,@PathVariable("productId") int productId,@PathVariable("quantity") int quantity) 
	{
		
		if(auth!=null)
		{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();	
		model.addAttribute("buttonLabel","Submit");
		model.addAttribute("message",1);
		model.addAttribute("msg","PQ");
		
		model.addAttribute("shippingAddress", new ShippingAddress());
		return "shippingAddress";
		}
		
	
		else
		{
			model.addAttribute("message", " Please Login!");
			return "login";	
		}
		
	}
	
	
	
	@RequestMapping("/shippingaddress")
	public String getShippingAddressPagee(Authentication auth,Model model) 
	{
		
		if(auth!=null)
		{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();	
		
		
				
		model.addAttribute("buttonLabel","Submit");
		model.addAttribute("message",1);
		model.addAttribute("msg","C");
		
		model.addAttribute("shippingAddress", new ShippingAddress());
		return "shippingAddress";
		}
		
		else
		{
			model.addAttribute("message", " Please Login!");
			return "login";	
		}
		
	}

	
	@RequestMapping("/addshippingaddress-{productId}-{quantity}")
	public String addShippingAddress(@Valid @ModelAttribute("shippingAddress")ShippingAddress shippingAddress, BindingResult result, Model model,Authentication auth,@PathVariable("productId") int productId,@PathVariable("quantity") int quantity)
	{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		
		if(result.hasErrors())
			
		{  		
			model.addAttribute("msg","PQ");
			model.addAttribute("PRODUCTID",productId);
			model.addAttribute("QUANTITY",quantity);
			model.addAttribute("buttonLabel","Submit");

			return "shippingAddress";
		}
		
		model.addAttribute("msg","PQ");
		model.addAttribute("PRODUCTID",productId);
		model.addAttribute("QUANTITY",quantity);
		model.addAttribute("buttonLabel","Submit");

		shippingAddressService.addShippingAddress(shippingAddress,userId);
		
		return "redirect:/confirmorder-{productId}-{quantity}";
	}
	
	
	@RequestMapping("/addshippingaddress")
	public String addShippingAddresss(@Valid @ModelAttribute("shippingAddress")ShippingAddress shippingAddress, BindingResult result, Model model,Authentication auth)
	{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		
		if(result.hasErrors())
			
		{  	
			model.addAttribute("message",0);
			model.addAttribute("msg","C");
			//model.addAttribute("CARTITEMSID",cartItemsId);
			model.addAttribute("buttonLabel","Submit");

			return "shippingAddress";
		}
		
		
		model.addAttribute("msg","C");
		//model.addAttribute("CARTITEMSID",cartItemsId);
		
		model.addAttribute("buttonLabel","Submit");

		shippingAddressService.addShippingAddress(shippingAddress,userId);
		
		return "redirect:/confirmorder";
	}
	

	

	@RequestMapping("/editshippingaddress-{productId}-{quantity}")
	public String editShippingAddress( Model model,Authentication auth,@PathVariable("productId") int productId,@PathVariable("quantity") int quantity)
	{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		
		//model.addAttribute("message",0);
		
		model.addAttribute("msg","PQ");
		model.addAttribute("PRODUCTID",productId);
		model.addAttribute("QUANTITY",quantity);
		
		model.addAttribute("shippingAddress", shippingAddressService.getShippingAddressById(userId));
		model.addAttribute("buttonLabel","Update");
	
		return "shippingAddress";
	}
	
	
	@RequestMapping("/editshippingaddress")
	public String editShippingAddresss( Model model,Authentication auth)
	{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		
		//model.addAttribute("message",0);
		model.addAttribute("msg","C");
		//model.addAttribute("CARTITEMSID",cartItemsId);
		
		
		model.addAttribute("shippingAddress", shippingAddressService.getShippingAddressById(userId));
		model.addAttribute("buttonLabel","Update");
	
		return "shippingAddress";
	}
	
	
	@RequestMapping("/confirmorder")
	public String getConfirmOrderPage( Authentication auth, Model model) 
	{
		
		if(auth!=null)
		{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();
		
		try
		{
			BillingAddress b=billingAddressService.getBillingAddressById(userId);
			ShippingAddress s=shippingAddressService.getShippingAddressById(userId);

			if(b!=null && s!=null)
			{
		
		List<CartItems> l=cartItemsService.getAllCartItemsByFlag(false, userId);
		for(CartItems c:l)
			
		{
			c.setFlag(true);
			cartItemsService.addCartItem(c);
		}
		
		List<CartItems> list=cartItemsService.getAllCartItemsByFlag(true, userId);
		
		model.addAttribute("cc",list);
		
		 model.addAttribute("BILLING", billingAddressService.getBillingAddressById(userId));

			
		 model.addAttribute("SHIPPING", shippingAddressService.getShippingAddressById(userId));
			
		
		model.addAttribute("FROM","CARTLIST");
		return "confirmOrderSummary";
		
		
		}
				
		}
		catch(Exception e)
		{
			try
			{
				BillingAddress b=billingAddressService.getBillingAddressById(userId);
				//ShippingAddress s=shippingAddressService.getShippingAddressById(userId);
                
				if(b!=null)
				return "redirect:/shippingaddress";
			}
                
				catch(Exception f)
				{
					return "redirect:/billingaddress";
				
				}
                
				
		}
		
		
		}
		else
		{
			
			model.addAttribute("message", " Please Login!");
			return "login";	
		}
		return null;
		
		
	}

	

	
		@RequestMapping("/confirmorder-{productId}-{quantity}")
	public String getConfirmOrderPagee( Model model,Authentication auth,HttpSession session,@PathVariable("productId") int productId,@PathVariable("quantity") int quantity)
	{
		
		if(auth!=null)
		{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();	
		
		
		try
		{
			BillingAddress b=billingAddressService.getBillingAddressById(userId);
			ShippingAddress s=shippingAddressService.getShippingAddressById(userId);

			if(b!=null && s!=null)
			{
				Product product= productService.getProductById(productId);
				 double amount=quantity*(product.getProductPrice()-(product.getProductPrice()*product.getProductDiscountPrice()/100));
				 
				 model.addAttribute("QUANTITY", quantity);
				 model.addAttribute("AMOUNT", amount);
				 model.addAttribute("PRODUCT", product);
				 model.addAttribute("PRODUCTID", productId);
				 
				 model.addAttribute("FROM", "BUYNOW");
					

				 model.addAttribute("BILLING", billingAddressService.getBillingAddressById(userId));
				
					
				 model.addAttribute("SHIPPING", shippingAddressService.getShippingAddressById(userId));
					
				 return "confirmOrderSummary";
			
			}
		}
				 
					catch(Exception e)
					{
						try
						{
							BillingAddress b=billingAddressService.getBillingAddressById(userId);
							//ShippingAddress s=shippingAddressService.getShippingAddressById(userId);
			                
							if(b!=null)
							return "redirect:/shippingaddress-{productId}-{quantity}";
						}
			                
							catch(Exception f)
							{
								return "redirect:/billingaddress-{productId}-{quantity}";
							
							}
			                
							
					}

				}
		
		
		else
		{
			
			model.addAttribute("message", " Please Login!");
			return "login";	
		}
		return null;
	
				
			
	}

	}
