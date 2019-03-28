package hs.action;

import com.opensymphony.xwork2.Action;

public class HelloAction {	
	private String name;
	public String execute(){
		System.out.println("name:"+name);
		return Action.SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
