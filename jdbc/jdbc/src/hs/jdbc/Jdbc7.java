package hs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
/**
 * 测试事务的基本概念和用法
 * 			随机插入 数据
 * @author Administrator
 */
public class Jdbc7 {
	@SuppressWarnings("null")
	public static void main(String[] args) throws ClassNotFoundException {
		Connection c=null;
		PreparedStatement ps=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			c.setAutoCommit(false);  
			ps=c.prepareStatement("insert into t_user2 (name,pwd,date) values(?,?,?)");
			for(int i=0;i<200;i++){
				ps.setObject(1,"紫霞"+i);
				ps.setObject(2,"123456");
				int rand=1000*60*60*24*30*3*new Random().nextInt(100000000);
				ps.setObject(3,new java.sql.Timestamp(System.currentTimeMillis()-rand));
				ps.execute();	
				c.commit();	 
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		}finally{
			JDBCUtil.close(ps, c);
		}
	}
}
