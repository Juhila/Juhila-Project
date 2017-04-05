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
		
		
		public List<Product> getAllProductsByCategoryId(int categoryId)
		{
			return productDaoImpl.getAllProductsByCategoryId(categoryId);
		}
		
		
		public List<Product> getAllProductsBySubCategoryId(int subCategoryId)
		{
			return productDaoImpl.getAllProductsBySubCategoryId(subCategoryId);
		}
		
		
		public List<Product> getAllProductsByBrandAndCategory(int brandId, int categoryId)
		{
		return productDaoImpl.getAllProductsByBrandAndCategory(brandId,  categoryId);
				
			
				}
		
		public List<Product> getAllProductsByBrandAndSubCategory(int brandId, int subCategoryId)
		{
		return productDaoImpl.getAllProductsByBrandAndSubCategory(brandId,  subCategoryId);
				
			
				}
		
		
		public List<Product>getAllProductsByPriceAndCategory(int number, int categoryId)
		{
			return productDaoImpl.getAllProductsByPriceAndCategory(number,  categoryId);
		}
	
		
		public List<Product>getAllProductsByPriceAndSubCategory(int number, int subCategoryId)
		{
			return productDaoImpl.getAllProductsByPriceAndSubCategory(number,  subCategoryId);
		}
		
		public List<Product>getAllProductsByDiscountPriceAndCategory(int number, int categoryId)
		{
			
			return productDaoImpl.getAllProductsByDiscountPriceAndCategory(number,  categoryId);
		}
		
		public List<Product>getAllProductsByDiscountPriceAndSubCategory(int number, int subCategoryId)
		{
			return productDaoImpl.getAllProductsByDiscountPriceAndSubCategory(number,  subCategoryId);
		}
		
		
		
		
		public List<Product> getAllTVProducts()
		{
		return productDaoImpl.getAllTVProducts();
				
			
		}
		
		
		public List<Product> getAllMobileProducts()
		{
		return productDaoImpl.getAllMobileProducts();
				
			
		}
		
		public List<Product> getAllRefrigeratorProducts()
		{
		return productDaoImpl.getAllRefrigeratorProducts();
				
			
		}
		
		
		public List<Product> getAllACProducts()
		{
		return productDaoImpl.getAllACProducts();
				
			
		}
		
		
		
	}

