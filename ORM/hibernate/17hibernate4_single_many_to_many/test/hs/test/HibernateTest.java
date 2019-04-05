package hs.test;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import hs.pojo.Function;
import hs.pojo.Role;
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
	public void testSave(){
		Session session = null;
		Transaction tx = null;		
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Function f1 = new Function("�û�����","user_mag","userAction");
			Function f2 = new Function("��ɫ����","role_mag","roleAction");
			Function f3 = new Function("ϵͳ����","sys_mag","sysAction");
			Function f4 = new Function("Ȩ�޹���","prev_mag","prevAction");
			Role r1 = new Role();
			r1.setName("admin");
			r1.getFunctions().add(f1);
			r1.getFunctions().add(f2);
			r1.getFunctions().add(f3);
			r1.getFunctions().add(f4);
			Role r2 = new Role();
			r2.setName("vip");
			r2.getFunctions().add(f1);
			r2.getFunctions().add(f2);
			session.save(r1);
			session.save(r2);
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
	@Test
	public void getTest(){
		Session session = null;
		Transaction tx = null;		
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();			
			Role r = (Role) session.get(Role.class, 2);
			System.out.println("name:"+r.getName());
			System.out.println("�ý�ɫ�����е�Ȩ�ޣ�");
			for(Iterator<Function> iter = r.getFunctions().iterator();iter.hasNext();){
				Function f = iter.next();
				System.out.println("��������:"+f.getName()+"   "+f.getCode()+"   "+f.getUrl());
			}
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
