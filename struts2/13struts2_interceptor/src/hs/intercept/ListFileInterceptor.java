package hs.intercept;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
/**
 * ������������ִ�У�
 * @author Administrator
 */
public class ListFileInterceptor extends MethodFilterInterceptor{
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("������������ִ�У�");
		return invocation.invoke();
	}	
}
