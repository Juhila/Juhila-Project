package com.electronics.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electronics.dao.BillingAddressDao;
import com.electronics.dao.ShippingAddressDao;
import com.electronics.model.BillingAddress;
import com.electronics.model.ShippingAddress;


@Repository
public class ShippingAddressDaoImpl implements ShippingAddressDao
{
	@Autowired
	 private SessionFactory sessionFactory;

	public void addShippingAddress(ShippingAddress shippingAddress, int userId) 
	{
		Session session=sessionFactory.getCurrentSession();
		
		//BillingAddress billingAddresss=new BillingAddress();
		  shippingAddress.setShippingAddressId(userId);
		  shippingAddress.setUserId(userId);
		  session.saveOrUpdate(shippingAddress);
		 
		  

	}

	public ShippingAddress getShippingAddressById(int userId) 
	{
		List <ShippingAddress> shipping = sessionFactory.getCurrentSession().createQuery("from ShippingAddress where userId = "+userId).getResultList();
		return shipping.get(0);
	
		
	}
}
