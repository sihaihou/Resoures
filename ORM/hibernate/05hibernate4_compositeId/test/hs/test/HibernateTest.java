package hs.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import hs.pojo.Score;
import hs.pojo.ScoreId;
import hs.util.HibernateUtil;

public class HibernateTest {
	@Test
	public void testCreateDB(){
		Configuration cfg = new Configuration().configure();
		SchemaExport se = new SchemaExport(cfg);
		//第一个参数是否生成DDL脚本，第二个参数是否执行到数据库中
		se.create(true,true);
	}	
	@Test
	public void testSave(){
		Session session = null;
		Transaction tx = null;
		Score score = null;
		ScoreId scoreId =null;
		try{
			session = HibernateUtil.getSession();
			tx = session.beginTransaction();		
			score = new Score();
			scoreId = new ScoreId();
			scoreId.setStuId(3);
			scoreId.setSubId(2);
			score.setResult(90);
			score.setScoreId(scoreId);
			
			session.save(score);
			tx.commit();
		}catch(HibernateException e){
			if(tx!=null){
				tx.rollback();
				throw e;
			}
		}finally{
			HibernateUtil.closeSession();
		}
	}
}
