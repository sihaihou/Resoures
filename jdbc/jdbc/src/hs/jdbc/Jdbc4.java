package hs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * ����Result��估�����÷���
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
			String sql="select id,name,pwd,date from t_user where id>?";  //ռλ��
			ps=(PreparedStatement) c.prepareStatement(sql);
			//��id ����2�ļ�¼��ȡ����
			ps.setObject(1, 2);  
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getDate(4));
			}
		} catch (SQLException e) {
				e.printStackTrace();		
		}finally{
			//��ѭResultSet--->PreparedStatement-->Connection�����Ĺر�˳��һ��Ҫ��try catch��,�ֿ�д
			JDBCUtil.close(rs, ps, c);
		}
	}
}
