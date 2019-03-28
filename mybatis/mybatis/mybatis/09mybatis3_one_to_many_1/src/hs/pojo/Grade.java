package hs.pojo;

import java.util.Set;
/**
 * 一对多：
 * 		一
 * @author Administrator
 *
 */
public class Grade {
	private int gid;
	private String gname;
	private Set<Student> Students;
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Set<Student> getStudents() {
		return Students;
	}
	public void setStudents(Set<Student> students) {
		Students = students;
	}
	@Override
	public String toString() {
		return "Grade [gid=" + gid + ", gname=" + gname + ", Students=" + Students + "]";
	}
	
}
