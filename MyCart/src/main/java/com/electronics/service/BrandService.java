package com.electronics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electronics.daoimpl.BrandDaoImpl;
import com.electronics.model.Brand;


@Transactional
@Service
public class BrandService
{
		
		@Autowired
	   private BrandDaoImpl brandDaoImpl;
	   
		
		public void addBrand(Brand brand)
		{
			brandDaoImpl.addBrand(brand);
		}
		
		
		public List<Brand> getAllBrands() 
		{
		return brandDaoImpl.getAllBrands();
		}
		
		
		
		public Brand getBrandById(int brandId)
		{
			return brandDaoImpl.getBrandById(brandId);
		}
		
		
		public void deleteBrand(int brandId)
		{
			brandDaoImpl.deleteBrand(brandId);
		}
		
		
	}
		

	

