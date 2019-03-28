package hs.action;

import com.opensymphony.xwork2.Action;
import com.sun.org.apache.regexp.internal.recompile;

public class LoginAction {
	private String name;
	private String  pwd;
	
	public String execute(){
		if("hsh".equals(name)&&"123456".equals(pwd)){
			return Action.LOGIN;			
		}
		return Action.ERROR;
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
