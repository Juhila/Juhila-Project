package com.electronics.dao;

import java.util.List;

import com.electronics.model.Brand;

public interface BrandDao 
{

		public List<Brand> getAllBrands();
		public Brand getBrandById(int brandId);
		//public String getBrandByName();
		public void addBrand(Brand brand);
		public void deleteBrand(int brandId);

}
