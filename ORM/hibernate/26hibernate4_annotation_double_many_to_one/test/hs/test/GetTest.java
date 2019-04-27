package hs.test;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import hs.pojo.Book;
import hs.pojo.Category;
import hs.util.HibernateUtil;
/**
 * 一对多     少的一端获取多的一端数据
 * @author Administrator
 */
public class GetTest {
	@Test
	public void testGet()throws Exception{
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Book b = (Book) session.get(Book.class, 1);
			System.out.println("书名:"+b.getName()+" 类型:"+b.getCategory().getName());
			
			Category c = (Category) session.get(Category.class, 1);
			System.out.println("类型:"+c.getName());
			for(Iterator<Book> iter = c.getBook().iterator();iter.hasNext();){
				Book book = iter.next();
				System.out.println(book.getName());
			}
			tx.commit();
		}catch(Exception e){
			if(tx!=null){
				tx.rollback();
				e.printStackTrace();
			}
		}finally{
			HibernateUtil.closeSession();
		}
	}
}
