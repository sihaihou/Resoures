package hs.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
public class JDBCUtil {
	static Properties pros=null;//可以帮助和处理资源文件中的内容
	static {    //只有在加载JDBCUtil类的时候调用一次
		pros=new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
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
