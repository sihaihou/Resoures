package hs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import hs.pojo.Book;
import hs.util.HibernateUtil;
/**
 *	lazy
 * @author Administrator
 *
 */
public class GetTest {	
	@Test
	public void testGet(){			
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Book b = (Book) session.get(Book.class, 1);
//		System.out.println("������"+"-----"+b.getName());
		tx.commit();
		HibernateUtil.closeSession();	
		System.out.println("������"+"-----"+b.getName());
	}	
	@Test
	public void testLoad(){			
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		Book b = (Book) session.load(Book.class, 1);
//		System.out.println("������"+"-----"+b.getName());
		tx.commit();
		HibernateUtil.closeSession();
		//����proxy no session 
		System.out.println("������"+"-----"+b.getName());
	}	
}
