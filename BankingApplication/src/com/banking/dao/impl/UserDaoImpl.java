package com.banking.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import com.banking.dao.UserDao;
import com.banking.dto.User;



@Component
public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session session;

	@Override
	public int addUser(User user) {
		session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(user);
		int userID = user.getId();
		tx.commit();
		session.close();
		return userID;
	}
	
	
	@Override
	public User getUserById(int id) {
		session = this.sessionFactory.openSession();
		User user = (User) session.get(User.class,id);
		session.close();
		return user;
	}
	

	@Override
	public int updateUserBalance(User user) {
		session= this.sessionFactory.openSession();
		String hql="update User set balance=:balance where id=:id";
		Query query=session.createQuery(hql);
		query.setParameter("balance", user.getBalance());
		query.setParameter("id", user.getId());
		int result = query.executeUpdate();
		session.close();
		return result;

	}

}
