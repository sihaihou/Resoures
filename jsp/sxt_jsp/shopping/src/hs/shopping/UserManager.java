package hs.shopping;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import hs.db.util.DB;
import hs.mapping.bean.User;

public class UserManager {
	/**
	 * 查询所有用户
	 * @return
	 */
	public static List<User> getUsers(){
		List<User> list =new ArrayList<User>();
		Connection conn=null;
		ResultSet rs=null;
		try {
			conn=DB.getConnection();
			String sql="select *from user";
			rs=DB.getRs(conn, sql);
			while(rs.next()){
				User user =new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setPhone(rs.getString("phone"));
				user.setAddr(rs.getString("addr"));
				user.setRdate(rs.getTimestamp("rdate"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DB.close(rs, conn);
		}
		return list;
	}
	/**
	 * 删除用户
	 * @param id
	 */
	public static void deleteUser(int id){
		Connection conn= null;
		Statement stat= null;
		try {
			conn=DB.getConnection();
			stat=DB.getStamt(conn);
			stat.executeUpdate("delete from user where id ="+id);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DB.close(stat, conn);
		}
		
	}
	
	
	
}
