package hs.action;

import com.opensymphony.xwork2.Action;
/**
 *  ʵ��Action�ĵڶ��ַ�ʽ ��ʵ��action�ӿ�
 * @author Administrator
 *
 */
public class InterfaceAction implements Action{
	@Override
	public String execute() throws Exception {
		System.out.println("ʵ��Action�ĵڶ��ַ�ʽ");
		return "success";
	}
}
