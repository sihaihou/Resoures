package hs.sorm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 最常用的一种
 * 		测试javabean封装一条数据
 *  	 使用List<javabean>存储多条记录
 * @author Administrator
 *
 */
public class Sorm3 {
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		test02();
	}
	/**
	 * 使用javabean封装一条数据
	 */
	public static void test01(){
		Connection c=JDBCUtil.getMysqlConn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Emp emp=null;
		try {
			ps=c.prepareStatement("select name,salary,birthday,age from emp where id=?");
			ps.setObject(1, 1);
			rs=ps.executeQuery();
			while(rs.next()){
				emp=new Emp(rs.getString(1),rs.getInt(2),rs.getDate(3),rs.getInt(4));		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, c);
		}	
		System.out.println(emp.getName()+emp.getSalary()+emp.getBirthday()+emp.getAge());
	}
	/**
	 *  使用List<javabean>存储多条记录
	 */
	public static void test02(){
		Connection c=JDBCUtil.getMysqlConn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Emp> list=new ArrayList<Emp>();
		try {
			ps=c.prepareStatement("select name,salary,birthday,age from emp where id>=?");
			ps.setObject(1, 1);			
			rs=ps.executeQuery();
			while(rs.next()){			
				Emp emp=new Emp(rs.getString(1),rs.getInt(2),rs.getDate(3),rs.getInt(4));	
				list.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, c);
		}	
		for(Emp emp:list){
			System.out.println(emp.getName()+"-->"+emp.getSalary()+"-->"+emp.getBirthday()+"-->"+emp.getAge());
		}
	} 	
}
