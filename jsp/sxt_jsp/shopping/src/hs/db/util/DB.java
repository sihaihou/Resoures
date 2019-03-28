package hs.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class DB {
	private DB() {
		
	}
	/**
	 * 获取Connection对象
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","123456");
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return null;
	}
	
	public static Statement getStamt(Connection conn){
		Statement stamt = null;
		try {
			stamt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stamt;		
	}
	public static PreparedStatement getPs(Connection conn,String sql){
		PreparedStatement ps = null;
		try {
			ps = (PreparedStatement) conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;		
	}
	public static ResultSet getRs(Statement ps,String sql){
		ResultSet rs= null;
		try {
			rs=ps.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;		
	}
	public static ResultSet getRs(Connection conn,String sql){
		ResultSet rs= null;
		try {
			rs=conn.createStatement().executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;		
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
	public static void close(ResultSet rs,Connection c){
		try {	
			if(rs!=null){
				rs.close();
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
}
