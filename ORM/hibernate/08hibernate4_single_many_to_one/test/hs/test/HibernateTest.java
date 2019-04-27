package hs.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import hs.pojo.Grade;
import hs.pojo.Student;
import hs.util.HibernateUtil;

public class HibernateTest {
	@Test
	public void testCreateDB(){
		Configuration cfg = new Configuration().configure();
		SchemaExport se = new SchemaExport(cfg);
		//��һ�������Ƿ�����DDL�ű����ڶ��������Ƿ�ִ�е����ݿ���
		se.create(true,true);
	}	
	@Test
	public void testSave() throws Exception{
		Session session = null;
		Transaction tx = null;		
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Grade grade = new Grade();
			grade.setName("������");
			session.save(grade);
			
			Student student = new Student();
			student.setName("�̷���");
			student.setAge(20);
			student.setGrade(grade);
			session.save(student);
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
