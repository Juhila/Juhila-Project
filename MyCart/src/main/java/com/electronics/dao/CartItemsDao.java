package com.electronics.dao;

import java.util.List;

import com.electronics.model.CartItems;

public interface CartItemsDao
{
	
		public String getAllCartItemsByJson(int userId);
		public CartItems getCartItemById(int cartItemsId); 
		
		public void addCartItem(CartItems cartItems);
		public void deleteCartItem(int cartItemId);
		
		public CartItems findCartItemId(int productId, int userId);
		public List<CartItems> getAllCartItemsByFlag(boolean b, int userId);
}


