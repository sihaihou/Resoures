package hs.sorm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class JDBCUtil {
	/**
	 * ���԰����ʹ�����Դ�ļ��е�����
	 */
	static Properties pros=null;
	/**
	 * ֻ���ڼ���JDBCUtil���ʱ�����һ��
	 */
	static {    
		pros=new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��ȡMySql��Connection����
	 * @return
	 */
	public static Connection getMysqlConn(){
		try {
			Class.forName(pros.getProperty("mysqlDriver"));
			return DriverManager.getConnection(pros.getProperty("mysqlURL"),
					pros.getProperty("mysqlUser"),pros.getProperty("mysqlPwd"));	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}					
	}
	/**
	 * ��Orcle��Connection����
	 * @return
	 */
	public static Connection getOracleConn(){
		try {
			Class.forName(pros.getProperty("oracleDriver"));
			return DriverManager.getConnection(pros.getProperty("oracleURL"),
					pros.getProperty("oracleUser"),pros.getProperty("oraclePwd"));	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}					
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
