package hs.intercept;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * 方法拦截器被执行！
 * @author Administrator
 */
public class ListFileInterceptor extends MethodFilterInterceptor{
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("方法拦截器被执行！");
		return invocation.invoke();
	}	
}
