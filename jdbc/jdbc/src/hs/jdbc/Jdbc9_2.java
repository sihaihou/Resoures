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
 * 测试CLOB的基本概念和用法
 * 		文本大对象的使用
 * 		从数据库读取指定方式的CLOB数据	
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
				reader=cb.getCharacterStream();  //从数据库读取指id的CLOB数据
				int temp=0;
				while(-1!=(temp=reader.read())){
					System.out.print((char)temp);  //将 int 类型转化成 char 类型
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
