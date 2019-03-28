package hs.jdbc;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
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
 * 测试CLOB的基本概念和用法
 * 		文本大对象的使用
 * 		将文本文件、程序中的字符串输入到数据库中
 * @author Administrator
 */
public class Jdbc9_1 {

	public static void main(String[] args) throws IOException, ClassNotFoundException { 
		Connection c=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			ps=c.prepareStatement("insert into t_user (name,info) values(?,?)");
			ps.setString(1,"高淇");
			/**
			 * 将文本文件内容直接输入到数据库中
			 */
			//ps.setClob(2,new FileReader(new File("E:/test/jdbc/a.txt"))) ;
			/**
			 * 将程序中的字符串直接输入到数据库中
			 */
			ps.setClob(2,new BufferedReader(new InputStreamReader(new ByteArrayInputStream("good!".getBytes()))));
			ps.execute();
		} catch (SQLException e) {
				e.printStackTrace();
		} finally{
			JDBCUtil.close(rs, ps, c);
		}
	}
}
