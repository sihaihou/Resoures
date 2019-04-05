package com.hs.tag;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * forEach
 * @author Administrator
 *
 */
public class ForEachTag extends SimpleTagSupport {
	private Object items;
	private String var;
	public void setItems(Object items) {
		this.items = items;
	}
	public void setVar(String var) {
		this.var = var;
	}
	private Collection getCollection() {
		if(items instanceof List ) {
			return (List)items;
		}else if(items instanceof Set) {
			return (Set)items;
		}else if(items instanceof Map) {
			return ((Map)items).entrySet();
		}else if(items instanceof Object[]) {
			return Arrays.asList((Object[])items);
		}else if(items instanceof int[]) {
			List list = new ArrayList();
			for (int num : (int[])items) {
				list.add(num);
			}
			return list;
		}
		return null;
	}
	@Override
	public void doTag() throws JspException, IOException {
		for (Object obj : getCollection()) {
			this.getJspContext().setAttribute(var, obj);
			this.getJspBody().invoke(null);
		}
		/*if(items instanceof List) {
			List itemsList = (List)items;
			for (Object obj : itemsList) {
				this.getJspContext().setAttribute(var, obj);
				this.getJspBody().invoke(null);
			}
		}else if (items instanceof Set) {
			System.err.println("====set====");
			Set itemsSet = (Set)items;
			for (Object obj : itemsSet) {
				this.getJspContext().setAttribute(var, obj);
				this.getJspBody().invoke(null);
			}
		}else if (items instanceof Map) {
			Map itemsMap = (Map)items;
			for (Object obj : itemsMap.entrySet()) {
				this.getJspContext().setAttribute(var, obj);
				this.getJspBody().invoke(null);
			}
		}else if (items instanceof Object[]) {
			Object[] itemsArray = (Object[])items;
			for (Object obj : itemsArray) {
				this.getJspContext().setAttribute(var, obj);
				this.getJspBody().invoke(null);
			}
		}*/
	}
}
