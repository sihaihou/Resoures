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
			//�������--˲ʱ״̬
			user = new User();
			user.setName("���»�");
			user.setPwd("2222");
			//�־�״̬��user��session��������id��ֵ--oid
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
			user1.setName("����");
			session1.update(user1);
			tx1.commit();
			
			session.update(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			//�ر�session
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
			user.setName("����2");
			session.update(user);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			//�ر�session
			HibernateUtil.closeSession();
		}
		
	}
}
