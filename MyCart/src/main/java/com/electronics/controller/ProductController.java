package com.electronics.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String addProduct(@Valid @ModelAttribute("product")Product product,@RequestParam("productImage")MultipartFile productImage,BindingResult result,Model model)
	{
		
		
		String path="E:\\Program\\M eclipse sw\\project\\MyCart\\src\\main\\webapp\\resources\\images\\products\\";
		if(result.hasErrors())
		{
			
			return "productPage";
		}
		productService.addProduct(product);
		
		if(!productImage.isEmpty())
		{
			try
			{
				byte[] bytes = productImage.getBytes();
				
				
						File imageFile = new File(path  +"productImage-"+product.getProductId() + "." + "jpg");
						BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(imageFile));
						stream.write(bytes);
						stream.close();
						
					
					
			}
			catch(Exception e)
			{
				e.printStackTrace();
				model.addAttribute("uploadmessage","Image Upload Failed.... Please Try Again");
			}
		}
			else
			
			model.addAttribute("error","Please select product image");

		
		return "redirect:/product";
		
	
		}
	
	
	@RequestMapping("/deleteproduct-{productId}")
	public String deleteProduct(@PathVariable("productId")int productId)
	{
		productService.deleteProduct(productId);
		 File file = new File("E:\\Program\\M eclipse sw\\project\\MyCart\\src\\main\\webapp\\resources\\images\\products"+"."+"jpg");
			file.delete();
	        return "redirect:/product";
	}
		
}