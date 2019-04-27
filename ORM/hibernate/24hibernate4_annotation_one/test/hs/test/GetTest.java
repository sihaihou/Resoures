package hs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import hs.pojo.Book;
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
			System.out.println("����:"+b.getName()+"  ����:"+b.getAuthor()+"  �۸�:"+b.getPrice()+"  ��������:"+b.getPubDate());
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
