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
		
		@RequestMapping("/cartlist")
		public String getCartItemsPage(Authentication auth,Model model)
		{
			if(auth!=null)
			{
			User user= userService.getUserByUserName(auth.getName());	
			int userId=user.getUserId();	
			model.addAttribute("cartItemsListByJson", cartItemsService.getAllCartItemsByJson(userId));
			return "cartItems";
			}
			else
			{
				model.addAttribute("message", " Please Login!");
				return "login";	
			}
		}
		
		@RequestMapping("/addtocartlist-{productId}-{quantity}")
		public String addToCart(@PathVariable("productId")int productId, @PathVariable("quantity")int quantity,Authentication auth, Model model,@ModelAttribute("cartItems") CartItems cartItems)
		{
			Product product = productService.getProductById(productId);
			int stock=product.getProductStock();
			
			if(auth!=null && quantity>0 && stock!=0)
			{
			String username = auth.getName();

			
			
			User user = userService.getUserByUserName(username);
			
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
			return "redirect:/cart";
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
			return null;
			
		}
		
		@RequestMapping("/deletefromcartlist-{cartItemsId}")
		public String deleteFromCart(@PathVariable("cartItemsId")int cartItemsId,Authentication auth, Model model)
		{
			if(auth!=null)
			{
				cartItemsService.deleteCartItem(cartItemsId);
				model.addAttribute("message", "Item is successfully Removed From Cart");
				return "redirect:/cart";
			}
			else
			{
				model.addAttribute("message", " Please  Login First!");
				return "redirect:/login";
			}
		}
		
		
	@RequestMapping("/checkoutfromcartlist-{cartItemsId}")
		public String checkoutFromCart(@PathVariable("cartItemsId")int cartItemsId,Authentication auth, Model model)
		{
			if(auth!=null)
			{
				CartItems item = cartItemsService.getCartItemById(cartItemsId);
				Product product = productService.getProductById(item.getProductId());
				//int quantity=item.getProductQuantity();
			  //int stock=product.getProductStock();
			  
	
				
				if(item.getFlag()==false)
				{
					
				//int finalstock=stock-quantity;
				//product.setProductStock(finalstock);
				//productService.addProduct(product);
				item.setFlag(true);
				
				cartItemsService.addCartItem(item);
				return "redirect:/cart";
				}
				
				
				return "redirect:/cart";
				}
				
	
			else
			{
				model.addAttribute("message", "Please Login!");
				return "redirect:/login";
			}
		}
		
	}
	
