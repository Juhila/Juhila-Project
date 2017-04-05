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

	public List<Product> getAllProductsByPriceAndCategory(int number, int categoryId) 
	{      switch(number)
		{
	
	case 1:

		List <Product> productList = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = "+categoryId+  "and productPrice between 1000 and 10000" ).getResultList();
		return productList;
		
	

    case 2:
		List <Product> productLists = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = "+categoryId+  "and productPrice between 10001 and 20000").getResultList();
		return productLists;
			
		
	case 3:
		List <Product> productListss = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = "+categoryId+  "and productPrice between 20001 and 30000").getResultList();
		return productListss;
			
			
			
	case 4:
		List <Product> productListsss = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = "+categoryId+  "and productPrice between 30001 and 40000").getResultList();
		return productListsss;
		
				
	case 5:
		List <Product> productListssss = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = "+categoryId+  "and productPrice between 40001 and 50000").getResultList();
		return productListssss;
		
					
	case 6:
	    List <Product> productListsssss = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = "+categoryId+  "and productPrice>50000").getResultList();
		return productListsssss;
		
		
	default: System.out.println("ERRORRRRR");
			return 	sessionFactory.getCurrentSession().createQuery("from Product where categoryId = "+categoryId).getResultList();
					
		}
	}
	
	
	

	public List<Product> getAllProductsByPriceAndSubCategory(int number, int subCategoryId)
	{
		  switch(number)
			{
		
		case 1:
			List <Product> productList = sessionFactory.getCurrentSession().createQuery("from Product where subCategoryId = "+subCategoryId+  "and productPrice between 1000 and 10000" ).getResultList();
			return productList;
			

	    case 2:
			List <Product> productLists = sessionFactory.getCurrentSession().createQuery("from Product where subCategoryId = "+subCategoryId+  "and productPrice between 10001 and 20000").getResultList();
			return productLists;
			
		case 3:
			List <Product> productListss = sessionFactory.getCurrentSession().createQuery("from Product where subCategoryId = "+subCategoryId+  "and productPrice between 20001 and 30000").getResultList();
			
			return productListss;
				
				
		case 4:
			List <Product> productListsss = sessionFactory.getCurrentSession().createQuery("from Product where subCategoryId = "+subCategoryId+  "and productPrice between 30001 and 40000").getResultList();
			return productListsss;
				
					
		case 5:
			List <Product> productListssss = sessionFactory.getCurrentSession().createQuery("from Product where subCategoryId = "+subCategoryId+  "and productPrice between 40001 and 50000").getResultList();
			return productListssss;
			
						
		case 6:
		    List <Product> productListsssss = sessionFactory.getCurrentSession().createQuery("from Product where subCategoryId = "+subCategoryId+  "and productPrice>50000").getResultList();
			return productListsssss;
				
							 
		  
	default: System.out.println("ERRORRRRR");
	    return 	sessionFactory.getCurrentSession().createQuery("from Product where subCategoryId = "+subCategoryId).getResultList();
			

	}
	}

	
	
	
	public List<Product> getAllProductsByDiscountPriceAndCategory(int number, int categoryId) 
	{
		  switch(number)
			{
		
		case 1:
			List <Product> productList = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = "+categoryId+  "and productDiscountPrice between 0 and 10" ).getResultList();
			return productList;
			
			

	    case 2:
			List <Product> productLists = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = "+categoryId+  "and productDiscountPrice between 11 and 20").getResultList();
			return productLists;
			
			
		case 3:
			List <Product> productListss = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = "+categoryId+  "and productDiscountPrice between 21 and 30").getResultList();
			return productListss;
			
				
				
		case 4:
			List <Product> productListsss = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = "+categoryId+  "and productDiscountPrice between 31 and 40").getResultList();
			return productListsss;
			
					
		case 5:
			List <Product> productListssss = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = "+categoryId+  "and productDiscountPrice between 41 and 50").getResultList();
			return productListssss;
			
						
		case 6:
		    List <Product> productListsssss = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = "+categoryId+  "and productDiscountPrice>50").getResultList();
			return productListsssss;
				
		    default: System.out.println("ERRORRRRR");
			return 	sessionFactory.getCurrentSession().createQuery("from Product where categoryId = "+categoryId).getResultList();
						
			}

		
	}

	
	
	
	
	public List<Product> getAllProductsByDiscountPriceAndSubCategory(int number, int subCategoryId)
	{
		switch(number)
		{
	
	case 1:
		List <Product> productList = sessionFactory.getCurrentSession().createQuery("from Product where subCategoryId = "+subCategoryId+  "and productDiscountPrice between 0 and 10" ).getResultList();
		return productList;
		
		

    case 2:
		List <Product> productLists = sessionFactory.getCurrentSession().createQuery("from Product where subCategoryId = "+subCategoryId+  "and productDiscountPrice between 11 and 20").getResultList();
		return productLists;
		
	case 3:
		List <Product> productListss = sessionFactory.getCurrentSession().createQuery("from Product where subCategoryId = "+subCategoryId+  "and productDiscountPrice between 21 and 30").getResultList();
		return productListss;
		
			
			
	case 4:
		List <Product> productListsss = sessionFactory.getCurrentSession().createQuery("from Product where subCategoryId = "+subCategoryId+  "and productDiscountPrice between 31 and 40").getResultList();
		return productListsss;
			
				
	case 5:
		List <Product> productListssss = sessionFactory.getCurrentSession().createQuery("from Product where subCategoryId = "+subCategoryId+  "and productDiscountPrice between 41 and 50").getResultList();
		return productListssss;
			
					
	case 6:
	    List <Product> productListsssss = sessionFactory.getCurrentSession().createQuery("from Product where subCategoryId = "+subCategoryId+  "and productDiscountPrice>50").getResultList();
		return productListsssss;
			
		
  default: System.out.println("ERRORRRRR");
	   return 	sessionFactory.getCurrentSession().createQuery("from Product where subCategoryId = "+subCategoryId).getResultList();
			
		}


	}

	public List<Product> getAllTVProducts() 
	{
		List <Product> productList = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = 33 order by productid DESC").setMaxResults(4).getResultList();
		return productList;
	}

	public List<Product> getAllMobileProducts() 
	{
		List <Product> productList = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = 1 order by productprice ASC").setMaxResults(4).getResultList();
		return productList;
	}

	public List<Product> getAllRefrigeratorProducts() 
	{
		List <Product> productList = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = 3 order by productDISCOUNTPRICE DESC").setMaxResults(4).getResultList();
		return productList;
	}

	public List<Product> getAllACProducts()
	{
		
		List <Product> productList = sessionFactory.getCurrentSession().createQuery("from Product where categoryId = 4").setMaxResults(4).getResultList();
		return productList;
	}	
	
	
	}


