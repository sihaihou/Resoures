package com.hs.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * �ṩ��:
 * 		1.��ȡSqLSession:getSqlSession(),
 * 		2.�ر�SqlSession��closeSqlSession().		
 * 		
 * @author ���ĺ�
 *
 */
public class MyBatisUtil {
	private static InputStream inputstream = null;	
	private static SqlSessionFactory factory = null;
	private static SqlSession sqlSession = null;
	static{
			try {
				inputstream = Resources.getResourceAsStream("mybatis.xml");
				factory = new SqlSessionFactoryBuilder().build(inputstream); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	/**
	 * ��ȡSqlSession
	 * @return
	 */
	public static SqlSession getSqlSession(){
		if(factory != null){
			return sqlSession = factory.openSession();
		}else{
			try {
				inputstream = Resources.getResourceAsStream("mybatis.xml");
				factory = new SqlSessionFactoryBuilder().build(inputstream);
				return sqlSession =  factory.openSession();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		return null;		
	}
	/**
	 * �ر�SqlSession
	 */
	public static void closeSqlSession(){
		if(sqlSession!=null){
			sqlSession.close();
		}
	}	
}
