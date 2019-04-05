package hs.action;

import java.util.List;

import com.opensymphony.xwork2.Action;

import freemarker.core.ReturnInstruction.Return;
import hs.pojo.User;
import hs.service.UserService;

public class UserAction {
	private List<User> list;
	private UserService userService;
	
	public String list(){
		list = userService.getAll();
		for (User user : list) {
			System.out.println(user.getName());
		}
		return Action.SUCCESS;
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}	
}
