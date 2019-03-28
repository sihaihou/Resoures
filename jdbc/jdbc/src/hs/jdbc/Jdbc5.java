package hs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 测试批处理
 * @author Administrator
 */
public class Jdbc5 {
	public static void main(String[] args) throws ClassNotFoundException {
		Connection c=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			 //设为手动提交数据  ----默认为自动提交
			c.setAutoCommit(false);  
			long start=System.currentTimeMillis();
			stmt=c.createStatement();
			for(int i=1;i<200;i++){
				stmt.addBatch("insert into t_user2 (name,pwd,date) values ('"+i+"',123456,now())");
			}
			stmt.executeBatch();
			//提交数据
			c.commit();			
			long end=System.currentTimeMillis();
			System.out.println("插入200条数据耗时（毫秒）:"+(end-start));
		} catch (SQLException e) {
				e.printStackTrace();		
		}finally{
			JDBCUtil.close(rs, stmt, c);
		}
	}
}
