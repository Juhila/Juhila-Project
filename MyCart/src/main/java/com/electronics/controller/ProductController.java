package com.electronics.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		//model.addAttribute("productList", productService.getAllProducts());
		
		model.addAttribute("categoryListByJson", categoryService.getAllCategoriesByJson());
		model.addAttribute("subCategoryListByJson", subCategoryService.getAllSubCategoriesByJson());
		model.addAttribute("brandListByJson", brandService.getAllBrandsByJson());
		model.addAttribute("supplierListByJson", supplierService.getAllSuppliersByJson());
		model.addAttribute("productListByJson", productService.getAllProductsByJson());
	

		
		model.addAttribute("product", new Product());
		
		model.addAttribute("buttonLabel","Add Product");

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
		
		
		
		
		model.addAttribute("categoryListByJson", categoryService.getAllCategoriesByJson());
		model.addAttribute("subCategoryListByJson", subCategoryService.getAllSubCategoriesByJson());
		model.addAttribute("brandListByJson", brandService.getAllBrandsByJson());
		model.addAttribute("supplierListByJson", supplierService.getAllSuppliersByJson());
		model.addAttribute("productListByJson", productService.getAllProductsByJson());
		
		model.addAttribute("product", productService.getProductById(productId));
		model.addAttribute("buttonLabel","Update Product");

		return "productPage";
	}
	
	@RequestMapping("/addproduct")
	public String addProduct(@Valid @ModelAttribute("product")Product product,BindingResult result,@RequestParam("productImage")MultipartFile productImage,Model model)
	{
		
		
		String path="E:\\Program\\M eclipse sw\\project\\MyCart\\src\\main\\webapp\\resources\\images\\products\\";
		if(result.hasErrors())
		{
			model.addAttribute("categoryList", categoryService.getAllCategories());
			model.addAttribute("subCategoryList", subCategoryService.getAllSubCategories());
			model.addAttribute("brandList", brandService.getAllBrands());
			model.addAttribute("supplierList", supplierService.getAllSuppliers());
			//model.addAttribute("productList", productService.getAllProducts());
			
			
			model.addAttribute("categoryListByJson", categoryService.getAllCategoriesByJson());
			model.addAttribute("subCategoryListByJson", subCategoryService.getAllSubCategoriesByJson());
			model.addAttribute("brandListByJson", brandService.getAllBrandsByJson());
			model.addAttribute("supplierListByJson", supplierService.getAllSuppliersByJson());
			model.addAttribute("productListByJson", productService.getAllProductsByJson());
			
			model.addAttribute("buttonLabel","Add Product");

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
				model.addAttribute("error","Image Upload Failed.... Please Try Again");
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
		 File file = new File("E:\\Program\\M eclipse sw\\project\\MyCart\\src\\main\\webapp\\resources\\images\\products\\productImage-"+productId+"."+"jpg");
			file.delete();
	        return "redirect:/product";
	}
		
	
	
	@RequestMapping("/viewproduct-{productId}")
	public String getViewProductPage(@PathVariable("productId") int productId, Model model)
	{
		Product product = productService.getProductById(productId);
		
		int price=product.getProductPrice();
		int discprice=product.getProductDiscountPrice();
		
		double amt=price-(price*discprice/100);
		
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		 String productData=gson.toJson(product);
		
		model.addAttribute("viewProductByJson", productData);
		model.addAttribute("viewProduct", product);
		model.addAttribute("discprice",amt);
		
		
		if(discprice!=0)
			model.addAttribute("message",0);
		return "productView";
	}
	
	
 	@RequestMapping("/filterforcategory-{categoryId}")
	public String getProductDisplayPage(@PathVariable("categoryId") int categoryId, Model model)
	{
	   
		List<Product> productList=productService.getAllProductsByCategoryId(categoryId);
		model.addAttribute("brandList", brandService.getAllBrands());
		model.addAttribute("productList",productList);
		model.addAttribute("categoryId",categoryId);
		
		model.addAttribute("message", 0);
		return "productDisplay";
	
	}
 	
 	
 	@RequestMapping("/filterforsubcategory-{subCategoryId}")
	public String getProductDisplayPagee(@PathVariable("subCategoryId") int subCategoryId,Model model)
	{
	   
 		List<Product> productList=productService.getAllProductsBySubCategoryId(subCategoryId);
		model.addAttribute("productList",productList);
		model.addAttribute("brandList", brandService.getAllBrands());
		model.addAttribute("subCategoryId",subCategoryId);
		model.addAttribute("message", 1);
		return "productDisplay";
	
	}
	
 	@RequestMapping("/filterforbrand-{brandId}-{categoryId}")
	public String getProductDisplayPageee(@PathVariable("brandId") int brandId,Model model,@PathVariable("categoryId") int categoryId)
	{
	   
 		List<Product> productList=productService.getAllProductsByBrandAndCategory(brandId,  categoryId);
		model.addAttribute("productList",productList);
		model.addAttribute("brandList", brandService.getAllBrands());
		model.addAttribute("categoryId",categoryId);
		model.addAttribute("brandId",brandId);
		model.addAttribute("message", 0);
		return "productDisplay";
	
	}
	
 	
	@RequestMapping("/filterforbrande-{brandId}-{subCategoryId}")
	public String getProductDisplayPageeee(@PathVariable("brandId") int brandId,Model model,@PathVariable("subCategoryId") int subCategoryId)
	{
	   
 		List<Product> productList=productService.getAllProductsByBrandAndSubCategory(brandId,  subCategoryId);
		model.addAttribute("productList",productList);
		model.addAttribute("brandList", brandService.getAllBrands());
		model.addAttribute("subCategoryId",subCategoryId);
		model.addAttribute("brandId",brandId);
		model.addAttribute("message", 1);
		return "productDisplay";
	
	}
	
	
	@RequestMapping("/filterbyprice-{number}-{categoryId}")
	public String getProductDisplayPageeeee(Model model,@PathVariable("categoryId") int categoryId,@PathVariable("number") int number)
	{
	   
 		List<Product> productList=productService.getAllProductsByPriceAndCategory(number, categoryId);
		model.addAttribute("productList",productList);
		model.addAttribute("brandList", brandService.getAllBrands());
		model.addAttribute("categoryId",categoryId);
		model.addAttribute("message", 0);
		return "productDisplay";
	
	}
	
	@RequestMapping("/filterbypricee-{number}-{subCategoryId}")
	public String getProductDisplayPageeeeee(Model model,@PathVariable("subCategoryId") int subCategoryId,@PathVariable("number") int number)
	{
	   
 		List<Product> productList=productService.getAllProductsByPriceAndCategory(number, subCategoryId);
		model.addAttribute("productList",productList);
		model.addAttribute("brandList", brandService.getAllBrands());
		model.addAttribute("subCategoryId",subCategoryId);
		model.addAttribute("message", 1);
		return "productDisplay";
	
	}
	
	
	
	@RequestMapping("/filterbydiscountprice-{number}-{categoryId}")
	public String getProductDisplayPageeeeeee(Model model,@PathVariable("categoryId") int categoryId,@PathVariable("number") int number)
	{
	   
 		List<Product> productList=productService.getAllProductsByDiscountPriceAndCategory(number, categoryId);
		model.addAttribute("productList",productList);
		model.addAttribute("brandList", brandService.getAllBrands());
		model.addAttribute("categoryId",categoryId);
		model.addAttribute("message", 0);
		return "productDisplay";
	
	}
	
	@RequestMapping("/filterbydiscountpricee-{number}-{subcategoryId}")
	public String getProductDisplayPageeeeeeee(Model model,@PathVariable("subCategoryId") int subCategoryId,@PathVariable("number") int number)
	{
		model.addAttribute("messagee", "HHHHHHHHHHHHHHHH");
 		List<Product> productList=productService.getAllProductsByDiscountPriceAndSubCategory(number, subCategoryId);
		model.addAttribute("productList",productList);
		model.addAttribute("brandList", brandService.getAllBrands());
		model.addAttribute("subCategoryId",subCategoryId);
		model.addAttribute("message", 1);
		return "productDisplay";
	
	}
	
	
	
}