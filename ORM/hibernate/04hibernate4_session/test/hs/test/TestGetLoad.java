package hs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import hs.pojo.User;
import hs.util.HibernateUtil;

public class TestGetLoad {
	@Test
	public void testGet(){
		Session session = null;
		Transaction tx = null;
		User user = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			/**
			 * get后变为持久状态----getbyId
			 * get方法会立即查询该对象，范围从session->sessionFactory-->数据库中
			 * get方法如果找不到该对象，不会抛出异常，返回null。
			 */
			user = (User)session.get(User.class, 1);
			System.out.println(user.getName());
			//clear清除session缓存中所有对象，evict清除指定对象
			tx.commit();
			session.clear();
			//user游离状态不被session管理，数据库中不会被更改
			user.setName("飞扬");
			System.out.println(user.getName());
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateUtil.closeSession();
		}
	}
	@Test
	public void testLoad(){
		Session session = null;
		Transaction tx = null;
		User user = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			/**
			 * load后变为持久状态----getbyId
			 * 在3.x中load不会立即查询对象，到使用的时候才会查询。
			 * 4.3中 立即查询对象，
			 * load方法如果找不到该对象，会抛出异常。
			 */
			user = (User)session.load(User.class, 1);
			System.out.println(user.getName());
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateUtil.closeSession();
		}
	}
	@Test
	public void testDelete(){
		Session session = null;
		Transaction tx = null;
		User user = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			//手动构造一个对象，指定其主键，是可以删除该对象的，但是不建议这么用。
			//user = new User();
			//setId(2);
			//user.setName("飞扬");
			//session.delete(user);
			
			//删除对象建议以下这么使用
			user = (User) session.get(User.class, 2);
			//通过从数据库中加载该对象，然后删除可以进行判断，进而避免异常，提高程序的健壮性。
			if(user!=null){
				session.delete(user);
			}			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateUtil.closeSession();
		}
	}
	@Test
	public void testUpdate(){
		Session session = null;
		Transaction tx = null;
		User user = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			user = new User();
			user.setId(2);
			user.setName("飞扬");
			//手动构造对象，可以修该，但是需要制定所有属性，不建议使用
			//部分修改数据，修改配置文件中的一个配置。
			user = (User) session.get(User.class, 1);
			user.setName("徐风");
			session.update(user);			
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			HibernateUtil.closeSession();
		}
	}
}
