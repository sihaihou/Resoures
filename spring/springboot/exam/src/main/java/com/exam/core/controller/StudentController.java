package com.exam.core.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.core.Contants.Status;
import com.exam.core.domain.Student;
import com.exam.core.service.StudentService;
import com.exam.core.util.JSONResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RequestMapping("/student")
@RestController
public class StudentController {
	@Autowired
	private StudentService<Student> studentService;
	
	@RequestMapping("/login")
	public String login(String no,String password,HttpServletRequest request) {
		if(null == no) {
			return JSONResult.failCreate("登录失败,用户名不能为空", JSONResult.ERROR_PARAMS).toJSON();
		}
		if(null == password) {
			return JSONResult.failCreate("登录失败,密码不能为空", JSONResult.ERROR_PARAMS).toJSON();
		}
		HttpSession session = request.getSession();
		String logObj = (String) session.getAttribute("user");
		if(!StringUtils.isBlank(logObj)) {
			return JSONResult.failCreate("登录失败,您已登录，请先退出...", "用户已登录...").toJSON();
		}
		Student student = studentService.login(no);
		if(null == student) {
			return JSONResult.failCreate("登录失败,该用户不存在", JSONResult.ERROR_SELECT).toJSON();
		}
		if(!password.equals(student.getPassword())) {
			return JSONResult.failCreate("登录失败,密码错误", "密码错误").toJSON();
		}
		if(!student.getStatus().equals(0)) {
			return JSONResult.failCreate("登录失败,该账号异常", "该账号异常").toJSON();
		}
		student.setPassword("");
		session.setAttribute("user", student.getNo());
		return JSONResult.create(student).toJSON();
	}
	/**
	 * 登出
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		Object user = session.getAttribute("user");
		if(user == null) {
			return JSONResult.failCreate("未登录", "未登录").toJSON();
		}
		session.invalidate();
		return JSONResult.create("退出成功").toJSON();
	}
	/**
	 * 验证登录
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checkUser")
	public String checkUser(HttpSession session) {
		Object user = session.getAttribute("user");
		if(null == user) {
			return JSONResult.failCreate("未登录", "没有session").toJSON();
		}
		return JSONResult.create(user).toJSON();
	}
	
	
	
	
	@RequestMapping("/searchPage")
	public String searchPage(Integer pageNo,@Value("${com.exam.core.util.pageSize}")Integer pageSize) {
		if(null == pageNo) {
			return JSONResult.failCreate("查询失败", JSONResult.ERROR_PARAMS).toJSON();
		}
		PageHelper.startPage(pageNo,pageSize);
		List<Student> list = studentService.searchPage(null);
		PageInfo<Student> pageInfo = new PageInfo<>(list);
		return JSONResult.create(pageInfo).toJSON();
	}
	@RequestMapping("/insert")
	public String insert(String name,String password,Integer gender,Integer age,String address,Integer gradeId,Integer professionalId,Integer facultyId,Integer schoolId) {
		if(null == gradeId) {
			return JSONResult.failCreate("新增失败", JSONResult.ERROR_PARAMS).toJSON();
		}
		if(null == professionalId) {
			return JSONResult.failCreate("新增失败", JSONResult.ERROR_PARAMS).toJSON();
		}
		if(null == facultyId) {
			return JSONResult.failCreate("新增失败", JSONResult.ERROR_PARAMS).toJSON();
		}
		if(null == schoolId) {
			return JSONResult.failCreate("新增失败", JSONResult.ERROR_PARAMS).toJSON();
		}
		Student student = new Student();
		student.setName(name);
		student.setPassword(password);
		student.setGender(gender);
		student.setAge(age);
		student.setAddress(address);
		student.setStatus(Status.NORMAL);
		student.setGradeId(gradeId);
		student.setProfessionalId(professionalId);
		student.setFacultyId(facultyId);
		student.setSchoolId(schoolId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date date = new Date();        
		String year = sdf.format(date);
		year = year.substring(2);
		String no=year+schoolId+facultyId+professionalId+gradeId+"11";
		student.setNo(no);
		studentService.insert(student);
		return JSONResult.create(JSONResult.INSERT_SUCCESS).toJSON();
	}
}
