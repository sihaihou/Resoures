package hs.action;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
/**
 * 通过获取ServletActionContext 获取httpServletRequest对象。
 * @author Administrator
 *
 */
public class LoginAction3 {
	private String name;
	private String  pwd;
	public String execute(){
		if("hsh".equals(name)&&"123456".equals(pwd)){
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("user",name);
			System.out.println("name---?---"+request.getParameter("name"));
			return Action.LOGIN;			
		}
		return Action.ERROR;
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
