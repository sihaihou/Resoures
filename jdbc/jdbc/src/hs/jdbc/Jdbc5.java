package hs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * ����������
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
			 //��Ϊ�ֶ��ύ����  ----Ĭ��Ϊ�Զ��ύ
			c.setAutoCommit(false);  
			long start=System.currentTimeMillis();
			stmt=c.createStatement();
			for(int i=1;i<200;i++){
				stmt.addBatch("insert into t_user2 (name,pwd,date) values ('"+i+"',123456,now())");
			}
			stmt.executeBatch();
			//�ύ����
			c.commit();			
			long end=System.currentTimeMillis();
			System.out.println("����200�����ݺ�ʱ�����룩:"+(end-start));
		} catch (SQLException e) {
				e.printStackTrace();		
		}finally{
			JDBCUtil.close(rs, stmt, c);
		}
	}
}
