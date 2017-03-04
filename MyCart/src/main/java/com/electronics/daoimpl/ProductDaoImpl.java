package com.electronics.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electronics.dao.ProductDao;
import com.electronics.model.Product;


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

}
