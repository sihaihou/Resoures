package cn.siggy.test;

import java.sql.SQLException;

import javax.sql.rowset.serial.SerialException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import cn.siggy.pojo.Grade;
import cn.siggy.pojo.Student;
import cn.siggy.util.HibernateUtil;

public class HibernateTest {
	@Test
	public void testCreateDB(){
		Configuration cfg = new Configuration().configure();
		SchemaExport se = new SchemaExport(cfg);
		//��һ������ �Ƿ�����ddl�ű�  �ڶ�������  �Ƿ�ִ�е����ݿ���
		se.create(true, true);
	}
	@Test
	public void testSave() throws HibernateException, SerialException, SQLException{
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Grade grade = new Grade();
			grade.setName("����");
			
			Student stu = new Student();
			stu.setName("������");
			stu.setAge(22);
			stu.setGrade(grade);
			Student stu1 = new Student();
			stu1.setName("����");
			stu1.setAge(23);
			stu1.setGrade(grade);
			
			grade.getStudents().add(stu);
			grade.getStudents().add(stu1);
			session.save(grade);
			session.save(stu);
			session.save(stu1);
			
			tx.commit();
			
		}catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			HibernateUtil.closeSession();
		}
	}
	@Test
	public void testGet(){
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			
			Grade grade = (Grade)session.get(Grade.class, 1);
			session.delete(grade);
			tx.commit();
		}catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			//throw e;
		}finally{
			HibernateUtil.closeSession();
		}
	}
}
