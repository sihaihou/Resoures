package hs.test;

import java.sql.SQLException;
import java.util.Iterator;

import javax.sql.rowset.serial.SerialException;

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
			grade.setName("�м���");
			
			Student stu = new Student();
			stu.setName("�̷���");
			stu.setAge(20);
			stu.setGrade(grade);
			Student stu1 = new Student();
			stu1.setName("���");
			stu1.setAge(23);
			stu1.setGrade(grade);
			Student stu2 = new Student();
			stu2.setName("����");
			stu2.setAge(23);
			stu2.setGrade(grade);
			//����
			//�������ݵ�˳�� �Ǹ��������������������
			//����������Ϊnull,��ô�ȱ���һ��һ��
			//����������Ϊnull,��������Ᵽ��
			session.save(grade);
			session.save(stu);
			session.save(stu1);	
			session.save(stu2);	
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
}
