package com.DaoImpl;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Dao.*;

import com.model.*;
@SuppressWarnings("unused")

@Repository("ordersDaoImpl")

public class OrdersDaoImpl implements OrdersDao {
	 @Autowired

		SessionFactory sessionFactory;

		public OrdersDaoImpl(SessionFactory sessionFactory) {
			this.sessionFactory=sessionFactory;
		}

		public void insert(Orders orders)
		{Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.persist(orders);
		session.getTransaction().commit();
		}

		
				

	
	
}
