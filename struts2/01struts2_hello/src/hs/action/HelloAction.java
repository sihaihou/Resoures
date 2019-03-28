package hs.action;

import com.opensymphony.xwork2.Action;

public class HelloAction {
	public String execute(){
		System.out.println("hello struts2");
		return Action.SUCCESS;
	}
}
