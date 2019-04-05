package hs.test;

import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import hs.pojo.Book;
import hs.pojo.Category;
import hs.util.HibernateUtil;

public class HibernateTest {
	/**
	 * 创建数据库
	 */
	@Test
	public void testCreateDB(){
		Configuration cfg = new Configuration().configure();
		SchemaExport se = new SchemaExport(cfg);
		//第一个参数是否生成DDL脚本，第二个参数是否执行到数据库中
		se.create(true,true);
	}
	/**
	 * 一对多存数据
	 * @throws Exception
	 */
	@Test
	public void testSave() throws Exception{
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Category c = new Category();
			c.setName("励志");
			Category c1 = new Category();
			c1.setName("文学");
			Category c2 = new Category();
			c2.setName("恐怖");
			Category c3 = new Category();
			c3.setName("仙侠");
				
			Book b = new Book();
			b.setName("《别爱我》");
			b.setAuthor("程飞扬");
			b.setPrice(70);
			b.setPubDate(new Date());
			b.setCategory(c);
			Book b1 = new Book();
			b1.setName("《笑着活下去》");
			b1.setAuthor("姚芊羽");
			b1.setPrice(44);
			b1.setPubDate(new Date());	
			b1.setCategory(c1);	
			Book b2 = new Book();
			b2.setName("《鬼吹灯》");
			b2.setAuthor("天下霸唱");
			b2.setPrice(64);
			b2.setPubDate(new Date());	
			b2.setCategory(c2);	
			Book b3 = new Book();
			b3.setName("《仙剑奇侠传》");
			b3.setAuthor("胡歌");
			b3.setPrice(50);
			b3.setPubDate(new Date());	
			b3.setCategory(c3);	
															
			session.save(b);
			session.save(b1);
			session.save(b2);
			session.save(b3);
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
