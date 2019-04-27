package hs.test;

import java.sql.SQLException;
import java.util.Iterator;

import javax.sql.rowset.serial.SerialException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import hs.pojo.Grade;
import hs.pojo.Student;
import hs.util.HibernateUtil;

public class HibernateTest {
	@Test
	public void testCreateDB(){
		Configuration cfg = new Configuration().configure();
		SchemaExport se = new SchemaExport(cfg);
		//第一个参数 是否生成ddl脚本  第二个参数  是否执行到数据库中
		se.create(true, true);
	}
	@Test
	public void testSave() throws HibernateException, SerialException, SQLException{
		Session session = null;
		Transaction tx = null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();
			Grade grade = new Grade();
			grade.setName("中级班");
			
			Student stu = new Student();
			stu.setName("程飞扬");
			stu.setAge(20);
			stu.setGrade(grade);
			Student stu1 = new Student();
			stu1.setName("徐风");
			stu1.setAge(23);
			stu1.setGrade(grade);
			Student stu2 = new Student();
			stu2.setName("胡歌");
			stu2.setAge(23);
			stu2.setGrade(grade);
			//关联
			//保存数据的顺序 是根据外键的配置来决定的
			//如果外键不能为null,那么先保存一的一端
			//如果外键可以为null,则可以随意保存
			session.save(grade);
			session.save(stu);
			session.save(stu1);	
			session.save(stu2);	
			tx.commit();			
		}catch (HibernateException e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			HibernateUtil.closeSession();
		}
	}
}
