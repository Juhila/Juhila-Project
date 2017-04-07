package com.electronics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electronics.daoimpl.BillingAddressDaoImpl;
import com.electronics.daoimpl.ShippingAddressDaoImpl;
import com.electronics.model.BillingAddress;
import com.electronics.model.ShippingAddress;

@Transactional
@Service
public class ShippingAddressService
{
	@Autowired
	private ShippingAddressDaoImpl shippingAddressDaoImpl;
		
		

		public void addShippingAddress(ShippingAddress shippingAddress, int userId)
		{
			
			shippingAddressDaoImpl.addShippingAddress(shippingAddress, userId);
		}

		public ShippingAddress getShippingAddressById(int userId)
		
		{
			return shippingAddressDaoImpl.getShippingAddressById(userId);
			
		}
}
