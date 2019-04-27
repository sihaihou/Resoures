package cn.siggy.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import cn.siggy.pojo.Book;
import cn.siggy.util.HibernateUtil;
@SuppressWarnings("unchecked")
public class HibernateTest {
	@Test
	public void testCreateDB(){		
		Configuration cfg = new Configuration().configure();
		SchemaExport se = new SchemaExport(cfg);
		se.create(true, true);
	}
	@Test
	public void testSave(){
		Session session = HibernateUtil.getSession();
		Book book = new Book();
		book.setName("�������");
		book.setPrice(60.5);
		book.setAuthor("Ī��");
		book.setPubDate(new Date());
		
		Book book1 = new Book();
		book1.setName("������ƫ��");
		book1.setPrice(80);
		book1.setAuthor("��.��˹͡");
		book1.setPubDate(new Date());
		
		Book book2 = new Book();
		book2.setName("�й���ʷ");
		book2.setPrice(30);
		book2.setAuthor("����");
		book2.setPubDate(new Date());
		
		Book book3 = new Book();
		book3.setName("Ʈ��֮��");
		book3.setPrice(70);
		book3.setAuthor("����");
		book3.setPubDate(new Date());
		Book book4 = new Book();
		book4.setName("��Ѫ��");
		book4.setPrice(60);
		book4.setAuthor("��˹��");
		book4.setPubDate(new Date());
		Book book5 = new Book();
		book5.setName("�ҵĴ�ѧ");
		book5.setPrice(60.5);
		book5.setAuthor("�߶���");
		book5.setPubDate(new Date());
		
		
		
		Transaction tx = session.beginTransaction();
		session.save(book);
		session.save(book1);
		session.save(book2);
		session.save(book3);
		session.save(book4);
		session.save(book5);
		tx.commit();
		HibernateUtil.closeSession();
	}
	@Test
	public void testSaveBatch(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		for(int i=0;i<10000;i++){
			Book book = new Book();
			book.setName("СС"+i);
			book.setPrice(60.5);
			book.setAuthor("Ī��");
			book.setPubDate(new Date());
			if(i%50==0)
				session.flush();
			session.save(book);
			
		}
	
		tx.commit();
		HibernateUtil.closeSession();
	}
	@Test
	public void testEvict(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Book book = (Book)session.get(Book.class, 1);
		//����sql���ȡ����
		System.out.println(book.getName());
		session.clear();
		//session.evict(book);
		System.out.println("---------");
		book = (Book)session.get(Book.class, 1);
		System.out.println(book.getName());
		tx.commit();
		HibernateUtil.closeSession();
	}
	@Test
	public void testGet(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Book book = (Book)session.get(Book.class, 1);
		//����sql���ȡ����
		System.out.println(book.getName());
		HibernateUtil.closeSession();
		session = HibernateUtil.getSession();
		System.out.println("---------");
		book = (Book)session.get(Book.class, 1);
		System.out.println(book.getName());
		tx.commit();
		HibernateUtil.closeSession();
	}
	//��ѯ����
	@Test
	public void testQueryCache(){
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		List<Book> list = session.createQuery("from Book")
						.setCacheable(true)//ʹ�ò�ѯ����
						.list();
		System.out.println(list.size());
		System.out.println("=========================");
		session.close();
		session = HibernateUtil.getSession();
		list = session.createQuery("from Book")
				.setCacheable(true)//ʹ�ò�ѯ����
				.list();
		System.out.println(list.size());
		tx.commit();
		HibernateUtil.closeSession();
	}
	
}
