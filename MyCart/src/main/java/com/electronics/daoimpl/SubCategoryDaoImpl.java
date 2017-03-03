package com.electronics.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.electronics.dao.SubCategoryDao;

import com.electronics.model.SubCategory;

@Repository
public class SubCategoryDaoImpl implements SubCategoryDao
{
@Autowired
	private SessionFactory sessionFactory;

public void addSubCategory(SubCategory subCategory)
{
	sessionFactory.getCurrentSession().saveOrUpdate(subCategory);
	
	
}


public List<SubCategory> getAllSubCategories() 
{
 List<SubCategory> subCategoryList = sessionFactory.getCurrentSession().createQuery("from SubCategory").getResultList();
	return subCategoryList;
}



public void deleteSubCategory(int subCategoryId) 
{
	sessionFactory.getCurrentSession().delete(getSubCategoryById(subCategoryId));
	
}


public SubCategory getSubCategoryById(int subCategoryId)
{
	String query ="from SubCategory where subCategoryId="+subCategoryId;
	
	
	List<SubCategory> subCategoryList = sessionFactory.getCurrentSession().createQuery(query).getResultList();
		return subCategoryList.get(0);	
	}
}
		
	
	

