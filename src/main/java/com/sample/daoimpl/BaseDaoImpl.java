package com.sample.daoimpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.jpa.HibernateEntityManager;

public class BaseDaoImpl {

//	@Autowired
//	private SessionFactory sessionFactory;

	@PersistenceContext
	private EntityManager entityManager;

	protected Session getSession() {
		HibernateEntityManager hem = entityManager.unwrap(HibernateEntityManager.class);
		return hem.getSession();
//		return sessionFactory.getCurrentSession();
	}

}
