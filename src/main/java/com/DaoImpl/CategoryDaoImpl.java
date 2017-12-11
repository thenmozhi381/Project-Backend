package com.DaoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.CategoryDao;

import com.model.Categorydetails;
import com.model.Productdetails;


@Repository("categoryDaoImpl")
public class CategoryDaoImpl implements CategoryDao {
	@Autowired


	SessionFactory sessionFactory;
	@Autowired
	public CategoryDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	public void insertCategorydetails(Categorydetails categorydetails)
	{Session session=sessionFactory.openSession();
	session.beginTransaction();
	session.saveOrUpdate(categorydetails);
	session.getTransaction().commit();
	session.close();
	}
	
	public List<Categorydetails> retrieve()
	{Session session=sessionFactory.openSession();
	session.beginTransaction();
	List<Categorydetails> list = session.createQuery("from Categorydetails").list();
	session.getTransaction().commit();
    
	return list;
	
	   
	}


public Categorydetails findById(int cid)
{
	Session session=sessionFactory.openSession();
Categorydetails p=null;
try{
	session.beginTransaction();
p=(Categorydetails) session.get(Categorydetails.class,cid);
	session.getTransaction().commit();
}
catch(HibernateException ex)
{ex.printStackTrace();
session.getTransaction().rollback();
	
}
return p;
}
	

public void deleteCategorydetails(int cid)
{
	Session session=sessionFactory.openSession();
	session.beginTransaction();
	Categorydetails p=(Categorydetails)session.get(Categorydetails.class, cid);
	session.delete(p);
	session.getTransaction().commit();
	//session.close();
/*try
{
	session.beginTransaction();
	session.delete(cid);
}
catch(HibernateException ex)
{
	ex.printStackTrace();
	session.getTransaction().rollback();

}*/
}











public void update(Categorydetails c)
{
	Session session=sessionFactory.openSession();
	//try{
	session.beginTransaction();
	session.update(c);
//}catch(HibernateException ex){ex.printStackTrace();
session.getTransaction().commit();
	//session.getTransaction().rollback();

	
	session.close();
	
	
	

}










}

