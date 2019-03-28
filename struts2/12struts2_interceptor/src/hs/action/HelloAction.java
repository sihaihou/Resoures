package hs.action;

import com.opensymphony.xwork2.Action;

public class HelloAction {	
	private String name;
	public String execute(){
		return Action.SUCCESS;
	}
	public String list(){
		System.out.println("list");
		return "success";
	}
	public String add(){
		System.out.println("add");
		return "success";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
