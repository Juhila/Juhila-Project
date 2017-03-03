package com.electronics.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.electronics.dao.SupplierDao;
import com.electronics.model.Supplier;

@Repository
public class SupplierDaoImpl implements SupplierDao
{
	@Autowired
	SessionFactory sessionFactory;

	public List<Supplier> getAllSuppliers() {
		List<Supplier> supplierList = sessionFactory.getCurrentSession().createQuery("from Supplier").getResultList();
		return supplierList;
	}

	public Supplier getSupplierById(int supplierId) {
		List<Supplier> supplierList = sessionFactory.getCurrentSession().createQuery("from Supplier where supplierId = "+supplierId).getResultList();
		return supplierList.get(0);
	}

	public void addSupplier(Supplier supplier) {
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	}

	public void deleteSupplier(int supplierId) {
		sessionFactory.getCurrentSession().delete(getSupplierById(supplierId));

	}

	
}
