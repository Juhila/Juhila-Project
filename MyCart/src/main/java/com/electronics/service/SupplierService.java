package com.electronics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electronics.daoimpl.SupplierDaoImpl;
import com.electronics.model.Supplier;

@Service
@Transactional
public class SupplierService 
{
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	
	public List<Supplier> getAllSuppliers()
	{
		return supplierDaoImpl.getAllSuppliers();
	}
	
	public Supplier getSupplierById(int supplierId)
	{
		return supplierDaoImpl.getSupplierById(supplierId);
	}

	public void addSupplier(Supplier supplier)
	{
		supplierDaoImpl.addSupplier(supplier);
	}
	
	public void deleteSupplier(int supplierId)
	{
		supplierDaoImpl.deleteSupplier(supplierId);
	}
	
	public String getAllSuppliersByJson() 
	{
	return supplierDaoImpl.getAllSuppliersByJson();
	}
	
	public void enableDisableSupplier(int supplierId)
	{
		
		supplierDaoImpl.enableDisableSupplier(supplierId);
	}
	
	
}
