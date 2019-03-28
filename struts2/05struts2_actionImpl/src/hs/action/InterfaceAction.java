package hs.action;

import com.opensymphony.xwork2.Action;
/**
 *  实现Action的第二种方式 ：实现action接口
 * @author Administrator
 *
 */
public class InterfaceAction implements Action{
	@Override
	public String execute() throws Exception {
		System.out.println("实现Action的第二种方式");
		return "success";
	}
}
