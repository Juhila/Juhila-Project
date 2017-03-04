package com.electronics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.electronics.model.Product;
import com.electronics.model.SubCategory;
import com.electronics.service.BrandService;
import com.electronics.service.CategoryService;
import com.electronics.service.ProductService;
import com.electronics.service.SubCategoryService;
import com.electronics.service.SupplierService;

@Controller
public class ProductController 
{
	@Autowired
	ProductService productService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SubCategoryService subCategoryService;
	
	@Autowired
	BrandService brandService;
	
	@Autowired
	SupplierService supplierService;
	
	@RequestMapping("/product")
	public String getProduct(@ModelAttribute("product")Product product, Model model)
	{
		model.addAttribute("categoryList", categoryService.getAllCategories());
		model.addAttribute("subCategoryList", subCategoryService.getAllSubCategories());
		model.addAttribute("brandList", brandService.getAllBrands());
		model.addAttribute("supplierList", supplierService.getAllSuppliers());
		model.addAttribute("productList", productService.getAllProducts());
		
		model.addAttribute("product", new Product());
		
		
		return "productPage";
	}
	
	@RequestMapping("/editproduct-{productId}")
	public String editProduct(@PathVariable("productId")int productId,@ModelAttribute("product")Product product, Model model)
	{
		model.addAttribute("categoryList", categoryService.getAllCategories());
		model.addAttribute("subCategoryList", subCategoryService.getAllSubCategories());
		model.addAttribute("brandList", brandService.getAllBrands());
		model.addAttribute("supplierList", supplierService.getAllSuppliers());
		//model.addAttribute("productList", productService.getAllProducts());
		
		model.addAttribute("product", productService.getProductById(productId));
		//model.addAttribute("btnLabel","Update");

		return "productPage";
	}
	
	@RequestMapping("/addproduct")
	public String addProduct(@ModelAttribute("product")Product product)
	{
		
		productService.addProduct(product);
		
		return "redirect:/product";
	}
	
	@RequestMapping("/deleteproduct-{productId}")
	public String deleteProduct(@PathVariable("productId")int productId)
	{
		productService.deleteProduct(productId);
		return "redirect:/product";
	}
}