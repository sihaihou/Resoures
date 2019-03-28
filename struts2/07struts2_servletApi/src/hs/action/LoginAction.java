package hs.action;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
/**
 * 使用解耦的方法获取ServletAPI，通过  ActionContext对象获取。
 * @author Administrator
 *
 */
public class LoginAction {
	private String name;
	private String  pwd;	
	public String execute(){
		if("hsh".equals(name)&&"123456".equals(pwd)){
			System.out.println(name+"----"+pwd);
			//获取session
			ActionContext.getContext().getSession().put("user", name);
			//获取 request   HttpServletRequest对象的attribute。
			Map<String,Object> requset = (Map)ActionContext.getContext().get("request");
			//获取 application
			Map<String,Object> application = ActionContext.getContext().getApplication();
			//获取 parameters
			Map<String ,Object> parameters = ActionContext.getContext().getParameters();
			//相当于request.parameters("name");
			System.out.println("name===="+((String[])parameters.get("name"))[0]);

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
