package hs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * ��������Ļ���������÷�
 * 			��ָ����ʽȡ�� ����
 * @author Administrator
 */
public class Jdbc8 {
	//��һ��ʱ���ַ����������ַ���ת���ɸ�ʽ��ʱ�����
	public static long getTime(String datestr){
		DateFormat df=new SimpleDateFormat("yy-MM-dd hh:mm:ss");
		try {
			 return df.parse(datestr).getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}		
	} 
	public static void main(String[] args) throws ClassNotFoundException {
		Connection c=null;
		PreparedStatement ps=null;
		ResultSet rs=null;		
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			c.setAutoCommit(false);  
			ps=c.prepareStatement("select* from t_user2 where date>? and date<? ");
			java.sql.Timestamp start=new java.sql.Timestamp(getTime("2016-3-28 23:59:59"));
			java.sql.Timestamp end=new java.sql.Timestamp(getTime("2016-6-1 23:59:59"));
			ps.setObject(1, start);
			ps.setObject(2, end);	
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getObject("id")+"\t"+rs.getObject("name")+"\t"+rs.getObject("pwd")+"\t"+rs.getObject("date"));
				c.commit();	 
			}	
		} catch (SQLException e) {
				e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, c);
		}
	}
}
