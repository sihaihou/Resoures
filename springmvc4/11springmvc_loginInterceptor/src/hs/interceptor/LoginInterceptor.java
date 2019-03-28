package hs.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	/**
	 * ������ЩURL�������أ���Щ��Ҫ������
	 * allowedPath����������
	 */
	private List<String> allowedPath;
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object ages) throws Exception {
		System.out.println("----------ִ��ǰ-----------");
		String url=req.getRequestURL().toString();
		//���ж�Session���Ƿ���
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
	//��������ķ���ִ�к�ִ��
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2, ModelAndView arg3)
			throws Exception {
		
		System.out.println("----------ִ�к�-----------");
		
	}
		
	//��DispatcherServlet�����ִ��---������
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		
	}	
	
	public void setAllowedPath(List<String> allowedPath) {
		this.allowedPath = allowedPath;
	}
}
