package com.electronics.dao;

import java.util.List;

import com.electronics.model.CartItems;
import com.electronics.model.WishItems;

public interface WishItemsDao
{
	
		public String getAllWishItemsByJson(int userId);
		public List<WishItems> getAllWishItems(int userId);
		public WishItems getWishItemById(int wishItemsId); 
		
		public void addWishItem(WishItems wishItems);
		public void deleteWishItem(int wishItemId);
		public WishItems findWishItemId(int productId, int userId);
	}