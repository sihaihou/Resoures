package com.hs.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;

import com.hs.pojo.User;
import com.hs.service.UserService;
import com.opensymphony.xwork2.Action;

@Controller("userAction")//相当于spring配置里的一个bean
@Scope("prototype")
public class UserAction {
	private List<User> list;
	@Autowired
	private UserService userService;
	public String list(){
		list = userService.getAll();
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
