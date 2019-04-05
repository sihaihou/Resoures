package hs.test;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import hs.pojo.Grade;
import hs.pojo.Student;
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
			Grade grade = (Grade) session.get(Grade.class, 1);
			System.out.println("gradeName:"+grade.getName());
			System.out.println("grade����Ӧ�Ķ��һ�����ݣ�");
			Iterator<Student> iter = grade.getStudents().iterator();
			for(;iter.hasNext();){
				Student st = iter.next();
				System.out.println("name:  "+st.getName()+"age:  "+st.getAge());
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
