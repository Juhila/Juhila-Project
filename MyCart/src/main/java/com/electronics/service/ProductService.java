package com.electronics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electronics.daoimpl.ProductDaoImpl;
import com.electronics.model.Product;

@Service
	@Transactional
	public class ProductService 
	{
		
	@Autowired
	ProductDaoImpl productDaoImpl;
		
		public List<Product> getAllProducts()
		{
			return productDaoImpl.getAllProducts();
		}
		public Product getProductById(int productId)
		{
			return productDaoImpl.getProductById(productId);
		}
		
		public void addProduct(Product product)
		{
			productDaoImpl.addProduct(product);
		}
		public void deleteProduct(int productId)
		{
			productDaoImpl.deleteProduct(productId);
		}
		
		public String getAllProductsByJson() 
		{
		return productDaoImpl.getAllProductsByJson();
		}
		
	}
	

