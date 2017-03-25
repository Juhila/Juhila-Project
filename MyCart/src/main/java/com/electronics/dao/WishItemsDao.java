package com.electronics.dao;

import com.electronics.model.WishItems;

public interface WishItemsDao
{
	
		public String getAllWishItemsByJson(int userId);
		public WishItems getWishItemById(int wishItemsId); 
		
		public void addWishItem(WishItems wishItems);
		public void deleteWishItem(int wishItemId);
	}