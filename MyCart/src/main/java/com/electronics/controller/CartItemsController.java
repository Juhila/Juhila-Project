package com.electronics.controller;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronics.model.CartItems;
import com.electronics.model.Product;
import com.electronics.model.User;
import com.electronics.service.CartItemsService;
import com.electronics.service.CartItemsService;
import com.electronics.service.ProductService;
import com.electronics.service.UserService;

@Controller

public class CartItemsController
{
	
	
	
		@Autowired
		private CartItemsService cartItemsService; 
		
		@Autowired
		private UserService userService;
		
		@Autowired
		private ProductService productService;
		
		@RequestMapping("/cartitems")
		public String getCartItemsPage(Authentication auth,Model model)
		{
			if(auth!=null)
			{
			User user= userService.getUserByUserName(auth.getName());	
			int userId=user.getUserId();	
			model.addAttribute("cartItemsListByJson", cartItemsService.getAllCartItemsByJson(userId));
			//model.addAttribute("cartItemsLists", cartItemsService.getAllCartItemsByFlag(false, userId));

			return "cartItems";
			}
			else
			{
				model.addAttribute("message", " Please Login!");
				return "login";	
			}
		}
		
		@RequestMapping("/addtocartitems-{productId}-{quantity}")
		public String addToCartItems(@PathVariable("productId")int productId, @PathVariable("quantity")int quantity,Authentication auth, Model model,@ModelAttribute("cartItems") CartItems cartItems)
		{
			Product product = productService.getProductById(productId);
			int stock=product.getProductStock();
			
			
			
			
			if(auth!=null && quantity>0  && stock!=0)
			{
				
				String username = auth.getName();
				User user = userService.getUserByUserName(username);
				int uId=user.getUserId();
				try
				{
				CartItems c=cartItemsService.findCartItemId(productId, uId);
				if(c!=null)
					
				{
					
				int p=c.getProductId();
				int u=c.getUserId();
				
				if(u==uId && p==productId)
					
				{
					
				
				int q=c.getProductQuantity();
					try
					{
					if((q+quantity)<=3)
					{
					
						q=q+quantity;
						c.setProductQuantity(q);
					
						int price = c.getProductPrice();
						int discountprice = c.getProductDiscount();
						double amountperitem =q*(price-(price*discountprice/100));
						
						//double a=c.getAmount();
						c.setAmount(amountperitem);
						cartItemsService.addCartItem(c);
						return "redirect:/cartitems";
					
				}
					}
					
					catch(Exception e)
					{
						model.addAttribute("message","cartlistquantity");
						return  "404Page";
					}
				
				
			
                }
			  }
			}
		
			
			
	catch(Exception e)
	{
		int rate = product.getProductPrice();
		int discount = product.getProductDiscountPrice();
		double amountperitem = rate-(rate*discount/100);
			
		cartItems.setCartId(user.getUserId());
		cartItems.setUserId(user.getUserId());
			
		cartItems.setUserName(user.getUsername());
			
		cartItems.setProductName(product.getProductName());
		cartItems.setProductId(product.getProductId());
		cartItems.setProductPrice(product.getProductPrice());
		cartItems.setProductDiscount(discount);
		cartItems.setProductQuantity(quantity);
		cartItems.setAmount(amountperitem * quantity);
		cartItems.setFlag(false);
		Long l=System.currentTimeMillis();
		Date d= new Date(l);
			
		cartItems.setOrderDate(d);
			
		cartItemsService.addCartItem(cartItems);
			
		model.addAttribute("message", "Item is Successfully Added To Cart");
		return "redirect:/cartitems";
			}
			}
			
			
			else
			{
				
				if(quantity<=0)
				{
				model.addAttribute("message", " entered quantity is wrong");
				return "redirect:/viewproduct-"+productId;
				}
				if(auth==null)
				{
			model.addAttribute("message", "Please Login!");
			return "redirect:/login";
				}
			}
			
			return "null";
			
		}
		
		@RequestMapping("/deletefromcartitems-{cartItemsId}")
		public String deleteFromCartItems(@PathVariable("cartItemsId")int cartItemsId,Authentication auth, Model model)
		{
			if(auth!=null)
			{
				cartItemsService.deleteCartItem(cartItemsId);
				model.addAttribute("message", "Item is successfully Removed From Cart");
				return "redirect:/cartitems";
			}
			else
			{
				model.addAttribute("message", " Please  Login First!");
				return "redirect:/login";
			}
		}
		
		
 	}
	

