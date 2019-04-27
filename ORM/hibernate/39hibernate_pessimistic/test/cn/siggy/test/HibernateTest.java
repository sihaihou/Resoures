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
			//�ڳ־�״̬�£������ݼ�飺���ύ����������ʱ����session������
			//�����ݿ������ݲ�һ��ʱ�������session�е����ݸ��µ����ݿ���
			user.setName("ѧ��");
			//�ڱ����Ժ� ���޸Ķ��� ��ô�������2��sql��䣬��ôЧ�ʽϵͣ�������saveǰ�޸�
			session.flush();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateUtil.closeSession();
		}
		//user:����״̬
		System.out.println("������"+user.getName());
		user.setName("��ΰ");
		try {
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			//�־�״̬
			session.update(user);
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
			user = (User)session.get(User.class, 1, LockOptions.UPGRADE);
			System.out.println(user.getName());
			user.setName("����1");
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
			user = (User)session.get(User.class, 1, LockOptions.UPGRADE);
			System.out.println(user.getName());
			user.setName("����1");
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
