package hs.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import hs.pojo.Grade;
import hs.pojo.Student;
import hs.util.HibernateUtil;

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
			Iterator<Student> iter = grade.getStudents().iterator();
			for(;iter.hasNext();){
				Student st = iter.next();
				System.out.println("name: "+st.getName()+"    age: "+st.getAge());
			}
			Student stu = (Student)session.get(Student.class, 1);
			System.out.println("studentname: "+stu.getName()+"   gradeName: "+stu.getGrade().getName());
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
	
	
	
	/**
	 * 过滤器的使用：链接28hibernate4_hql/test/hs.test.GetTest第testQuery17
	 * 
	 * 过滤器的使用     ---过滤查询--为查询加上某些条件
	 *   1，定义过滤器
	 *   2，使用:加条件
	 *   3，在查询的时候，使得过滤器生效
	 *
	 */
	@Test
	public void testQuery17(){	
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		//启用过滤器
		session.enableFilter("studentFilter").setParameter("id", 2);
		List<Student> list = session.createQuery("from Student").list();
		for(Student s:list){
			System.out.println("id:"+s.getId()+"    name:"+s.getName());
		}
		tx.commit();
		HibernateUtil.closeSession();	
	}
}
