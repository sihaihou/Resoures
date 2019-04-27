package hs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import hs.pojo.User;
import hs.util.HibernateUtil;

public class HibernateTest {
	@Test
	public void testSave(){
		Session session = null;
		Transaction tx = null;	
		User user = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			//�������--->˲ʱ״̬
		    user = new User();
			user.setName("�̷���");
			user.setPwd("888888");
			//�־�״̬   user��session��������id��ֵ--��Object id
			session.save(user);
			/**
			 * �ڳ־�״̬�£������ݼ�飬���ύ����������ʱ����session������
			 * �����ݿ���е����ݲ�һ��ʱ�������session�е����ݸ��µ����ݿ��С�
			 */
			user.setName("���");
			//�ڱ����Ժ����޸Ķ�����ô�����������sql��䣬��ôЧ�ʽϵ�,����saveǰ�޸ġ�
			session.flush();
			//tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally {
			HibernateUtil.closeSession();
		}
		//user:����״̬
		System.out.println("name:"+user.getName());
		user.setName("����");
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			//�־�״̬
			session.update(user);
			session.save(user);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally {
			HibernateUtil.closeSession();
		}
	}
}
