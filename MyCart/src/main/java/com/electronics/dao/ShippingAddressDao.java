package com.electronics.dao;

import com.electronics.model.BillingAddress;
import com.electronics.model.ShippingAddress;

public interface ShippingAddressDao
{
	
	public void addShippingAddress(ShippingAddress shippingAddress,int userId);
	public ShippingAddress getShippingAddressById(int userId);


}
