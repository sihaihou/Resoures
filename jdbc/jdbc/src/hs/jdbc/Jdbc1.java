package hs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc1 {
	public static void main(String[] args) {
		Connection c=null;
		try {
			//加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			long start=System.currentTimeMillis();
			//建立连接(连接对象内部其实包含了一个socket对象，是一个远程的连接，比较耗时，这是Connection管理的一个要点)
			//真正开发中，为了提高效率，都会采用连接池来管理连接对象
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			long end=System.currentTimeMillis();
			System.out.println(c);
			System.out.println("建立连接耗时:"+(end-start)+"毫秒");
		} catch (SQLException e) {
				e.printStackTrace();		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			/*try {
				if(c!=null){
				c.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
			JDBCUtil.close(c);
		}
	}
}
