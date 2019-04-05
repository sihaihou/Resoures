package hs.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{
	/**
	 * ��������ķ���֮ǰִ��
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object arg2) throws Exception {
		System.out.println("----------ִ��ǰ-----------");
		//ʹ��HttpServletResponse����HttpServletRequset����ʵ��ת�����ض���
		//resp.sendRedirect(req.getContextPath()+"/index.jsp");
		return true;
	}
	
	/**
	 * ��������ķ���ִ�к�ִ��
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("-----------ִ�к�-----------");
	}
		
	/**
	 * ��DispatcherServlet�����ִ��---������
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("ִ��������������");
	}	
}
