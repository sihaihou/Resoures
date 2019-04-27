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
	 * �������ݿ�
	 */
	@Test
	public void testCreateDB(){
		Configuration cfg = new Configuration().configure();
		SchemaExport se = new SchemaExport(cfg);
		//��һ�������Ƿ�����DDL�ű����ڶ��������Ƿ�ִ�е����ݿ���
		se.create(true,true);
	}
	/**
	 * һ�Զ������
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
			c.setName("��־");
			
			Book b = new Book();
			b.setName("�����ҡ�");
			b.setAuthor("�̷���");
			b.setPrice(66);
			b.setPubDate(new Date());
			b.setCategory(c);
			Book b1 = new Book();
			b1.setName("��Ц�Ż���ȥ��");
			b1.setAuthor("Ҧܷ��");
			b1.setPrice(44);
			b1.setPubDate(new Date());	
			b1.setCategory(c);	
			session.save(b);
			session.save(b1);
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
