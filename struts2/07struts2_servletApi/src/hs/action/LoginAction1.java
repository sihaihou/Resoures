package hs.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
/**
 * 解耦:通过ActionContext直接获取HttpServletRequest.
 * @author Administrator
 *
 */
public class LoginAction1 {
	private String name;
	private String  pwd;	
	public String execute(){
		if("hsh".equals(name)&&"123456".equals(pwd)){
			HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(StrutsStatics.HTTP_REQUEST);
			request.getSession().setAttribute("user",name);
			System.out.println("name======"+request.getParameter("name"));
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
