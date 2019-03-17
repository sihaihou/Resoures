package hs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC {
	/**
	 * ��ȡConnection����
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://39.107.247.102:3306/webpage","username","password");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * �ر� ResultSet Statement  Connection
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
	 * �ر�Statement  Connection
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
	 * �ر�Connection
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
}
