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
public class BillingAddress
{
	
	@Expose
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int billingAddressId;
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Expose
	@NotEmpty(message="Required")
	private String city;
	
	@NotEmpty(message="Required")
	@Expose
	private String state;
	
	
	// @Pattern(regexp="[\\d]")
	
	//@EnsureNumber(decimal = true,message = "Only digits are aloowed.")
	//@Pattern(regexp="^$|[0-9]", message="Only numeric digits allowed" )
	@Pattern(regexp="[\\d]{6}", message="Enter valid pincode digits")
	@NotEmpty(message="Required")
    @Expose
	private String pinCode;
	
	@NotEmpty(message="Required")
	@Expose
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

	public int getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(int billingAddressId) {
		this.billingAddressId = billingAddressId;
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
