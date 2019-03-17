package hs.service.impl;

import java.util.List;

import hs.dao.CourseDao;
import hs.dao.impl.CourseDaoImpl;
import hs.pojo.Course;
import hs.service.CourseService;

public class CourseServicImpl implements CourseService{
	private CourseDao courseDao;
	
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}
	
	@Override
	public List<Course> getCourse() {
		List<Course> course = courseDao.getCourse();
		return course;
	}
}
