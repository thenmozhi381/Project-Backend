package com.DaoImpl;
import org.hibernate.SessionFactory;

import java.util.List;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.ProductDao;

import com.model.Productdetails;
@Repository
public class ProductDaoImpl implements ProductDao {
	@Autowired


	SessionFactory sessionFactory;
	
	public ProductDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}


	public void insertProductdetails(Productdetails productdetails)
	{Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.saveOrUpdate(productdetails);
	session.getTransaction().commit();
	session.close();
	}
	
	public List<Productdetails> retrieve()
	{Session session=sessionFactory.openSession();
	session.beginTransaction();

	List<Productdetails> list =session.createQuery("from Productdetails") .list();
	session.getTransaction().commit();
	  
	return list;
	}
	public Productdetails findById(int pid)
	{
		Session session=sessionFactory.openSession();
	Productdetails p=null;
	try{
		session.beginTransaction();
		p=(Productdetails) session.get(Productdetails.class,pid);
		session.getTransaction().commit();
	}
	catch(HibernateException ex)
	{ex.printStackTrace();
	session.getTransaction().rollback();
		
	}
	return p;
	}
	
	
	
	
	

	
	
	public List<Productdetails> getProdById(int cid) {
	
	Session session=sessionFactory.openSession();

	List<Productdetails>products=null;
	session.beginTransaction();

	products =session.createQuery("from Productdetails where cid="+cid) .list();
	session.getTransaction().commit();
return products ;
}
	
	
	
	
	public void deleteProductdetails(int pid)
	{
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Productdetails p=(Productdetails)session.get(Productdetails.class, pid);
		session.delete(p);
		session.getTransaction().commit();
		
	}
	
	
	
	public void update(Productdetails p)
	{Session session=sessionFactory.openSession();
//try{
	session.beginTransaction();
	//session.saveOrUpdate(p);
	//System.out.println("DAO"+p.getId());
	session.update(p);
	session.getTransaction().commit();
	session.close();

//}
	//catch(HibernateException e){
	
	//}
	}


	
		
	
}
