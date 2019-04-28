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
 * ��õ�һ��
 * 		����javabean��װһ������
 *  	 ʹ��List<javabean>�洢������¼
 * @author Administrator
 *
 */
public class Sorm3 {
	/**
	 * ����
	 * @param args
	 */
	public static void main(String[] args) {
		test02();
	}
	/**
	 * ʹ��javabean��װһ������
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
	 *  ʹ��List<javabean>�洢������¼
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
