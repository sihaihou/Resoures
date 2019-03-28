package hs.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
/**
 * 通过耦合的方法获取httpServletRequest。  实现ServletRequestAware
 * @author Administrator
 *
 */
public class LoginAction2 implements ServletRequestAware{
	private String name;
	private String  pwd;
	HttpServletRequest request;
	public String execute(){
		if("hsh".equals(name)&&"123456".equals(pwd)){
			request.getSession().setAttribute("user",name);
			System.out.println("name------"+request.getParameter("name"));
			return Action.LOGIN;			
		}
		return Action.ERROR;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
