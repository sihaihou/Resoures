package hs.test;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import hs.pojo.Book;
import hs.pojo.Category;
import hs.util.HibernateUtil;
/**
 * һ�Զ�     �ٵ�һ�˻�ȡ���һ������
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
			System.out.println("����:"+b.getName()+" ����:"+b.getCategory().getName());
			
			Category c = (Category) session.get(Category.class, 1);
			System.out.println("����:"+c.getName());
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
