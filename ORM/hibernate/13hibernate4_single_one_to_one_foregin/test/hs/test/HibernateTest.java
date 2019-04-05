package hs.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import hs.pojo.IdCard;
import hs.pojo.Person;
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
			
			IdCard id1 = new IdCard();
			id1.setCard("420621199711112753");
			IdCard id2 = new IdCard();
			id2.setCard("420621199404122770");
			
			Person p1 = new Person();
			p1.setName("程飞扬");
			p1.setAge(21);
			p1.setIdCard(id1);
			Person p2 = new Person();
			p2.setName("徐风");
			p2.setAge(23);			
			p2.setIdCard(id2);
			//反实验组
//			Person p3 = new Person();
//			p3.setName("小熊");
//			p3.setAge(23);			
//			p3.setIdCard(id1);
						
			session.save(p1);
			session.save(p2);
//			session.save(p3);
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
