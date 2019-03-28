package com.hs.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 * 创建带标签体的标签
 * @author Administrator
 *
 */
public class ToUpper extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		//创建一个输出流
		StringWriter stringWriter = new StringWriter();
		//获取标签体对象
		JspFragment jspBody = this.getJspBody();
		//将标签体内容写入到输出流
		jspBody.invoke(stringWriter);
		//获取输出流中的字符串
		String content = stringWriter.toString();
		content = content.toUpperCase();
		//获取标准输出流
		JspWriter out = this.getJspContext().getOut();
		out.println(content);
		
	}
}
