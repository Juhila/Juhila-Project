package com.electronics.dao;

import com.electronics.model.BillingAddress;

public interface BillingAddressDao 
{
	public void addBillingAddress(BillingAddress billingAddress,int userId);
	public BillingAddress getBillingAddressById(int userId);

}
