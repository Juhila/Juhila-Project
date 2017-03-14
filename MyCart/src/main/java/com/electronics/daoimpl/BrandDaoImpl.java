package com.electronics.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electronics.dao.BrandDao;
import com.electronics.model.Brand;
import com.electronics.model.Category;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@Repository
public class BrandDaoImpl implements BrandDao 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public List<Brand> getAllBrands() 
	{
		List<Brand> brandList = sessionFactory.getCurrentSession().createQuery("from Brand").getResultList();
		return brandList;
	}

	public Brand getBrandById(int brandId) {
		List <Brand> brandList = sessionFactory.getCurrentSession().createQuery("from Brand where brandId = "+brandId).getResultList();
		return brandList.get(0);
	}

	public void addBrand(Brand brand) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(brand);
	}

	public void deleteBrand(int brandId) 
	{
		Brand brand = getBrandById(brandId);
		sessionFactory.getCurrentSession().delete(brand);
	}
	public String getAllBrandsByJson() {
		List<Brand> brandList = sessionFactory.getCurrentSession().createQuery("from Brand").getResultList();
		Gson g = new Gson();
		
		String list = g.toJson(brandList);
		return list;
	}

}


