package cn.siggy.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import cn.siggy.pojo.Book;
import cn.siggy.pojo.Category;
import cn.siggy.util.HibernateUtil;
@SuppressWarnings("unchecked")
public class HibernateTest {
	@Test
	public void testCreateDB(){
		//3.x
		//Configuration cfg = new AnnotationConfiguration().configure();
		Configuration cfg = new Configuration().configure();
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}
	@Test
	public void testSave(){
		Session session = HibernateUtil.getSession();
		
		Category category = new Category();
		category.setName("文学");
		Category category1 = new Category();
		category1.setName("历史");
		Category category2 = new Category();
		category2.setName("仙侠");
		Category category3 = new Category();
		category3.setName("科幻");
		Category category4 = new Category();
		category4.setName("恐怖");
		Book book = new Book();
		book.setName("丰乳肥臀");
		book.setPrice(60.5);
		book.setAuthor("莫言");
		book.setPubDate(new Date());
		book.setCategory(category);
		
		Book book1 = new Book();
		book1.setName("傲慢与偏见");
		book1.setPrice(80);
		book1.setAuthor("简.奥斯汀");
		book1.setPubDate(new Date());
		book1.setCategory(category1);
		
		Book book2 = new Book();
		book2.setName("中国历史");
		book2.setPrice(30);
		book2.setAuthor("人民");
		book2.setPubDate(new Date());
		book2.setCategory(category1);
		
		Book book3 = new Book();
		book3.setName("飘渺之旅");
		book3.setPrice(70);
		book3.setAuthor("萧鼎");
		book3.setPubDate(new Date());
		book3.setCategory(category2);
		Book book4 = new Book();
		book4.setName("蓝血人");
		book4.setPrice(60);
		book4.setAuthor("卫斯里");
		book4.setPubDate(new Date());
		book4.setCategory(category3);
		Book book5 = new Book();
		book5.setName("我的大学");
		book5.setPrice(60.5);
		book5.setAuthor("高尔基");
		book5.setPubDate(new Date());
		book5.setCategory(category);
		
		
		
		Transaction tx = session.beginTransaction();
		session.save(book);
		session.save(book1);
		session.save(book2);
		session.save(book3);
		session.save(book4);
		session.save(book5);
		session.save(category4);
		tx.commit();
		HibernateUtil.closeSession();
	}
	@Test
	public void testGet(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		String hql="from Book";
		List<Book> list = session.createQuery(hql)
				.list();
		for(Iterator<Book> iter = list.iterator();iter.hasNext();){
			Book book = iter.next();
			System.out.println(book.getName());
			System.out.println(book.getCategory().getName());
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
	@Test
	public void testGet1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		List<Category> list = session.createQuery("from Category").list();
		
		for(Iterator<Category> iter = list.iterator();iter.hasNext();){
			Category cate = iter.next();
			System.out.println(cate.getName());
			System.out.println(cate.getBooks().size());
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
}
