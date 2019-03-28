package hs.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
@ParentPackage(value="struts-default")
@Namespace("/")
public class AnnotationAction extends ActionSupport{
	@Action(value="/hello",results={@Result(name="success",location="/index.jsp")})
	public String execute(){
		System.out.println("hello action ");
		return "success";
	}
}
