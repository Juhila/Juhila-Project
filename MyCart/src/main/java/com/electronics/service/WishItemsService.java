package com.electronics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electronics.daoimpl.CartItemsDaoImpl;
import com.electronics.daoimpl.WishItemsDaoImpl;
import com.electronics.model.CartItems;
import com.electronics.model.WishItems;

@Service
@Transactional
public class WishItemsService 
{
	
		@Autowired
		WishItemsDaoImpl wishItemsDaoImpl;
		
		public String getAllWishItemsByJson(int userId)
		{
			return wishItemsDaoImpl.getAllWishItemsByJson(userId);
		}
		
		public List<WishItems> getAllWishItems(int userId)
		{
			return wishItemsDaoImpl.getAllWishItems(userId);
		}
		public WishItems getWishItemById(int wishItemsId)
		{
			return wishItemsDaoImpl.getWishItemById(wishItemsId);
		}
		
		public void addWishItem(WishItems wishItems)
		{
			wishItemsDaoImpl.addWishItem(wishItems);
		}

		public void deleteWishItem(int wishItemsId)
		{
			wishItemsDaoImpl.deleteWishItem(wishItemsId);
		}
		
		
		public WishItems findWishItemId(int productId, int userId)
		{
			return wishItemsDaoImpl.findWishItemId(productId, userId);
		}
		
	}
	

	
