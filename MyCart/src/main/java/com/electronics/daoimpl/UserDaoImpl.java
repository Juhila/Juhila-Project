package com.electronics.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electronics.dao.UserDao;
import com.electronics.model.BillingAddress;
import com.electronics.model.Cart;
import com.electronics.model.ShippingAddress;
import com.electronics.model.Supplier;
import com.electronics.model.User;
import com.google.gson.Gson;


@Repository
public class UserDaoImpl implements UserDao

{
	@Autowired
	 private SessionFactory sessionFactory;


	public void addUser(User user) 
	{
		 Session session=sessionFactory.getCurrentSession();
	
		user.setEnabled(true);
	  user.setRole("ROLE_CUSTOMER");
	  session.saveOrUpdate(user);
	  
	  Cart cart=new Cart();
	  cart.setCartId(user.getUserId());
	  cart.setUserId(user.getUserId());
	  session.saveOrUpdate(cart);
	  
	  session.saveOrUpdate(user);
		 
	 /** BillingAddress billingAddress=new BillingAddress();
	  billingAddress.setBillingAddressId(user.getUserId());
	  billingAddress.setUserId(user.getUserId());
	  session.saveOrUpdate(billingAddress);
	  
	   session.saveOrUpdate(user);
	 
	  
	  ShippingAddress shippingAddress=new ShippingAddress();
	  shippingAddress.setShippingAddressId(user.getUserId());
	  shippingAddress.setUserId(user.getUserId());
	  session.saveOrUpdate(shippingAddress);**/
	  
	  
	 
	  session.saveOrUpdate(user);
	 
	 //session.flush(); ....no need for currentSession
	}

	/**public List<User> getAllUsers() {
		List<User> userList = sessionFactory.getCurrentSession().createQuery("from User").getResultList();
		return userList;
	}
	**/

	public String getAllUsersByJson() 
	{
		List<User> user = sessionFactory.getCurrentSession().createQuery("from User").getResultList();
		Gson g = new Gson();

		String list = g.toJson(user);
		return list;
	}

	public User getUserById(int userId) {
		// TODO Auto-generated method stubList<Supplier> supplier = sessionFactory.getCurrentSession().createQuery("from Supplier").getResultList();
		List<User> userList = sessionFactory.getCurrentSession().createQuery("from User where userId = "+userId).getResultList();
		return userList.get(0);
	}
	
	 public void enableDisableUser(int userId)
	 {
			sessionFactory.getCurrentSession().createQuery("update User set enabled = case when enabled=true then false when enabled=false then true end where userId="+userId ).executeUpdate();

		 
		
	 }

	public User getUserByUserName(String username) {
		List<User> userLists = sessionFactory.getCurrentSession().createQuery("from User where username='"+username+"'").getResultList();
		return userLists.get(0);
	
	}

	
	/** public void deleteUser(int userId) {
			sessionFactory.getCurrentSession().delete(getUserById(userId));

		}**/

}


