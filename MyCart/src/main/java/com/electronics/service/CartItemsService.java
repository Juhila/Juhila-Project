package com.electronics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electronics.daoimpl.CartItemsDaoImpl;
import com.electronics.model.CartItems;

@Service
@Transactional
public class CartItemsService 
{
	
		@Autowired
		CartItemsDaoImpl cartItemsDaoImpl;
		
		public String getAllCartItemsByJson(int userId)
		{
			return cartItemsDaoImpl.getAllCartItemsByJson(userId);
		}
		
		public CartItems getCartItemById(int cartItemsId)
		{
			return cartItemsDaoImpl.getCartItemById(cartItemsId);
		}
		
		public void addCartItem(CartItems cartItems)
		{
			cartItemsDaoImpl.addCartItem(cartItems);
		}

		public void deleteCartItem(int cartItemsId)
		{
			cartItemsDaoImpl.deleteCartItem(cartItemsId);
		}
		
		public CartItems findCartItemId(int productId, int userId)
		{
			return cartItemsDaoImpl.findCartItemId(productId, userId);
		}
		
		
	}
	

	
