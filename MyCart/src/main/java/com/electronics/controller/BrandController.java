package com.electronics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronics.model.Brand;
import com.electronics.service.BrandService;

@Controller
public class BrandController 
{
	@Autowired
	BrandService brandService;
	
	@RequestMapping(value="/brand")
	public String getBrandPage(Model model)
	{
		model.addAttribute("brandList", brandService.getAllBrands());
		model.addAttribute("brand",new Brand());
		
		return "brandPage";
	}
	
	@RequestMapping("/editbrand-{brandId}")
	public String updateBrand(@PathVariable("brandId")int brandId, Model model)
	{
		model.addAttribute("brandList", brandService.getAllBrands());
		model.addAttribute("brand", brandService.getBrandById(brandId));
	
	
		return "brandPage";
	}
	
	@RequestMapping("/addbrand")
	public String addBrand(@ModelAttribute("brand")Brand brand)
	{
		brandService.addBrand(brand);
		return "redirect:/brand";
	}
	
	@RequestMapping("/deletebrand-{brandId}")
	public String deleteBrand(@PathVariable("brandId")int brandId)
	{
		brandService.deleteBrand(brandId);
		return "redirect:/brand";
	}
	
}
