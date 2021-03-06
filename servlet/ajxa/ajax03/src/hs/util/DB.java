package hs.util;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	/**
	 * 获取Connection对象
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/ajax","root","123456");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 关闭 ResultSet Statement  Connection
	 * @param rs
	 * @param ps
	 * @param c
	 */
	public static void close(ResultSet rs,Statement ps,Connection c){
		try {	
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if( ps!=null){
			  ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		try {
			if(c!=null){
				c.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	/** 
	 * 关闭Statement  Connection
	 * @param ps
	 * @param c
	 */
	public static void close(Statement ps,Connection c){
		try {
			if( ps!=null){
			  ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		try {
			if(c!=null){
				c.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	/**
	 * 关闭Connection
	 * @param c
	 */
	public static void close(Connection c){
		try {
			if(c!=null){
				c.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	/**
	 * 关闭方法
	 * @param obj
	 */
	public static void close(Closeable... obj) {
		for(Closeable temp : obj) {
			if(temp != null) {
				try {
					temp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
