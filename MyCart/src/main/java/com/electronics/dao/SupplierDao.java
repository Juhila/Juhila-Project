package com.electronics.dao;

import java.util.List;

import com.electronics.model.Supplier;

public interface SupplierDao
{
public List<Supplier> getAllSuppliers();
public Supplier getSupplierById(int supplierId);

public String getAllSuppliersByJson();
public void addSupplier(Supplier supplier);
public void deleteSupplier(int supplierId);
}