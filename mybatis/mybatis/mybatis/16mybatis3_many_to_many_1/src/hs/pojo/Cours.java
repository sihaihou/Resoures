package hs.pojo;

import java.util.Set;
/**
 * 多对多关联查
 * @author Administrator
 */
public class Cours {
	private int cid;
	private String cname;
	private Set<Cours> courses;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Set<Cours> getCourses() {
		return courses;
	}
	public void setCourses(Set<Cours> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Cours [cid=" + cid + ", cname=" + cname + ", courses=" + courses + "]";
	}
}
