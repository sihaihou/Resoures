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
		//第一个参数是否生成DDL脚本，第二个参数是否执行到数据库中
		se.create(true,true);
	}
	@Test
	public void testSave(){
		Session session = null;
		Transaction tx = null;		
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Function f1 = new Function("用户管理","user_mag","userAction");
			Function f2 = new Function("角色管理","role_mag","roleAction");
			Function f3 = new Function("系统管理","sys_mag","sysAction");
			Function f4 = new Function("权限管理","prev_mag","prevAction");
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
			System.out.println("该角色所具有的权限：");
			for(Iterator<Function> iter = r.getFunctions().iterator();iter.hasNext();){
				Function f = iter.next();
				System.out.println("管理名称:"+f.getName()+"   "+f.getCode()+"   "+f.getUrl());
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
