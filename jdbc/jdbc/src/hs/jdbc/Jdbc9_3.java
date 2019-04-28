package hs.jdbc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * ����BLOB�Ļ���������÷�
 * 		Blob������ʹ��
 * 		��ͼƬ�ļ��������е��ַ������뵽���ݿ���
 * @author Administrator
 */
public class Jdbc9_3 {

	public static void main(String[] args) throws IOException, ClassNotFoundException { 
		Connection c=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			ps=c.prepareStatement("insert into t_user (name,img) values(?,?)");
			ps.setString(1,"���");
			/**
			 * ��ͼƬ�ļ�����ֱ�����뵽���ݿ���
			 */
			ps.setBlob(2, new FileInputStream("E:/test/jdbc/1.jpg"));
			ps.execute();
		} catch (SQLException e) {
				e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, c);
		}
	}
}
