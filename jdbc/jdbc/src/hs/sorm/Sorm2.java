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
 * ����Map��װһ������
 *   ʹ��List<Map>�洢������¼
 *   ʹ��Map<Map>�洢������¼
 * @author Administrator
 *
 */
public class Sorm2 {
	public static void main(String[] args) {
		test03();
	}
	/**
	 * һ��Map��װһ������
	 */
	public static void test01(){
		Connection c=JDBCUtil.getMysqlConn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		/**
		 * һ��Map��װһ������
		 */
		Map<String, Object> map =new HashMap<String,Object>();
		try {
			ps=c.prepareStatement("select name,salary,birthday,age from emp where id=?");
			ps.setObject(1, 1);
			rs=ps.executeQuery();
			while(rs.next()){
				map.put("name", rs.getObject(1));
				map.put("salary", rs.getObject(2));
				map.put("birthday", rs.getObject(3));
				map.put("age", rs.getObject(4));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, c);
		}	
		for(String key:map.keySet()){
			System.out.print(key+"---"+map.get(key)+"\t");
			}
		}
	/**
	 * һ��Map��װһ�����ݣ����Ž�List������
	 */
	public static void test02(){
		Connection c=JDBCUtil.getMysqlConn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Map<String, Object>> list =new ArrayList<Map<String,Object>>();
		try {
			ps=c.prepareStatement("select name,salary,birthday,age from emp where id>=?");
			ps.setInt(1, 1);
			rs=ps.executeQuery();		
			while(rs.next()){
				//һ��Map��װһ������
				Map<String, Object> map=new HashMap<String,Object>();
				map.put("name", rs.getObject(1));
				map.put("salary", rs.getObject(2));
				map.put("birthday", rs.getObject(3));
				map.put("age", rs.getObject(4));	
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, c);
		}
		for(Map<String,Object> map:list){
			for(String key:map.keySet()){
				System.out.print(key+"----"+map.get(key)+"\t");
			}
			System.out.println();
		}
	} 
	
	
	public static void test03(){
		Connection c=JDBCUtil.getMysqlConn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Map<String,Map<String, Object>> map =new HashMap<String,Map<String, Object>>();
		try {
			ps=c.prepareStatement("select name,salary,birthday,age from emp where id>=?");
			ps.setObject(1, 1);
			rs=ps.executeQuery();
			while(rs.next()){
				/**
				 * һ��Map��װһ������
				 */
				Map<String, Object> mp=new HashMap<String,Object>();
				mp.put("name", rs.getObject(1));
				mp.put("salary", rs.getObject(2));
				mp.put("birthday", rs.getObject(3));
				mp.put("age", rs.getObject(4));	
				map.put(rs.getString(1), mp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.close(rs, ps, c);
		}
		for(String name:map.keySet()){
			Map<String,Object> mp=map.get(name);
			for(String key:mp.keySet()){
				System.out.print(key+"--"+mp.get(key)+"\t");
			}
			System.out.println();
		}
	} 
}
