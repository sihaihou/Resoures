package hs.test;

import java.sql.Blob;
import java.sql.Clob;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialClob;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

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
		Student stu = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			stu = new Student();
			stu.setName("�̷���");
			stu.setAge(20);
			Blob blob =  new SerialBlob("tt".getBytes());
			Clob clob = new SerialClob("dsad".toCharArray());
			stu.setImage(blob);
			session.save(stu);
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
