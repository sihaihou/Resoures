package hs.action;

import com.opensymphony.xwork2.ActionSupport;
/**
 * ʵ��Action�ĵ����ַ�ʽ�� �̳�ActionSupport��
 * @author Administrator
 *
 */
public class ExtendsAction extends ActionSupport{
	@Override
	public String execute() throws Exception {	
		System.out.println("ʵ��Action�ĵ����ַ�ʽ��");
		return SUCCESS;
	}
}
