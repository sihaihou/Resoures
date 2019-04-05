package hs.po;

/**
 * @author Administrator
 *
 */
public class User {
	
	private String name;
	private String pwd;
	public User() {
		
	}
	
	public User(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
	}
	
	public String getName() {
		return name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
