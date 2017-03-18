package com.electronics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.electronics.daoimpl.SupplierDaoImpl;
import com.electronics.daoimpl.UserDaoImpl;
import com.electronics.model.User;

@Service
@Transactional
public class UserService 
{
	@Autowired
	UserDaoImpl userDaoImpl;
	
	public void addUser(User user)
	{
		userDaoImpl.addUser(user);
	}
	
	
	public String getAllUsersByJson()
	{
		return  userDaoImpl.getAllUsersByJson();
	}

	public User getUserById(int userId)
	
	{
		return userDaoImpl.getUserById(userId);
		
	}
}
