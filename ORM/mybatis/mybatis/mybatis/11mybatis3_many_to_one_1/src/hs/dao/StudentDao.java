package hs.dao;

import hs.pojo.Student;
/**
 *   ���һ��
 * @author Administrator
 *
 */
public interface StudentDao {
	
	public Student selectStudentById(int sid);
	
}
