package hs.dao;

import java.util.List;

import org.hibernate.Session;

import hs.pojo.User;
import hs.util.HibernateSessionFactory;

public class UserDao {
	public List<User> getAll(){
		Session session = HibernateSessionFactory.getSession();
		return session.createQuery("from User").list();
	}
}
