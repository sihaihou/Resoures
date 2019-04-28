package hs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * 测试事务的基本概念和用法
 * @author Administrator
 */
public class Jdbc6 {
	@SuppressWarnings("null")
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Connection c=null;
		PreparedStatement ps1=null; 
		PreparedStatement ps2=null;
		try {			
			Class.forName("com.mysql.jdbc.Driver");		
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			ps1=c.prepareStatement("insert into t_user (name,pwd) values(?,?)");
			c.setAutoCommit(false);  
			ps1.setObject(1,"zhangsan");
			ps1.setObject(2,"123456");
			System.out.println("插入一个用户：zhangsan");
			ps1.execute();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ps2=c.prepareStatement("insert into t_user (name,pwd) values(?,?)");
			ps2.setObject(1, "麻子");
			ps2.setObject(2, "123456");
			ps2.execute();
			System.out.println("插入一个用户：麻子");
			c.commit();	          
		} catch (SQLException e) {
				e.printStackTrace();
				try {
					// 回滚到第一个sql语句,有一个sql执行语句失败，两条sql语句同时失败！				 
					c.rollback();	
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		}finally{
			if(null!=ps1){
				ps1.close();
			}
			JDBCUtil.close(ps2, c);
		}
	}
}
