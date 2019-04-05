package com.hs.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 1,解决post请求的中文乱码
 * 2,解决响应中文乱码
 * @author Administrator
 *
 */
public class MyCharactorEncoding implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		/**
		 * 解决post请求的中文乱码
		 */
		request.setCharacterEncoding("UTF-8");
		/**
		 * 解决响应中文乱码
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
