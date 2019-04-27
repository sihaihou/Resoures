package hs.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import hs.pojo.Book;
import hs.pojo.Category;
import hs.util.HibernateUtil;
/**
 * lazy
 * @author Administrator
 */
public class GetTest {
	@Test
	public void testGet(){			
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();		
		Category c = (Category) session.get(Category.class, 1);
		System.out.println("分类名:"+ c.getName());
		for(Iterator<Book> iter = c.getBooks().iterator();iter.hasNext();){
			Book b = iter.next();
			System.out.println("书名:"+b.getName());
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}	
}
