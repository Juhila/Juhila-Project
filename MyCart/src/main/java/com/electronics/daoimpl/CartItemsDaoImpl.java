package com.electronics.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electronics.dao.CartItemsDao;
import com.electronics.model.CartItems;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Repository
public class CartItemsDaoImpl implements CartItemsDao
{

	@Autowired
	SessionFactory sessionFactory;
	
	
	public String getAllCartItemsByJson(int userId) 
	{
		List<CartItems> cartList = sessionFactory.getCurrentSession().createQuery("from CartItems where userId="+userId+" and flag = FALSE").getResultList();
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(cartList);
	}
	
	
	public CartItems getCartItemById(int cartItemsId) 
	{
		List<CartItems> cartList = sessionFactory.getCurrentSession().createQuery("from CartItems where cartItemsId="+cartItemsId).getResultList();
		CartItems cartItems = cartList.get(0);
		return cartItems;
	}

	
	public void addCartItem(CartItems cartItems) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(cartItems);
	}

	
	public void deleteCartItem(int cartItemsId) 
	{
		CartItems cartItem = getCartItemById(cartItemsId);
		sessionFactory.getCurrentSession().delete(cartItem);
	}

	

}
