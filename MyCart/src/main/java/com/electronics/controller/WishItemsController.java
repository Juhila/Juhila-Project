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
import com.electronics.model.WishItems;
import com.electronics.service.CartItemsService;
import com.electronics.service.ProductService;
import com.electronics.service.UserService;
import com.electronics.service.WishItemsService;

@Controller
public class WishItemsController
{
	@Autowired
	private WishItemsService wishItemsService; 
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/wishitems")
	public String getWishItemsPage(Authentication auth,Model model)
	{
		
		model.addAttribute("H", "HELLLOOOOO");
		if(auth!=null)
		{
		User user= userService.getUserByUserName(auth.getName());	
		int userId=user.getUserId();	
		model.addAttribute("wishItemsListByJson", wishItemsService.getAllWishItemsByJson(userId));
		return "wishItems";
		}
		else
		{
			model.addAttribute("message", " Please Login!");
			return "login";	
		}
	}
	
	@RequestMapping("/addtowishitems-{productId}-{quantity}")
	public String addToWishItems(@PathVariable("productId")int productId, @PathVariable("quantity")int quantity,Authentication auth, Model model,@ModelAttribute("wishItems") WishItems wishItems)
	{
		
		model.addAttribute("H", "HELLLOOOOO");
		Product product = productService.getProductById(productId);
		//int stock=product.getProductStock();
		
		if(auth!=null && quantity>0)
		{
		String username = auth.getName();

		
		
		User user = userService.getUserByUserName(username);
		
		int rate = product.getProductPrice();
		int discount = product.getProductDiscountPrice();
		double amountperitem = rate-(rate*discount/100);
		
		wishItems.setCartId(user.getUserId());
		wishItems.setUserId(user.getUserId());
		
		wishItems.setUserName(user.getUsername());
		
		wishItems.setProductName(product.getProductName());
		wishItems.setProductId(product.getProductId());
		wishItems.setProductPrice(product.getProductPrice());
		wishItems.setProductDiscount(discount);
		wishItems.setProductQuantity(quantity);
		wishItems.setAmount(amountperitem * quantity);
		
		Long l=System.currentTimeMillis();
		Date d= new Date(l);
		
		wishItems.setOrderDate(d);
		
		wishItemsService.addWishItem(wishItems);
		
		model.addAttribute("message", "Item is Successfully Added To WishList");
		return "redirect:/wishitems";
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
	
	@RequestMapping("/deletefromwishitems-{wishItemsId}")
	public String deleteFromWishItems(@PathVariable("wishItemsId")int wishItemsId,Authentication auth, Model model)
	{
		if(auth!=null)
		{
			wishItemsService.deleteWishItem(wishItemsId);
			model.addAttribute("message", "Item is successfully Removed From WishItems");
			return "redirect:/wishitems";
		}
		else
		{
			model.addAttribute("message", " Please  Login First!");
			return "redirect:/login";
		}
	}
	
	
}