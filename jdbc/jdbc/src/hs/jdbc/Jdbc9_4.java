package hs.jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**测试BLOB的基本概念和用法
 * 		Blob大对象的使用
 * 		从数据库读取指定的Blob文件并输出到指定文件中。	
 * @author Administrator
 */
public class Jdbc9_4 {
	public static void main(String[] args) throws IOException { 
		Connection c=null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		InputStream is =null;
		OutputStream os =null;
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456");
			ps=c.prepareStatement("select *from t_user where id=?");
			ps.setObject(1,247);
			rs=ps.executeQuery();
			while(rs.next()){
				Blob b= rs.getBlob("img");
				is=b.getBinaryStream();  
				os= new FileOutputStream("E:/test/jdbc/2.jpg");
				int temp=0;
				while(-1!=(temp=is.read())){
					os.write(temp);
				}
			}				
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(null!=is){
				is.close();
			}
			if(null!=os){
				os.close();
			}
			JDBCUtil.close(rs, ps, c);
		}
	}
}
