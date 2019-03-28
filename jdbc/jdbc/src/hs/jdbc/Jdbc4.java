package hs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 测试Result语句及基本用法！
 * @author Administrator
 */
public class Jdbc4 {
	public static void main(String[] args) throws ClassNotFoundException {
		Connection c=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");	
			String sql="select id,name,pwd,date from t_user where id>?";  //占位符
			ps=(PreparedStatement) c.prepareStatement(sql);
			//把id 大于2的记录都取出来
			ps.setObject(1, 2);  
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDate(4));
			}
		} catch (SQLException e) {
				e.printStackTrace();		
		}finally{
			//遵循ResultSet--->PreparedStatement-->Connection这样的关闭顺序，一定要将try catch块,分开写
			JDBCUtil.close(rs, ps, c);
		}
	}
}
