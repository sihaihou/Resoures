package hs.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction {
	private String name;
	private String pwd;
	public String execute(){		
		System.out.println("name----"+name);
		if("hsh".equals(name)&&"123456".equals(pwd)){	
			//∑≈»Îª∫¥Êuser
			ActionContext.getContext().getSession().put("user", name);
			return "success";
		}else{
			return "login";
		}					
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
