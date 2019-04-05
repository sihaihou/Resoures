package hs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import hs.pojo.User;
import hs.util.HibernateUtil;

public class TestGetLoad {
	@Test
	public void testGet(){
		Session session = null;
		Transaction tx = null;
		User user = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			/**
			 * get���Ϊ�־�״̬----getbyId
			 * get������������ѯ�ö��󣬷�Χ��session->sessionFactory-->���ݿ���
			 * get��������Ҳ����ö��󣬲����׳��쳣������null��
			 */
			user = (User)session.get(User.class, 1);
			System.out.println(user.getName());
			//clear���session���������ж���evict���ָ������
			tx.commit();
			session.clear();
			//user����״̬����session�������ݿ��в��ᱻ����
			user.setName("����");
			System.out.println(user.getName());
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateUtil.closeSession();
		}
	}
	@Test
	public void testLoad(){
		Session session = null;
		Transaction tx = null;
		User user = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			/**
			 * load���Ϊ�־�״̬----getbyId
			 * ��3.x��load����������ѯ���󣬵�ʹ�õ�ʱ��Ż��ѯ��
			 * 4.3�� ������ѯ����
			 * load��������Ҳ����ö��󣬻��׳��쳣��
			 */
			user = (User)session.load(User.class, 1);
			System.out.println(user.getName());
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateUtil.closeSession();
		}
	}
	@Test
	public void testDelete(){
		Session session = null;
		Transaction tx = null;
		User user = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			//�ֶ�����һ������ָ�����������ǿ���ɾ���ö���ģ����ǲ�������ô�á�
			//user = new User();
			//setId(2);
			//user.setName("����");
			//session.delete(user);
			
			//ɾ��������������ôʹ��
			user = (User) session.get(User.class, 2);
			//ͨ�������ݿ��м��ظö���Ȼ��ɾ�����Խ����жϣ����������쳣����߳���Ľ�׳�ԡ�
			if(user!=null){
				session.delete(user);
			}			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateUtil.closeSession();
		}
	}
	@Test
	public void testUpdate(){
		Session session = null;
		Transaction tx = null;
		User user = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			user = new User();
			user.setId(2);
			user.setName("����");
			//�ֶ�������󣬿����޸ã�������Ҫ�ƶ��������ԣ�������ʹ��
			//�����޸����ݣ��޸������ļ��е�һ�����á�
			user = (User) session.get(User.class, 1);
			user.setName("���");
			session.update(user);			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateUtil.closeSession();
		}
	}
}
