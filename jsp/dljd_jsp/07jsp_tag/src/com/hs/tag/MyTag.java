package com.hs.tag;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * ��ǩ�Ĵ����ࣺ�̳�SimpleTagSupport,��дdoTag()����
 * @author Administrator
 *
 */
public class MyTag extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		PageContext pageContext = (PageContext)this.getJspContext();
		ServletRequest request = pageContext.getRequest();
		String clientIp = request.getRemoteAddr();
		pageContext.getOut().write("This is a my first taglib!<br>" + clientIp);
	}
}
