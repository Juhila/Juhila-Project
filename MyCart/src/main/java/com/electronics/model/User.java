package com.electronics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.gson.annotations.Expose;

@Entity
public class User 
{

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Expose
	private int userId;
	
	@Column(unique=true)
	@Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address for username") 
	@NotEmpty(message="Required")
	private String username;
	
	@NotEmpty(message="Required")
	@Min(8)
	private String password;
	
	@NotEmpty(message="Required")
	private String role;
	
private String enabled;
	
	@NotEmpty(message="Required")
	private String userFirstName;
	
	@NotEmpty(message="Required")
	private String userLastName;
	
	
	@Column(unique=true)
	@NotEmpty(message="Required")
	@Pattern(regexp="^$|[0-9]{10}", message="Please enter 10 digit mob. no.")
	private String userContact;
	
	
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

		public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

		public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserContact() {
		return userContact;
	}

	
	
	
	
}
