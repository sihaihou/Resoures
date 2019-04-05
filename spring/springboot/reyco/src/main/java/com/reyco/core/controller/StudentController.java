package com.reyco.core.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reyco.core.domain.Student;
import com.reyco.core.service.StudentService;
import com.reyco.core.util.JSONResult;

@RequestMapping("/student")
@RestController
public class StudentController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private StudentService<Student> studentService;
	@RequestMapping("/login")
	public String login(String no,String password) {
		if(null == no) {
			logger.info("##################请求参数错误-------------no===="+no);
			return JSONResult.failCreate("登录失败,用户名不能为空", JSONResult.ERROR_PARAMS).toJSON();
		}
		if(null == password) {
			logger.info("##################请求参数错误-------------password===="+password);
			return JSONResult.failCreate("登录失败,密码不能为空", JSONResult.ERROR_PARAMS).toJSON();
		}
		Student student = studentService.login(no);
		if(null == student) {
			logger.info("##################暂无数据-------------student===="+student);
			return JSONResult.failCreate("登录失败,该用户不存在", JSONResult.ERROR_SELECT).toJSON();
		}
		if(!password.equals(student.getPassword())) {
			logger.info("##################密码错误-------------student===="+student);
			return JSONResult.failCreate("登录失败,密码错误", "密码错误").toJSON();
		}
		if(!student.getStatus().equals(0)) {
			logger.info("##################该账号异常-------------student===="+student);
			return JSONResult.failCreate("登录失败,该账号异常", "该账号异常").toJSON();
		}
		return JSONResult.create(student).toJSON();
	}
	
	@RequestMapping("/searchPage")
	public String searchPage(Integer pageNo,Integer pageSize) {
		if(null == pageNo) {
			logger.info("##################请求参数错误-------------pageNo===="+pageNo);
			return JSONResult.failCreate("查询失败", JSONResult.ERROR_PARAMS).toJSON();
		}
		if(null == pageSize) {
			logger.info("##################请求参数错误-------------pageSize===="+pageSize);
			return JSONResult.failCreate("查询失败", JSONResult.ERROR_PARAMS).toJSON();
		}
		PageHelper.startPage(pageNo,pageSize);
		List<Student> list = studentService.searchPage(null);
		if(null == list || list.size()<1) {
			logger.info("##################暂无数据-------------list===="+list);
		}
		PageInfo<Student> pageInfo = new PageInfo<>(list);
		return JSONResult.create(pageInfo).toJSON();
	}
	
}
