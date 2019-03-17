package com.reyco.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.reyco.core.pojo.Account;
import com.reyco.core.service.AccountService;
import com.reyco.core.util.JSONResult;

@Controller("accountController")
public class AccountController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private AccountService accountService;
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	@RequestMapping("/index")
	public ModelAndView index(HttpSession session) {
		Subject subject = SecurityUtils.getSubject();
		Account account = (Account)subject.getPrincipal();
		session.setAttribute("crruentUser", account.getUsername());
		return new ModelAndView("login");
	}
	/**
	 * 访问toLogin,然后访问login
	 * @return
	 */
	@RequestMapping(value= {"/","/toLogin"})
	public ModelAndView toLogin() {
		System.out.println("---toLogin---");
		return new ModelAndView("login");
	}
	/**
	 *   登录，验证不成功，则跳转到login.jsp页面;验证成功则跳转到配置的页面
	 * @param req
	 * @return
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req){
		System.out.println("---login---");
		ModelAndView mv = new ModelAndView("login.jsp");
		String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
		String error = "用户名/密码错误";
		if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
			mv.addObject("msg", error);
		} else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)){
			mv.addObject("msg", error);
		} else {
			mv.addObject("msg", exceptionClassName);
		}
		return mv;
	}
	/**
	 * 访问refuse,然后访问refuse.jsp
	 * @return
	 */
	@RequestMapping("/refuse")
	public ModelAndView refuse() {
		System.out.println("---refuse---");
		return new ModelAndView("refuse.jsp");
	}
	
	@ResponseBody
	@RequestMapping("/role/list")
	@RequiresPermissions("role:list")
	public String list() {
		return JSONResult.create("role:list").toJSON();
	}
	@ResponseBody
	@RequestMapping("/role/delete")
	@RequiresPermissions("role:delete")
	public String delete() {
		return JSONResult.create("role:delete").toJSON();
	}
	@ResponseBody
	@RequestMapping("/role/update")
	@RequiresPermissions("role:update")
	public String update() {
		return JSONResult.create("role:update").toJSON();
	}
	@ResponseBody
	@RequestMapping("/role/add")
	@RequiresPermissions("role:add")
	public String add() {
		return JSONResult.create("role:add").toJSON();
	}
}
