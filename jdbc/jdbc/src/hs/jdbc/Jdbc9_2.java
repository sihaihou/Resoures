package hs.jdbc;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * ����CLOB�Ļ���������÷�
 * 		�ı�������ʹ��
 * 		�����ݿ��ȡָ����ʽ��CLOB����	
 * @author Administrator
 */
public class Jdbc9_2 {
	public static void main(String[] args) throws IOException { 
		Connection c=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		Reader reader=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			ps=c.prepareStatement("select *from t_user where id=?");
			ps.setObject(1,244);
			rs=ps.executeQuery();
			while(rs.next()){
				Clob cb=rs.getClob("info");
				reader=cb.getCharacterStream();  //�����ݿ��ȡָid��CLOB����
				int temp=0;
				while(-1!=(temp=reader.read())){
					System.out.print((char)temp);  //�� int ����ת���� char ����
				}
			}				
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(null!=reader){
				reader.close();
			}
			JDBCUtil.close(rs, ps, c);
		}
	}
}
