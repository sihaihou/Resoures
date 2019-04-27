package hs.pojo;

import java.util.Set;
/**
 * 多对多关联查询
 * @author Administrator
 *
 */
public class Student {
	private int sid;
	private String sname;
	private Set<Cours> courses;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}	
	public Set<Cours> getCourses() {
		return courses;
	}
	public void setCourses(Set<Cours> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", courses=" + courses + "]";
	}	
}
