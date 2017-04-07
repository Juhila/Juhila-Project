package com.electronics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electronics.daoimpl.BillingAddressDaoImpl;
import com.electronics.daoimpl.BrandDaoImpl;
import com.electronics.model.BillingAddress;

@Transactional
@Service
public class BillingAddressService 
{
@Autowired
private BillingAddressDaoImpl billingAddressDaoImpl;
	
	

	public void addBillingAddress(BillingAddress billingAddress, int userId)
	{
		
		billingAddressDaoImpl.addBillingAddress(billingAddress, userId);
	}
	
	public BillingAddress getBillingAddressById(int userId)
	
	{
		return billingAddressDaoImpl.getBillingAddressById(userId);
		
	}

	
}