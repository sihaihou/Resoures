package hs.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import hs.pojo.Grade;
import hs.pojo.Student;
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
			Grade grade = (Grade) session.get(Grade.class, 1);
			System.out.println("gradeName:"+grade.getName());
			System.out.println("grade所对应的多的一端数据：");
			List<Student> list = grade.getStudents();
			for(Student s:list){
				System.out.println("name:"+s.getName()+"    age:"+s.getAge());
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
