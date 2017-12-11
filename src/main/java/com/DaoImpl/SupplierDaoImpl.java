package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.SupplierDao;
import com.model.Categorydetails;
import com.model.Supplierdetails;
@Repository("supplierDaoImpl")
public class SupplierDaoImpl implements SupplierDao {
	@Autowired
SessionFactory sessionFactory;
	@Autowired
	public SupplierDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	
	
	public void insertSupplierdetails(Supplierdetails supplierdetails)
	{
		Session session=sessionFactory.openSession();
	session.beginTransaction();
	//session.persist(supplierdetails);
	session.saveOrUpdate(supplierdetails);
	session.getTransaction().commit();
	session.close();
	}
		
	public List<Supplierdetails> retrieve()
	{Session session=sessionFactory.openSession();
	session.beginTransaction();
	
	List<Supplierdetails> list = session.createQuery("from Supplierdetails").list();
	session.getTransaction().commit();
	    
	return list;
	}
	
	
	public Supplierdetails findById(int sid)
	{
		Session session=sessionFactory.openSession();
	Supplierdetails p=null;
	try{
		session.beginTransaction();
		p=(Supplierdetails) session.get(Supplierdetails.class,sid);
		session.getTransaction().commit();
	}
	catch(HibernateException ex)
	{ex.printStackTrace();
	session.getTransaction().rollback();
		
	}
	return p;
	}
		
		

	public void deleteSupplierdetails(int sid)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Supplierdetails p=(Supplierdetails)session.get(Supplierdetails.class, sid);
		session.delete(p);
		session.getTransaction().commit();
			}











	public void update(Supplierdetails s)
	{
		Session session=sessionFactory.openSession();
	
		session.beginTransaction();
		session.update(s);
	
	session.getTransaction().commit();
	

		
		session.close();
		
		
		

	}

	
	
}