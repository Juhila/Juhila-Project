package com.electronics.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electronics.dao.BillingAddressDao;
import com.electronics.model.BillingAddress;
import com.electronics.model.Brand;

@Repository
public class BillingAddressDaoImpl implements BillingAddressDao
{
	@Autowired
	 private SessionFactory sessionFactory;

	public void addBillingAddress(BillingAddress billingAddress, int userId) 
	{
		Session session=sessionFactory.getCurrentSession();
		
		//BillingAddress billingAddresss=new BillingAddress();
		  billingAddress.setBillingAddressId(userId);
		  billingAddress.setUserId(userId);
		  session.saveOrUpdate(billingAddress);
		 
		  

	}

	public BillingAddress getBillingAddressById(int userId) 
	{
		List <BillingAddress> billing = sessionFactory.getCurrentSession().createQuery("from BillingAddress where userId = "+userId).getResultList();
		return billing.get(0);
	
	}

}
