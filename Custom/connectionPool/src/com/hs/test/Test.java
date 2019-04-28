package com.hs.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

import com.hs.connectionPool.DBManager;

public class Test{
	public static void main(String[] args) throws SQLException {
		long start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) {
			test();
		}
		long end = System.currentTimeMillis();
		System.err.println(end-start);
		
	}
	/**
	 * ��ѯ10000�� ʹ�����ӳغ�ʱ��4374
	 * @throws SQLException
	 */
	public static void test() throws SQLException {
		Connection conn = DBManager.getConn();
		PreparedStatement ps = conn.prepareStatement("select id,name,salary from emp");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println("name == "+rs.getString(1));
			System.out.println("nmae == "+rs.getString(2));;
			System.out.println("nmae == "+rs.getString(3));;
		}
		DBManager.close(rs,ps,conn);
	}
	/**
	 * ��ѯ  10000 ��  δʹ�����ӳغ�ʱ��63717
	 * @throws SQLException
	 */
	public static void test1() throws SQLException {
		Connection conn = DBManager.createConn();
		PreparedStatement ps = conn.prepareStatement("select id,name,salary from emp");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			System.out.println("name == "+rs.getString(1));
			System.out.println("nmae == "+rs.getString(2));;
			System.out.println("nmae == "+rs.getString(3));;
		}
		DBManager.close(rs,ps,conn);
	}
}
