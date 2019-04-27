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
		category.setName("��ѧ");
		Category category1 = new Category();
		category1.setName("��ʷ");
		Category category2 = new Category();
		category2.setName("����");
		Category category3 = new Category();
		category3.setName("�ƻ�");
		Category category4 = new Category();
		category4.setName("�ֲ�");
		Book book = new Book();
		book.setName("�������");
		book.setPrice(60.5);
		book.setAuthor("Ī��");
		book.setPubDate(new Date());
		book.setCategory(category);
		
		Book book1 = new Book();
		book1.setName("������ƫ��");
		book1.setPrice(80);
		book1.setAuthor("��.��˹͡");
		book1.setPubDate(new Date());
		book1.setCategory(category1);
		
		Book book2 = new Book();
		book2.setName("�й���ʷ");
		book2.setPrice(30);
		book2.setAuthor("����");
		book2.setPubDate(new Date());
		book2.setCategory(category1);
		
		Book book3 = new Book();
		book3.setName("Ʈ��֮��");
		book3.setPrice(70);
		book3.setAuthor("����");
		book3.setPubDate(new Date());
		book3.setCategory(category2);
		Book book4 = new Book();
		book4.setName("��Ѫ��");
		book4.setPrice(60);
		book4.setAuthor("��˹��");
		book4.setPubDate(new Date());
		book4.setCategory(category3);
		Book book5 = new Book();
		book5.setName("�ҵĴ�ѧ");
		book5.setPrice(60.5);
		book5.setAuthor("�߶���");
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
		Category category = (Category)session.get(Category.class, 1);
		System.out.println("������:"+category.getName());
		for(Iterator<Book> iter=category.getBooks().iterator();iter.hasNext();){
			System.out.println(iter.next().getName());
		}
		
		tx.commit();
		HibernateUtil.closeSession();
	}
	@Test
	public void testLoad(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		List<Category> list = session.createCriteria(Category.class)
							.add(Restrictions.in("id", new Integer[]{1,3,5}))
							.list();
		System.out.println("���͸�����"+list.size());
		for(Category cate:list){
			System.out.println(cate.getName()+"--�鼮������"+cate.getBooks().size());
		}
		tx.commit();
		HibernateUtil.closeSession();
	}
	@Test
	public void testLoad1(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Book book = (Book)session.get(Book.class, 1);
		System.out.println(book.getName());
		System.out.println(book.getCategory().getName());
		tx.commit();
		HibernateUtil.closeSession();
	}
}
