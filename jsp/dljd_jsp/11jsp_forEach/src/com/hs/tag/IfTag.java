package com.hs.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * ���������Եı�ǩ
 * @author Administrator
 *
 */
public class IfTag extends SimpleTagSupport {
	private Boolean flag;
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	@Override
	public void doTag() throws JspException, IOException {
		if(flag) {
			/*JspFragment jspBody = this.getJspBody();
			jspBody.invoke(this.getJspContext().getOut());*/
			/**
			 * ��invoke()��������nullĬ�ϼ��˱�׼�����
			 */
			this.getJspBody().invoke(null);;
		}
	}
}
