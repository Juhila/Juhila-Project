package com.electronics.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electronics.dao.ProductDao;
import com.electronics.model.Product;
import com.electronics.model.SubCategory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;


	@Repository
public class ProductDaoImpl implements ProductDao
{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Product> getAllProducts() 
	{
		List<Product> productList = sessionFactory.getCurrentSession().createQuery("from Product").getResultList();
		return productList;
	}

	public Product getProductById(int productId)
	{
		List <Product> productList = sessionFactory.getCurrentSession().createQuery("from Product where productId = "+productId).getResultList();
		return productList.get(0);
	}
	
	
	


	public void addProduct(Product product)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}

	public void deleteProduct(int productId) 
	{
		
		sessionFactory.getCurrentSession().delete(getProductById(productId));
	}
	
	public String getAllProductsByJson() {
		List<Product> productList = sessionFactory.getCurrentSession().createQuery("from Product").getResultList();
		Gson g = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
				

		String list = g.toJson(productList);
		return list;
	}

	

	public List<Product> getAllProductsByCategoryId(int categoryId) {
		List <Product> productList = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = "+categoryId).getResultList();
		return productList;
	}

	

	public List<Product> getAllProductsBySubCategoryId(int subCategoryId) {
		List <Product> productList = sessionFactory.getCurrentSession().createQuery("from Product where subCategoryId = "+subCategoryId).getResultList();
		return productList;
	}

	public List<Product> getAllProductsByBrandAndCategory(int brandId, int categoryId) 
	{
		List <Product> productList = sessionFactory.getCurrentSession().createQuery("from Product where brandId = "+brandId+  "and categoryId="+categoryId).getResultList();
		return productList;
		
	}
  
	public List<Product> getAllProductsByBrandAndSubCategory(int brandId, int subCategoryId) 
	{
		List <Product> productList = sessionFactory.getCurrentSession().createQuery("from Product where brandId = "+brandId+  "and subCategoryId="+subCategoryId).getResultList();
		return productList;
		
	}
	
	
	}


