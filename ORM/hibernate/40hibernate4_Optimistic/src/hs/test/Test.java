package hs.test;

import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import hs.pojo.User;
import hs.util.HibernateUtil;

public class Test {
	public static void testCreateDB(){
		Configuration cfg = new Configuration().configure();
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}
	public static void testSave(){
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			User user = new User();
			user.setName("≥Ã∑…—Ô");
			user.setPwd("123456");
			session.save(user);
			tx.commit();			
		}catch(Exception e){
			if(tx != null){
				tx.rollback();
				e.printStackTrace();
			}
		}finally{
			HibernateUtil.closeSession();
		}		
	}
	//≤‚ ‘¿÷π€À¯
	public static void testGet1(){
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			User user = (User) session.get(User.class, 1);
			System.out.println(user.getName());
			user.setName("∑…—Ô");
			
			Session session1 = HibernateUtil.getSession();
			Transaction tx1 = session1.beginTransaction();
			User user1 = (User) session1.get(User.class, 1);
			System.out.println(user.getName());
			user.setName("–Ï∑Á");
			session1.update(user1);
			
			tx.commit();
		}catch(Exception e){
			if(tx != null ){
				tx.rollback();
				e.printStackTrace();
			}
		}finally{
			HibernateUtil.closeSession();
		}
			
	}
	public static void main(String[] args) {
		testGet1();
	}
	
}
