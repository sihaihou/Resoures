package hs.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import hs.pojo.Grade;
import hs.pojo.School;
import hs.pojo.Student;
import hs.util.DB;

public class SchoolServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html,charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		String methodName = request.getParameter("method");
		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke( this, request,response);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	protected void schoolList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnection();
			String sql = "select * from school";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<School> schools = new ArrayList<School>();
			while(rs.next()) {
				School s = new School();
				s.setSchoolId(rs.getInt("schoolId"));
				s.setSchoolName(rs.getString("schoolName"));
				schools.add(s);
			}
			request.setAttribute("schools", schools);
			request.getRequestDispatcher("/WEB-INF/student.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void gradeList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String schoolId = request.getParameter("schoolId");
		System.err.println(schoolId);
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Grade> grades = new ArrayList<Grade>();
		try {
			conn = DB.getConnection();
			String sql = "select * from grade where school_id = ?";			
			ps = conn.prepareStatement(sql);
			ps.setObject(1, schoolId);
			rs = ps.executeQuery();			
			while(rs.next()) {
				Grade grade = new Grade();
				grade.setGradeId(rs.getInt("gradeId"));
				grade.setGradeName(rs.getString("gradeName"));
				grades.add(grade);
			}
			ObjectMapper mapper = new ObjectMapper();
			String result = mapper.writeValueAsString(grades);	
			response.getWriter().println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void studentList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gradelId = request.getParameter("gradeId");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> students = new ArrayList<Student>();
		try {
			conn = DB.getConnection();
			String sql = "select * from student where grade_id = ?";			
			ps = conn.prepareStatement(sql);
			ps.setObject(1, gradelId);
			rs = ps.executeQuery();			
			while(rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt("studentId"));
				student.setStudentName(rs.getString("studentName"));
				student.setStudentAge(rs.getInt("studentAge"));
				student.setStudentPhone(rs.getString("studentPhone"));
				students.add(student);
			}
			ObjectMapper mapper = new ObjectMapper();
			String result = mapper.writeValueAsString(students);	
			response.getWriter().println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void getStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId = request.getParameter("studentId");
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DB.getConnection();
			String sql = "select * from student where studentId = ?";			
			ps = conn.prepareStatement(sql);
			ps.setObject(1, studentId);
			rs = ps.executeQuery();	
			Student student = null;
			while(rs.next()) {
				student = new Student();
				student.setStudentId(rs.getInt("studentId"));
				student.setStudentName(rs.getString("studentName"));
				student.setStudentAge(rs.getInt("studentAge"));
				student.setStudentPhone(rs.getString("studentPhone"));
			}
			ObjectMapper mapper = new ObjectMapper();
			String result = mapper.writeValueAsString(student);
			response.getWriter().println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
