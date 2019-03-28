package hs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * ��������Ļ���������÷�
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
			System.out.println("����һ���û���zhangsan");
			ps1.execute();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			ps2=c.prepareStatement("insert into t_user (name,pwd) values(?,?)");
			ps2.setObject(1, "����");
			ps2.setObject(2, "123456");
			ps2.execute();
			System.out.println("����һ���û�������");
			c.commit();	          
		} catch (SQLException e) {
				e.printStackTrace();
				try {
					// �ع�����һ��sql���,��һ��sqlִ�����ʧ�ܣ�����sql���ͬʱʧ�ܣ�				 
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
