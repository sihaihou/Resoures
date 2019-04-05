package com.hs.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 1,���post�������������
 * 2,�����Ӧ��������
 * @author Administrator
 *
 */
public class MyCharactorEncoding implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		/**
		 * ���post�������������
		 */
		request.setCharacterEncoding("UTF-8");
		/**
		 * �����Ӧ��������
		 */
		response.setContentType("text/html;charset=UTF-8");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//default do not anything
	}
	@Override
	public void destroy() {
		//default do not anything
	}

}
