package hs.util;

import java.sql.Connection;
/**
 * 测试封装的JDBC的两个工具类：JDBC、JDBCUtil
 */
public class Test {
	public static void main(String[] args) {
		//test1();
		test2();
	}
	/**
	 * 测试JDBC工具类
	 */
	public static void test1(){
		Connection c=null;
		long start=System.currentTimeMillis();
		c=JDBC.getConnection();
		long end=System.currentTimeMillis();
		System.out.println("建立连接耗时:"+(end-start)+"毫秒");
		JDBC.close(c);	
	}
	/**
	 * 测试JDBCUtil工具类
	 */
	public static void test2(){
		Connection c=null;
		long start=System.currentTimeMillis();
		c=JDBCUtil.getMysqlConn();
		long end=System.currentTimeMillis();
		System.out.println("建立连接耗时:"+(end-start)+"毫秒");
		JDBCUtil.close(c);	
	}
}
