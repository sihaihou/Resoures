package com.hs.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 创建带属性的标签
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
			 * 填invoke()方法，填null默认加了标准输出流
			 */
			this.getJspBody().invoke(null);;
		}
	}
}
