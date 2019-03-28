package hs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 测试sql语句，以及sql注入问题   
 *  存在风险          一般不用
 * @author Administrator
 */
public class Jdbc2 {
	public static void main(String[] args) {
		Connection c=null;
		Statement stmt=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			stmt=c.createStatement();
			String name="张三";
			String sql="insert into t_user (name,pwd,date) values('"+name+"',123456,now())";
			stmt.execute(sql);
		
			//测试sql注入      ----存在风险
		/*	String id="12";
			String sql="delete from t_user where id="+id;
			stmt.execute(sql);	*/	
		} catch (SQLException e) {
				e.printStackTrace();		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(stmt, c);
		}
	}
}
