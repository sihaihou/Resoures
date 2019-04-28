package hs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.CallableStatement;
/**
 * ����PreparedStatement��估�����÷���
 * @author Administrator
 */
public class Jdbc3_2 {
	public static void main(String[] args) throws ClassNotFoundException {
		Connection c=null;
		PreparedStatement ps=null;
		CallableStatement cstat=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			String sql="insert into t_user (name,pwd,date) values (?,?,?)";
			//PrepareStatement ��  CallableStatement �÷�һ��
			//ps=(PreparedStatement) c.prepareStatement(sql);	
		    cstat=(CallableStatement) c.prepareCall(sql);
//			cstat.setString(1, "����");
//			cstat.setString(2, "123");
//			cstat.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			
		    cstat.setObject(1, "����");
		    cstat.setObject(2, "123456");
		    cstat.setObject(3, new Date());
			System.out.println("=====================");
			cstat.execute();
		} catch (SQLException e) {
				e.printStackTrace();		
		}finally{
			JDBCUtil.close(cstat, c);
		}
	}
}
