package hs.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import hs.pojo.Person;
import hs.pojo.Student;
import hs.pojo.Teacher;
import hs.util.HibernateUtil;

public class HibernateTest {
	/**
	 * �������ݿ�
	 */
	@Test
	public void testCreateDB(){
		Configuration cfg = new Configuration().configure();
		SchemaExport se = new SchemaExport(cfg);
		//��һ�������Ƿ�����DDL�ű����ڶ��������Ƿ�ִ�е����ݿ���
		se.create(true,true);
	}
	/**
	 * һ�Զ������
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception{
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Teacher t = new Teacher();
			t.setName("���");
			t.setAge(20);
			t.setSalary(20000);
			
			Student s = new Student();
			s.setName("�̷���");
			s.setAge(23);
			s.setWork("hibernate...");
			Student s1 = new Student();
			s1.setName("����");
			s1.setAge(20);
			s1.setWork("hard Play...");
			session.save(t);
			session.save(s);
			session.save(s1);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
				throw e;
			}
		}finally{
			HibernateUtil.closeSession();
		}
	}
}
