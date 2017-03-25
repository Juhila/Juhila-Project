package com.electronics.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electronics.dao.CartItemsDao;
import com.electronics.dao.WishItemsDao;
import com.electronics.model.CartItems;
import com.electronics.model.WishItems;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Repository
public class WishItemsDaoImpl implements WishItemsDao
{

	@Autowired
	SessionFactory sessionFactory;
	
	
	public String getAllWishItemsByJson(int userId) 
	{
		List<WishItems> wishList = sessionFactory.getCurrentSession().createQuery("from WishItems where userId="+userId).getResultList();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(wishList);
	}
	
	
	public WishItems getWishItemById(int wishItemsId) 
	{
		List<WishItems> wishList = sessionFactory.getCurrentSession().createQuery("from WishItems where wishItemsId="+wishItemsId).getResultList();
		WishItems wishItems = wishList.get(0);
		return wishItems;
	}

	
	public void addWishItem(WishItems wishItems) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(wishItems);
	}

	
	public void deleteWishItem(int wishItemsId) 
	{
		WishItems wishItem = getWishItemById(wishItemsId);
		sessionFactory.getCurrentSession().delete(wishItem);
	}


	

	

}
