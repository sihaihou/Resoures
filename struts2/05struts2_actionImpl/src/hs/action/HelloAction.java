package hs.action;

import com.opensymphony.xwork2.Action;
/**
 * ʵ��Action�ĵ�һ�ַ�ʽ
 * @author Administrator
 */
public class HelloAction {
	public String execute(){
		System.out.println("ʵ��Action�ĵ�һ�ַ�ʽ");
		return "success";
	}
}
