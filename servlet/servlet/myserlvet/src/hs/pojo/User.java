package hs.pojo;

public class User {
	private int id ;
	private String name;
	private String pwd;
	public User() {
		// TODO Auto-generated constructor stub
	}	
	public User( String name, String pwd) {
		super();		
		this.name = name;
		this.pwd = pwd;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
