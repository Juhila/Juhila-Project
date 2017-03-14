package com.electronics.model;


	import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

	@Entity
	public class Brand 
	{
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		private int brandId;
	
		 @Expose
		@NotEmpty(message="Cannot be empty")
		//@Column(unique=true)
		private String brandName;
		

	/**@OneToMany(mappedBy="brand",fetch=FetchType.EAGER)
		Set<Category> category;
		
		
		
		public Set<Category> getCategory() {
			return category;
		}
		public void setCategory(Set<Category> category) {
			this.category = category;
		
		}
		**/
		/**@OneToMany(mappedBy="brand",fetch=FetchType.EAGER)
		Set<Product>products;
		
		public Set<Product> getProducts() {
			return products;
		}
		public void setProducts(Set<Product> products) {
			this.products = products;
		}**/
		
		public int getBrandId() {
			return brandId;
		}
		public void setBrandId(int brandId) {
			this.brandId = brandId;
		}
		
		public String getBrandName() {
			return brandName;
		}
		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}
		
}
