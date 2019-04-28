package hs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
/**
 * 测试PreparedStatement语句及基本用法！
 * @author Administrator
 */
public class Jdbc3_1 {
	public static void main(String[] args) throws ClassNotFoundException {
		Connection c=null;
		PreparedStatement ps=null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");		
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");			
			// ?  占位符
			String sql="insert into t_user (name,pwd,date) values (?,?,?)";
			ps=(PreparedStatement) c.prepareStatement(sql);
			/*ps.setString(1, "李四"); //参数：索引从 1 开始
			ps.setString(2, "123456");
			ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));*/			
			ps.setObject(1, "李四");
			ps.setObject(2, "123456");
			ps.setObject(3, new Date());
			System.out.println("插入一条记录...");
			ps.execute();
		} catch (SQLException e) {
				e.printStackTrace();		
		}finally{
			JDBCUtil.close(ps, c);
		}
	}
}
