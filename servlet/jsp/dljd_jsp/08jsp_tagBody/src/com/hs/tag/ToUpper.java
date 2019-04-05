package com.hs.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * ��������ǩ��ı�ǩ
 * @author Administrator
 *
 */
public class ToUpper extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		//����һ�������
		StringWriter stringWriter = new StringWriter();
		//��ȡ��ǩ�����
		JspFragment jspBody = this.getJspBody();
		//����ǩ������д�뵽�����
		jspBody.invoke(stringWriter);
		//��ȡ������е��ַ���
		String content = stringWriter.toString();
		content = content.toUpperCase();
		//��ȡ��׼�����
		JspWriter out = this.getJspContext().getOut();
		out.println(content);
		
	}
}
