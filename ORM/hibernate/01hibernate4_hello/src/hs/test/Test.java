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
		//1.�½�Configuration����		
		Configuration cfg = new Configuration().configure();
		//2��ͨ��Configuration����SessionFactory����
		//hibernate4.3
		ServiceRegistry regieter = new StandardServiceRegistryBuilder().
				applySettings(cfg.getProperties()).build();
		SessionFactory sf = cfg.buildSessionFactory(regieter);
		//3.ͨ��SessionFactory�õ�Session����
		Session session = sf.openSession();
		//4.ͨ��Session����õ�Transaction����
		//��������.01
		Transaction tx = session.beginTransaction();//��һ��д��
		//Transaction trans= session.getTransaction();//�ڶ���д��
		//trans.begin();
		//5.��������
		User user = new User();
		user.setName("����");
		user.setPwd("123456");
		session.save(user);
		//6.�ύ����
		tx.commit();
		//7.�ر�session
		if(session!=null){
			System.out.println("�����ύ�ɹ�...");
			session.close();
		}else{
			System.out.println("�����ύʧ��.");
		}		
	}
}
