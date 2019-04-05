package com.reyco.core.intercrpter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Service
public class UserConfig implements HandlerInterceptor {
	/**
	 * 在请求处理的方法之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("----------自定义拦截器在请求处理的方法之前执行-----------");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	/**
	 * 在请求处理的方法执行后执行
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("----------自定义拦截器在请求处理的方法执行后执行-----------");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	/**
	 * 在DispatcherServlet处理后执行---清理工作
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("DispatcherServlet处理后执行执行清理工作。。。");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
