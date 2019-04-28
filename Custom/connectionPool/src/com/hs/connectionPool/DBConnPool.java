package com.hs.connectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *	 数据库连接池
 * @author sihai.hou
 *
 */
public class DBConnPool {
	/**
	 * 存放数据库连接池集合
	 */
	private  List<Connection> pool;  
	
	/**
	 * 数据库连接池最大数
	 */
	private static final int POOL_MAX_SIZE = DBManager.getConf().getPoolMaxSize(); 
	/**
	 * 数据库连接池最小数
	 */
	private static final int POOL_MIN_SIZE = DBManager.getConf().getPoolMinSize();  
	
	public DBConnPool() {
		initPool();
	}
	/**
	 * 初始化 数据库连接池
	 */
	public void initPool() {
		if(pool==null){
			pool = new ArrayList<Connection>();
		}
		
		while(pool.size()<DBConnPool.POOL_MIN_SIZE){
			pool.add(DBManager.createConn());
			System.out.println("书数据库连接池初始化成功！当前连接池数="+pool.size());
		}
	}
	
	
	/**
	 * 获取连接 ————最后一个
	 * @return
	 */
	public synchronized Connection getConnection() {
		int last_index = pool.size()-1;
		Connection conn = pool.get(last_index);
		pool.remove(last_index);
		return conn;
	}
	/**
	 * 关闭连接：将连接放回连接池
	 * @param conn
	 */
	public synchronized void close(Connection conn){
		if(pool.size()>=POOL_MAX_SIZE){
			try {
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			pool.add(conn);
		}
	}
}
