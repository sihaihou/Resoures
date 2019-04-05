package com.hs.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/**
 * 提供了:
 * 		1.获取SqLSession:getSqlSession(),
 * 		2.关闭SqlSession：closeSqlSession().		
 * 		
 * @author 侯四海
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
	 * 获取SqlSession
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
	 * 关闭SqlSession
	 */
	public static void closeSqlSession(){
		if(sqlSession!=null){
			sqlSession.close();
		}
	}	
}
