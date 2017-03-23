package com.electronics.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

@Entity
public class Supplier
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supplierId;
	
     @Expose
	@NotEmpty(message="Required")
    private String supplierName;
	 
	
		
		   
	   
	@NotEmpty(message="Required")
	private String supplierFirmName;
	

	
	@Expose
	   private boolean enabled;
		
	   
	@NotEmpty(message="Required")
	private String supplierStreet;
	   
	@NotEmpty(message="Required")
	private String supplierCity;
	
	   
	@NotEmpty(message="Required")
	private String supplierState;
	
	   
	@NotEmpty(message="Required")
	private String supplierCountry;
	
	
	
	@Column(unique=true)
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid  email address")  
	@NotEmpty(message="Required")
	private String supplierEmail;
	
	@Pattern(regexp="^$|[0-9]{10}", message="Please enter 10 digit mob. no.")  
	@NotEmpty(message="Required")
	private String supplierContact;
	
/**	@OneToMany(mappedBy="supplier",fetch=FetchType.EAGER)
	Set<Product>products;
	
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	**/
	
	
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) 
	{
		this.enabled = enabled;
	}
	
	public int getSupplierId() {
		return supplierId;
	}
	public String getSupplierName() {
	return supplierName;
}
public void setSupplierName(String supplierName) {
	this.supplierName = supplierName;
}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getSupplierFirmName() {
		return supplierFirmName;
	}
	public void setSupplierFirmName(String supplierFirmName) {
		this.supplierFirmName = supplierFirmName;
	}
	public String getSupplierStreet() {
		return supplierStreet;
	}
	public void setSupplierStreet(String supplierStreet) {
		this.supplierStreet = supplierStreet;
	}
	public String getSupplierCity() {
		return supplierCity;
	}
	public void setSupplierCity(String supplierCity) {
		this.supplierCity = supplierCity;
	}
	public String getSupplierState() {
		return supplierState;
	}
	public void setSupplierState(String supplierState) {
		this.supplierState = supplierState;
	}
	public String getSupplierCountry() {
		return supplierCountry;
	}
	public void setSupplierCountry(String supplierCountry) {
		this.supplierCountry = supplierCountry;
	}
	public String getSupplierEmail() {
		return supplierEmail;
	}
	public void setSupplierEmail(String supplierEmail) {
		this.supplierEmail = supplierEmail;
	}
	public String getSupplierContact() {
		return supplierContact;
	}
	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}
}
