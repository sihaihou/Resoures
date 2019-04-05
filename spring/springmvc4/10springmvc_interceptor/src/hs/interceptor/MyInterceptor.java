package hs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{
	/**
	 * 在请求处理的方法之前执行
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		System.out.println("----------执行前-----------");
		//使用HttpServletResponse或者HttpServletRequset可以实现转发和重定向
		//resp.sendRedirect(req.getContextPath()+"/index.jsp");
		return true;
	}
	
	/**
	 * 在请求处理的方法执行后执行
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("-----------执行后-----------");
	}
		
	/**
	 * 在DispatcherServlet处理后执行---清理工作
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("执行清理工作。。。");
	}	
}
