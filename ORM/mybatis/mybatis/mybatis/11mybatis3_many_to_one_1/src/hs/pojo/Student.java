package hs.pojo;
/**
 * 一对多：
 * 		多
 * @author Administrator
 */
public class Student {
	private int sid;
	private String sname;
	private int sage;
	private Grade Grade;
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
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public Grade getGrade() {
		return Grade;
	}
	public void setGrade(Grade grade) {
		Grade = grade;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", Grade=" + Grade + "]";
	}
}
