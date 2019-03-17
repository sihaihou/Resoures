package hs.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import hs.dao.CourseDao;
import hs.pojo.Course;
import hs.util.JDBC;

public class CourseDaoImpl implements CourseDao{
	@Override
	public List<Course> getCourse() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Course> Courses = null;
		try {
			conn = JDBC.getConnection();
			String sql = "select * from course";
			ps = (PreparedStatement) conn.prepareStatement(sql);
			rs = ps.executeQuery();
		    Courses = new ArrayList<Course>();
			while(rs.next()) {
				Course course = new Course();
				course.setId(rs.getInt("id"));
				course.setName(rs.getString("name"));
				Courses.add(course);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBC.close(rs, ps, conn);
		}
		return Courses;
	}
}
