package hs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * ²âÊÔJDBCUtil¹¤¾ß°ü
 * @author Administrator
 */
public class Jdbc9_5 {
	public static void main(String[] args)   {
		Connection c=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			c=JDBCUtil.getMysqlConn();
			String sql="select id,name,pwd,date from t_user where id>?"; 
			ps=(PreparedStatement) c.prepareStatement(sql);
			ps.setObject(1, 2);  
			rs=ps.executeQuery();
			while(rs.next()){			
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDate(4));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, ps, c);
		}
	}
}
