package com.electronics.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

@Entity
public class ShippingAddress
{
	@Expose
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int shippingAddressId;
	private int userId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@NotEmpty(message="Required")
	@Expose
	private String city;
	
	@NotEmpty(message="Required")
	@Expose
	private String state;
	
	
	@Expose
	@NotEmpty(message="Required")
	@Pattern(regexp="[\\d]{6}", message="Enter valid pincode digits")
	//@Pattern(regexp="^$|[0-9]", message="Only numeric digits allowed" )
	private String pinCode;
	
	@Expose
	@NotEmpty(message="Required")
	private String district;
	
	@NotEmpty(message="Required")
	@Expose
	private String landmark;
	
	
	@NotEmpty(message="Required")
	@Expose
	private String address;
	
	@OneToOne
	@JoinColumn(name="userId", updatable=false, insertable=false, nullable=false)
	private User user;


	public int getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(int shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
