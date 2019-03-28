package hs.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hs.vo.User;

@Controller
public class JsonController {
	@RequestMapping("/json")
	@ResponseBody
	public List<User> json(){
		List<User> list = new ArrayList<User>();
		list.add(new User(1,"zhansan",22));
		list.add(new User(2,"wangwu",21));
		list.add(new User(3,"zhaosi",33));
		list.add(new User(4,"wangdana",14));
		return list;
	}
}
