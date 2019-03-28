package hs.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;

public class AjaxAction {
	public String execute() throws IOException{
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		
		PrintWriter out=resp.getWriter();
		out.println("struts ajax!");
		return null;
	}
}
