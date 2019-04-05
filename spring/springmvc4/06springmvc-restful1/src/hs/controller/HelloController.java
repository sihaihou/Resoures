package hs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hs.pojo.User;

@Controller
@RequestMapping("/user") //分模块开发----团队协作开发:注意页面跳转
public class HelloController {
	private List<User> list = new ArrayList<User>();
	public HelloController() {
		list.add(new User(1,"程飞扬","111111"));
		list.add(new User(2,"徐风","222222"));
		list.add(new User(3,"张三","333333"));
		list.add(new User(4,"李四","444444"));
		
	}
	@RequestMapping("/list")
	public String list(ModelMap model){
		model.addAttribute("list",list);
		//分模块开发----团队协作开发时：跳转页面前一定要加上  ‘'/'.
		return "/list.jsp";	
	}
	@RequestMapping("/add")
	public String add(User user){
		user.setId(list.get(list.size()-1).getId()+1);
		list.add(user);
		return "redirect:list.do";	
	}
	@RequestMapping("/delete")
	public String delete(int id){
		for(int i=0;i<list.size();i++){
			if(list.get(i).getId()==id){
				list.remove(i);
				break;
			}
		}
		return "redirect:list.do";	
	}
	
	/**
	 * restful风格：暂时有点问题。
	 * /{id}/remove:相当于 /user/12/remove
	 */
	
	@RequestMapping("/{id}/remove")
	public String delete1(@PathVariable("id") int id){
		System.out.println("id================"+id);
		for(int i=0;i<list.size();i++){
			if(list.get(i).getId()==id){
				list.remove(i);
				break;
			}
		}
		return "redirect:/user/list.do";	
	}
	
}
