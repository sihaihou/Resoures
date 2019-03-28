package hs.mapping.bean;

public class Category {
	private int id;
	private String name;
	private String descr;
	private int pid;
	private boolean isleaf;
	private int grade;
	public Category() {
		
	}
	public Category(int id, String name, String descr, int pid, boolean isleaf, int grade) {
		super();
		this.id = id;
		this.name = name;
		this.descr = descr;
		this.pid = pid;
		this.isleaf = isleaf;
		this.grade = grade;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public boolean isIsleaf() {
		return isleaf;
	}
	public void setIsleaf(boolean isleaf) {
		this.isleaf = isleaf;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
