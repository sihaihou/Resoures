package com.reyco.core.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

@Service
@WebFilter(urlPatterns="/student/login",filterName="accountFilter")
public class AccountFilter implements Filter{

	private static final String[] excludePathPatterns = { "/student/logout", "/student/register" };
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("----过滤器初始化-------");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("-----------dofilter----------");
		// 在请求处理之前进行调用（Controller方法调用之前）,返回true才会继续往下执行，返回false取消当前请求
		boolean isFilter = false;
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// 不拦截登出和注册
		String url = request.getRequestURI();
		if (Arrays.asList(excludePathPatterns).contains(url)) {
			chain.doFilter(request, response);
			return;
		}
		if(url.equals("/student/login")) {
			isFilter = true;
		}
		if(isFilter) {
			System.out.println("----------执行过滤器---------");
			chain.doFilter(request, response);
		}
	}
	@Override
	public void destroy() {
		System.out.println("----过滤器销毁----");
	}

}
