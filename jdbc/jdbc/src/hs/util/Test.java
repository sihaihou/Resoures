package hs.util;

import java.sql.Connection;
/**
 * ���Է�װ��JDBC�����������ࣺJDBC��JDBCUtil
 */
public class Test {
	public static void main(String[] args) {
		//test1();
		test2();
	}
	/**
	 * ����JDBC������
	 */
	public static void test1(){
		Connection c=null;
		long start=System.currentTimeMillis();
		c=JDBC.getConnection();
		long end=System.currentTimeMillis();
		System.out.println("�������Ӻ�ʱ:"+(end-start)+"����");
		JDBC.close(c);	
	}
	/**
	 * ����JDBCUtil������
	 */
	public static void test2(){
		Connection c=null;
		long start=System.currentTimeMillis();
		c=JDBCUtil.getMysqlConn();
		long end=System.currentTimeMillis();
		System.out.println("�������Ӻ�ʱ:"+(end-start)+"����");
		JDBCUtil.close(c);	
	}
}
