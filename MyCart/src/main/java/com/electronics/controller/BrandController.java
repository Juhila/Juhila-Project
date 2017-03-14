package com.electronics.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		//model.addAttribute("brandList", brandService.getAllBrands());
		model.addAttribute("brandListByJson", brandService.getAllBrandsByJson());
		
		model.addAttribute("brand",new Brand());
		model.addAttribute("buttonLabel","Add Brand");
		
		return "brandPage";
	}
	
	@RequestMapping("/editbrand-{brandId}")
	public String editBrand(@PathVariable("brandId")int brandId, Model model)
	{
		//model.addAttribute("brandList", brandService.getAllBrands());
		model.addAttribute("brandListByJson", brandService.getAllBrandsByJson());
		model.addAttribute("brand", brandService.getBrandById(brandId));
		model.addAttribute("buttonLabel","Update Brand");
	
		return "brandPage";
	}
	
	@RequestMapping("/addbrand")
	public String addBrand(@Valid @ModelAttribute("brand")Brand brand, BindingResult result, Model model)
	{
		
		if(result.hasErrors())
			
		{  
			//model.addAttribute("brandList", brandService.getAllBrands());
			model.addAttribute("brandListByJson", brandService.getAllBrandsByJson());
			

			model.addAttribute("buttonLabel","Retry");
			return "brandPage";
		}
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
