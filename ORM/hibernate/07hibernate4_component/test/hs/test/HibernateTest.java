package hs.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import hs.pojo.Address;
import hs.pojo.Teacher;
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
			Teacher t = new Teacher();
			Address address = new Address();
			t.setName("�̷���");
			t.setSex("Ů");
			address.setAddr1("�й�");
			address.setAddr2("̨��");
			address.setAddr3("���");
			t.setAddress(address);
			session.save(t);
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
