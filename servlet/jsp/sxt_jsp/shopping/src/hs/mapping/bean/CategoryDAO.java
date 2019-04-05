package hs.mapping.bean;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import hs.db.util.DB;

public class CategoryDAO {
	public static void save(Category c){
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = DB.getConnection();
			String sql = "insert into category values (?,?,?,?,?,?)";
		    ps = DB.getPs(conn, sql);
		    ps.setInt(1, c.getId());
		    ps.setString(2, c.getName());
		    ps.setString(3, c.getDescr());
		    ps.setInt(4, c.getPid());
		    ps.setInt(5, c.isIsleaf() ? 0 : 1);
		    ps.setInt(6, c.getGrade());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DB.close( ps, conn);
		}
	}
}
