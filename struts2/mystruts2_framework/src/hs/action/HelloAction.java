package hs.action;

public class HelloAction {
	private String name;
	private String pwd;
	public String execute(){		
		System.out.println(name+"----"+pwd);
		return "success";
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
