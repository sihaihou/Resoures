package hs.pojo;

public class User {
	private String name;
	private String pwd;
	public String getName() {
		return name;
	}
	
	public User(String name, String pwd) {
		super();
		this.name = name;
		this.pwd = pwd;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
