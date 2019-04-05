package hs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import hs.pojo.User;
import hs.util.HibernateUtil;

public class HibernateTest {
	@Test
	public void testSave(){
		Session session = null;
		Transaction tx = null;	
		User user = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			//构造对象--->瞬时状态
		    user = new User();
			user.setName("程飞扬");
			user.setPwd("888888");
			//持久状态   user被session管理，并且id有值--是Object id
			session.save(user);
			/**
			 * 在持久状态下，脏数据检查，当提交事务，清理缓存时发现session中数据
			 * 和数据库表中的数据不一致时，将会把session中的数据更新到数据库中。
			 */
			user.setName("徐凤");
			//在保存以后，再修改对象，那么将会产生多条sql语句，那么效率较低,建议save前修改。
			session.flush();
			//tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally {
			HibernateUtil.closeSession();
		}
		//user:游离状态
		System.out.println("name:"+user.getName());
		user.setName("飞扬");
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			//持久状态
			session.update(user);
			session.save(user);
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally {
			HibernateUtil.closeSession();
		}
	}
}
