package hs.mapping.bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import hs.db.util.DB;

public class User {
	private int id;
	private String username;
	private String password;
	private String phone;
	private String addr;
	private Date rdate;
	public User() {
	}
	
	public User(String username, String password, String phone, String addr) {
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.addr = addr;
		this.rdate=new Timestamp(System.currentTimeMillis());
	}

	public User(int id, String username, String password, String phone, String addr, Timestamp rdate) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.addr = addr;
		this.rdate = rdate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public Date getRdate() {
		return rdate;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public void save(){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DB.getConnection();
			String sql = "insert into user values (null,?,?,?,?,?)";
		    ps = DB.getPs(conn, sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3,phone );
			ps.setString(4, addr);
			ps.setTimestamp(5,new Timestamp(rdate.getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DB.close( ps, conn);
		}
	}
	public static User validate(String username,String password) throws UserNOTFoundException, PasswordNOTCorrectException {
		Connection conn=null;
		ResultSet rs =null;
		User u= null;
		try {	
			conn = DB.getConnection();
			String sql="select * from user where username ='"+username+"'";			
			rs=DB.getRs(conn, sql);
			if(!rs.next()){
				throw new UserNOTFoundException();
			}else if(!rs.getString("password").equals(password)){
				throw new PasswordNOTCorrectException();
			}else{
				u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setPhone(rs.getString("phone"));
				u.setAddr(rs.getString("addr"));
				u.setRdate(rs.getTimestamp("rdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DB.close(rs, conn);
		}
		return u;
	}
	public void update(){
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn =DB.getConnection();
			String sql = "Update user set username=?,phone=?,addr=? where id="+this.id;
			ps =DB.getPs(conn, sql);
			ps.setString(1, username);
			ps.setString(2, phone);
			ps.setString(3,addr );
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DB.close(ps, conn);
		}
	} 
}
