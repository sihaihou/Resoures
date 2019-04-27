package hs.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import hs.pojo.User;

public class Test {
	public static void main(String[] args) throws Exception {
		//1.新建Configuration对象		
		Configuration cfg = new Configuration().configure();
		//2。通过Configuration创建SessionFactory对象
		//hibernate4.3
		ServiceRegistry regieter = new StandardServiceRegistryBuilder().
				applySettings(cfg.getProperties()).build();
		SessionFactory sf = cfg.buildSessionFactory(regieter);
		//3.通过SessionFactory得到Session对象
		Session session = sf.openSession();
		//4.通过Session对象得到Transaction对象
		//开启事物.01
		Transaction tx = session.beginTransaction();//第一种写法
		//Transaction trans= session.getTransaction();//第二种写法
		//trans.begin();
		//5.保存数据
		User user = new User();
		user.setName("张三");
		user.setPwd("123456");
		session.save(user);
		//6.提交事物
		tx.commit();
		//7.关闭session
		if(session!=null){
			System.out.println("数据提交成功...");
			session.close();
		}else{
			System.out.println("数据提交失败.");
		}		
	}
}
