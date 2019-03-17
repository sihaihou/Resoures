package hs.impl;

import java.util.List;

import hs.dao.impl.CourseDaoImpl;
import hs.pojo.Course;
import hs.service.impl.CourseServicImpl;

public class CourseImpl {
	public static List getCourse() {
		CourseServicImpl courseServicImpl = new CourseServicImpl();
		courseServicImpl.setCourseDao(new CourseDaoImpl());	
		List<Course> courses = courseServicImpl.getCourse();
		return courses;
	}
}
