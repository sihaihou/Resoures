package hs.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	/**
	 * 允许那些URL不被拦截，那些需要被拦截
	 * allowedPath被允许拦截
	 */
	private List<String> allowedPath;
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object ages) throws Exception {
		System.out.println("----------执行前-----------");
		String url=req.getRequestURL().toString();
		//先判断Session中是否有
		Object user=req.getSession().getAttribute("user");
		if(user!=null){
			return true;
		}
		for(String temp:allowedPath){
			if(url.endsWith(temp)){
				return true;
			}
		}
		resp.sendRedirect(req.getContextPath()+"/login.jsp");
		return false;
	}
	//在请求处理的方法执行后执行
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2, ModelAndView arg3)
			throws Exception {
		
		System.out.println("----------执行后-----------");
		
	}
		
	//在DispatcherServlet处理后执行---清理工作
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}	
	
	public void setAllowedPath(List<String> allowedPath) {
		this.allowedPath = allowedPath;
	}
}
