package hs.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import hs.pojo.Person;
import hs.pojo.Student;
import hs.pojo.Teacher;
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
			Person p = (Person) session.get(Person.class, 1);
			System.out.println(p.getName());
			if(p instanceof Student){
				Student s = (Student)p;
				System.out.println("家庭作业:"+s.getWork());
			}else if(p instanceof Teacher ) {
				Teacher t = (Teacher)p;
				System.out.println("薪水:"+t.getSalary());			
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
