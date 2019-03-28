package hs.action;

import com.opensymphony.xwork2.Action;
/**
 * 实现Action的第一种方式
 * @author Administrator
 */
public class HelloAction {
	public String execute(){
		System.out.println("实现Action的第一种方式");
		return "success";
	}
}
