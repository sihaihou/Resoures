package hs.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import hs.pojo.User;

public class TestException {
	public static void main(String[] args) {
		Configuration cfg = null;
		SessionFactory sf = null;
		Transaction tx = null;
		Session session = null;
		try{
			cfg = new Configuration().configure();			
			ServiceRegistry regieter = new StandardServiceRegistryBuilder().
						applySettings(cfg.getProperties()).build();
		    sf = cfg.buildSessionFactory(regieter);			
		    session = sf.openSession();
			tx = session.beginTransaction();
			User user = (User) session.get(User.class, 1);
			System.out.println("name:"+user.getName());
			//6.提交事物
			tx.commit();
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			//回滚事务
		}finally{
			//7.关闭session
			if(session!=null&&session.isOpen()){
				session.close();
			}
		}
	}
}
