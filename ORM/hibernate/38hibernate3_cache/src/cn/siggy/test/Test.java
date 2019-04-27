package cn.siggy.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cn.siggy.pojo.User;

public class Test {
	public static void main(String[] args) {
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session= factory.openSession();
		Transaction tx = session.beginTransaction();
		User u = (User)session.get(User.class, 1);
		System.out.println(u.getName());
		tx.commit();
		session.close();
		System.out.println("----------------------");
		session= factory.openSession();
		 tx = session.beginTransaction();
		 u = (User)session.get(User.class, 1);
		System.out.println(u.getName());
		tx.commit();
		session.close();
	}
}
