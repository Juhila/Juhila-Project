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
	
	public List<Product> getAllProductsByCategoryId(int categoryId);
	public List<Product> getAllProductsBySubCategoryId(int subCategoryId);
	public List<Product> getAllProductsByBrandAndCategory(int brandId, int categoryId) ;
	public List<Product> getAllProductsByBrandAndSubCategory(int brandId, int subCategoryId) ;
	
	public List<Product>getAllProductsByPriceAndCategory(int number, int categoryId);
	public List<Product>getAllProductsByPriceAndSubCategory(int number, int subCategoryId);
	public List<Product>getAllProductsByDiscountPriceAndCategory(int number, int categoryId);
	public List<Product>getAllProductsByDiscountPriceAndSubCategory(int number, int subCategoryId);
	
	
	public List<Product> getAllTVProducts();
	public List<Product> getAllMobileProducts();
	public List<Product> getAllRefrigeratorProducts();
	public List<Product> getAllACProducts();
}
