package com.electronics.controller;

import java.util.List;

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
import com.electronics.model.Product;
import com.electronics.model.ShippingAddress;
import com.electronics.model.User;
import com.electronics.service.BillingAddressService;
import com.electronics.service.CartItemsService;
import com.electronics.service.ProductService;
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
	
	@Autowired
	ProductService productService;
	
	@Autowired
	private CartItemsService cartItemsService; 
	
	
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

			double a=0;
			double d=0;
			
			if(b!=null && s!=null)
			{
				
		
		/**List<CartItems> cartlist=cartItemsService.getAllCartItemsByFlag(false, userId);
		for(CartItems c:cartlist)
			
		{
			
			c.setFlag(true);
			//d=c.getAmount();
			//a=a+d;
		
			cartItemsService.addCartItem(c);
		}
		
		
		
		List<CartItems> orderedlist=cartItemsService.getAllCartItemsByFlag(true, userId);
		
		for(CartItems cc:orderedlist)
		{
			d=cc.getAmount();
			a=a+d;
		
		}**/
		
		List<CartItems> orderedlist=cartItemsService.getAllCartItemsByFlag(false, userId);

		for(CartItems cc:orderedlist)
			
		{
			
			d=cc.getAmount();
			a=a+d;
			
		}
		
		model.addAttribute("orderedlist",orderedlist);
		model.addAttribute("total", a);

		
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
			return "redirect:/login";	
		}
		return null;
		
		
	}

	

	
		@RequestMapping("/confirmorder-{productId}-{quantity}")
	public String getConfirmOrderPagee( Model model,Authentication auth,@PathVariable("productId") int productId,@PathVariable("quantity") int quantity)
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
							{	
							 
							return "redirect:/shippingaddress-{productId}-{quantity}";
						}
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
			return "redirect:/login";	
			//return login;
		}
		return null;

	
				
			
	}


	
	@RequestMapping("/payment-{total}")
	public String makePayment(Authentication auth, Model model,@PathVariable("total") int total)
	{
		if(auth!=null)
		{  
			
			double a=0;
			double b=0;
			int finalStock=0;
			User user= userService.getUserByUserName(auth.getName());	
			int userId=user.getUserId();
			
			List<CartItems> cartlist=cartItemsService.getAllCartItemsByFlag(false, userId);
			for(CartItems c:cartlist)
				
			{
				
				c.setFlag(true);
				
				cartItemsService.addCartItem(c);
			}
			
			
			
			List<CartItems> finalorderedlist=cartItemsService.getAllCartItemsByFlag(true, userId);
			
			for(CartItems cc:finalorderedlist)
			{    

				a=cc.getAmount();
				b=a+b;
				
				int pId=cc.getProductId();
				int pQ=cc.getProductQuantity();
				
				Product p=productService.getProductById(pId);
				int stock=p.getProductStock();
				
				finalStock=stock-pQ;
				
				p.setProductStock(finalStock);
				
				productService.addProduct(p);
			}
			
			model.addAttribute("total",b);

			model.addAttribute("finalorderedlist",finalorderedlist);
			//model.addAttribute("finalStock", finalStock);
				
			
			model.addAttribute("FROM","CARTLIST");
			return "finalOrderSummary";
			
			
			}
					
		

		else
		{
			model.addAttribute("message", " Please  Login First!");
			return "redirect:/login";
		}
		
		

	}
	
	
	@RequestMapping("/payment-{productId}-{quantity}")
	public String makePayment(Authentication auth, Model model, @PathVariable("productId") int productId,@PathVariable("quantity") int quantity)
	{
		if(auth!=null)
		{
			int finalStock=0;
			User user= userService.getUserByUserName(auth.getName());	
			int userId=user.getUserId();
			
			Product p=productService.getProductById(productId);
          int stock=  p.getProductStock();
          
          finalStock=stock-quantity;
          p.setProductStock(finalStock);
          
          model.addAttribute("PRODUCT", p);
          model.addAttribute("QUANTITY", quantity);
          
			
			//model.addAttribute("finalStock", finalStock);
				
			
			model.addAttribute("FROM","BUYNOW");
			return "finalOrderSummary";
			
			
		}
		else
		{
			model.addAttribute("message", " Please  Login First!");
			return "redirect:/login";
		}

	

	}

}
