package com.electronics.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

@Entity
public class Product 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int productId;
	
	private int supplierId;

	private int subCategoryId;

	private int categoryId;
	private int brandId;

	@NotEmpty(message="Cannot be Empty")
	private String productName;
	
	
	private int productStock;
	
	private int productPrice;

	private int productDiscountPrice;
	
	private String productDescription;


	@ManyToOne
	@JoinColumn(name = "subCategoryId", nullable=false, insertable=false, updatable=false)
	private SubCategory subCategory;

	@ManyToOne
	@JoinColumn(name = "categoryId", nullable=false, insertable=false, updatable=false)
	private Category category;

	@ManyToOne
	@JoinColumn(name = "supplierId", nullable=false, insertable=false, updatable=false)
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name = "brandId", nullable=false, insertable=false, updatable=false)
	private Brand  brand;
	
	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId= brandId;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductStock() {
		return productStock;
	}

	public void setProductStock(int productStock) {
		this.productStock = productStock;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductDiscountPrice() {
		return productDiscountPrice;
	}

	public void setProductDiscountPrice(int productDiscountPrice) {
		this.productDiscountPrice = productDiscountPrice;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	

}
