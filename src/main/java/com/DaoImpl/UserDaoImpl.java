package com.DaoImpl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.Dao.UserDao;
import com.model.Categorydetails;
import com.model.Supplierdetails;
import com.model.User;
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public UserDaoImpl(SessionFactory sf) {
		// TODO Auto-generated constructor stub
	}

	public void insertUser(User user)
	{Session session=sessionFactory.openSession();
	session.beginTransaction();
	user.setEnabled(true);
	session.saveOrUpdate(user);
	session.getTransaction().commit();
	}
	
	
	public List<User> retrieve()
	{Session session=sessionFactory.openSession();
	session.beginTransaction();
	
	List<User> list = session.createQuery("from User").list();
	session.getTransaction().commit();
	    
	return list;
	}

	public User findUserById(String userEmail) //email
	{
			Session session=sessionFactory.openSession();
	User cr=null;
	try{
		session.beginTransaction();
	cr=(User) session.get(User.class,userEmail);
		session.getTransaction().commit();
	}
	catch(HibernateException ex)
	{ex.printStackTrace();
	session.getTransaction().rollback();
		
	}
	return cr;
	}
}
