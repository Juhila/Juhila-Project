package com.electronics.dao;

import java.util.List;

import com.electronics.model.Product;

public interface ProductDao
{
	public List<Product> getAllProducts();
	public Product getProductById(int productId);
	public String getAllProductsByJson();
	public void addProduct(Product product);
	public void deleteProduct(int productId);
}
