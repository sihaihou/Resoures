package com.hs.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 
 * @author Administrator
 *
 */
public class ForEachList extends SimpleTagSupport {
	private List<Object> items;
	private String var ;
	public void setItems(List<Object> items) {
		this.items = items;
	}
	public void setVar(String var) {
		this.var = var;
	}
	@Override
	public void doTag() throws JspException, IOException {
		for (Object obj : items) {
			this.getJspContext().setAttribute(var, obj);
			this.getJspBody().invoke(null);
		}
	}
}
