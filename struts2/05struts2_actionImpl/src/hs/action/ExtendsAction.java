package hs.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 实现Action的第三种方式！ 继承ActionSupport类
 * @author Administrator
 *
 */
public class ExtendsAction extends ActionSupport{
	@Override
	public String execute() throws Exception {	
		System.out.println("实现Action的第三种方式！");
		return SUCCESS;
	}
}
