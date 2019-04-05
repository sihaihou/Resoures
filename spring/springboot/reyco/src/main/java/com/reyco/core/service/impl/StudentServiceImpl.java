package com.reyco.core.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reyco.core.dao.StudentDao;
import com.reyco.core.domain.Student;
import com.reyco.core.service.StudentService;

@Service("studentService")
public class StudentServiceImpl extends StudentService<Student>{
	
	@Autowired
	private StudentDao<Student> studentDao;
	
	@Override
	public Student login(String no) {
		return studentDao.login(no);
	}
	
	@Override
	public List<Student> searchPage(Student stu) {
		return studentDao.searchPage(stu);
	}

	@Override
	public List<Student> searchList(Student t) {
		return studentDao.searchList(t);
	}

	@Override
	public void insert(Student t) {
		
	}

	@Override
	public Student searchById(Integer id) {
		return null;
	}

	@Override
	public void updateById(Student t) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public void deleteByList(List<Integer> list) {
		
	}

	

}
