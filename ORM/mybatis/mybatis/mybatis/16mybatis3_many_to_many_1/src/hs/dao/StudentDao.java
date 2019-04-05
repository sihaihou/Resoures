package hs.dao;

import hs.pojo.Student;
/**
 * 多对多关联查询
 * @author Administrator
 */
public interface StudentDao {
	
	public Student selectStudentById(int sid);
	
}
