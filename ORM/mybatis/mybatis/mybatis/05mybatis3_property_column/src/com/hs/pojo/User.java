package com.hs.pojo;

public class User {
	private int tid;
	private String tname;
	private int tage;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String tname, int tage) {
		super();
		this.tname = tname;
		this.tage = tage;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getTage() {
		return tage;
	}
	public void setTage(int tage) {
		this.tage = tage;
	}
	@Override
	public String toString() {
		return "User [tid=" + tid + ", tname=" + tname + ", tage=" + tage + "]";
	}
}
