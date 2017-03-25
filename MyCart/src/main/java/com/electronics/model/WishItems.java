package com.electronics.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.google.gson.annotations.Expose;

@Entity
public class WishItems
{
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Expose
private int wishItemsId;

@Expose
private int cartId;		

@Expose             
private int userId;	

@Expose
private String productName;

@Expose
private String userName;


@Expose
private int productId;

@Expose
private int productQuantity;

@Expose
private int productPrice;

@Expose
private double amount;

@Expose
private int productDiscount;

@Expose
private Date orderDate;


@ManyToOne
@JoinColumn(name="userId", nullable=false , updatable=false , insertable=false )
private User user;

@ManyToOne
@JoinColumn(name="cartId", nullable=false , updatable=false , insertable=false )
private Cart cart;


public int getCartItemsId() {
	return wishItemsId;
}

public void setCartItemsId(int cartItemsId) {
	this.wishItemsId = cartItemsId;
}

public int getCartId() {
	return cartId;
}

public void setCartId(int cartId) {
	this.cartId = cartId;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public int getProductQuantity() {
	return productQuantity;
}

public void setProductQuantity(int productQuantity) {
	this.productQuantity = productQuantity;
}

public int getProductPrice() {
	return productPrice;
}

public void setProductPrice(int productPrice) {
	this.productPrice = productPrice;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}

public int getProductDiscount() {
	return productDiscount;
}

public void setProductDiscount(int productDiscount) {
	this.productDiscount = productDiscount;
}

/**public Date getOrderDate() {
	return orderDate;
}
**/
public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}



public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Cart getCart() {
	return cart;
}

public void setCart(Cart cart) {
	this.cart = cart;
}
public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}


}

