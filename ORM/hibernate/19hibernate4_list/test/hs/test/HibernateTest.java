package hs.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import hs.pojo.Grade;
import hs.pojo.Student;
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
			Grade grade = new Grade();
			grade.setName("�м���");	
			
			Student student = new Student();
			student.setName("�̷���");
			student.setAge(20);
			Student student1 = new Student();
			student1.setName("���");
			student1.setAge(22);
			Student student2 = new Student();
			student2.setName("����");
			student2.setAge(20);
			//����
			grade.getStudents().add(student);
			grade.getStudents().add(student1);
			grade.getStudents().add(student2);
			//�ȱ���༶|ѧ����������Ƿ����Ϊ��
			session.save(grade);
			session.save(student);
			session.save(student1);
			session.save(student2);
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
