package com.hs.connectionPool;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库管理类
 * @author sihai.hou
 *
 */
public class DBManager {
	/**
	 * 配置文件信息
	 */
	private static Configuration conf;
	/**
	 * 数据连接池对象
	 */
	private static DBConnPool pool;
	static {  
		Properties pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
			conf = new Configuration();
			conf.setMysqlDriver(pros.getProperty("mysqlDriver"));
			conf.setMysqlPwd(pros.getProperty("mysqlPwd"));
			conf.setMysqlURL(pros.getProperty("mysqlURL"));
			conf.setMysqlUser(pros.getProperty("mysqlUser"));
			conf.setPoolMaxSize(Integer.parseInt(pros.getProperty("poolMaxSize")));
			conf.setPoolMinSize(Integer.parseInt(pros.getProperty("poolMinSize")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取Configuration
	 * @return
	 */
	public static Configuration getConf(){
		return conf;
	}
	/**
	 * 获取connection对象
	 * @return
	 */
	public static Connection getConn(){
		if(pool==null){
			pool = new DBConnPool();
		}
		return pool.getConnection();
	}
	
	/**
	 * 创建connection对象
	 * @return
	 */
	public static Connection createConn(){
		try {
			Class.forName(conf.getMysqlDriver());
			return DriverManager.getConnection(conf.getMysqlURL(),conf.getMysqlUser(),conf.getMysqlPwd());     
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 关闭
	 * @param rs
	 * @param ps
	 * @param conn
	 */
	public static void close(ResultSet rs,Statement ps,Connection conn){
		try {
			if(rs!=null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(ps!=null){
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//不使用连接池关闭conn
		/*try {
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	*/
        //使用连接池关闭conn		
		pool.close(conn);
			
	}
	
	/**
	 * 关闭
	 * @param ps
	 * @param conn
	 */
	public static void close(Statement ps,Connection conn){
		try {
			if(ps!=null){
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//不使用连接池关闭conn
//		try {
//		if(conn!=null){
//			conn.close();
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}		
        //使用连接池关闭conn		
		pool.close(conn);

	}
	public static void close(Connection conn){
		//不使用连接池关闭conn
//		try {
//		if(conn!=null){
//			conn.close();
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}		
        //使用连接池关闭conn		
		pool.close(conn);

	}
}
