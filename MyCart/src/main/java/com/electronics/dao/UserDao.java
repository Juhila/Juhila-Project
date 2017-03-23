package com.electronics.dao;

	import java.util.List;

import com.electronics.model.User;

	

	public interface UserDao
	{
		public void addUser(User user);
	//public List<User> getAllUsers();
		
		public String getAllUsersByJson();

		public User getUserById(int userId);
		
		public void enableDisableUser (int userId);
		
	}


