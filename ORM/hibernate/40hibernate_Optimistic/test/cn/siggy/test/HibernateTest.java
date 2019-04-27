package cn.siggy.test;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.siggy.pojo.User;
import cn.siggy.util.HibernateUtil;

public class HibernateTest {
	@Test
	public void testSave(){
		Session session=null;
		Transaction tx=null;
		User user=null;
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			//构造对象--瞬时状态
			user = new User();
			user.setName("刘德华");
			user.setPwd("2222");
			//持久状态，user被session管理，并且id有值--oid
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateUtil.closeSession();
		}
	}
	
	@Test
	public void testGet(){
		Session session=null;
		Transaction tx=null;
		User user=null;
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			user = (User)session.get(User.class, 1);
			System.out.println(user.getName());
			user.setName("siggy");
			
			Session session1 = HibernateUtil.getSession();
			Transaction tx1 = session1.beginTransaction();
			User user1 = (User)session1.get(User.class, 1);
			System.out.println(user1.getName());
			user1.setName("李四");
			session1.update(user1);
			tx1.commit();
			
			session.update(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			//关闭session
			HibernateUtil.closeSession();
		}
		
	}
	@Test
	public void testGet1(){
		Session session=null;
		Transaction tx=null;
		User user=null;
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			user = (User)session.get(User.class, 1);
			System.out.println(user.getName());
			user.setName("张三2");
			session.update(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			//关闭session
			HibernateUtil.closeSession();
		}
		
	}
}
