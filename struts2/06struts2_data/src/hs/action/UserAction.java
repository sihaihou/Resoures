package hs.action;

import com.opensymphony.xwork2.Action;

import hs.pojo.User;

/**
 *   ÊôĞÔÇı¶¯
 * @author Administrator
 */
public class UserAction {
	private User user;
	public String execute(){
		System.out.println(user);
		return "register";			
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}		
}
