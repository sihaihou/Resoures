package hs.intercept;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginIntercept extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		/**
		 * 判断是否login.action 如果是，直接执行下一个拦截器；
		 * 如果不是，判断是否登录，如果已登录，直接执行下一个拦截器，
		 * 如果没有登录则返回登录页面
		 * actionName 没有扩展名
		 */
		String actionName = invocation.getProxy().getActionName();
		System.out.println("LoginactionName:"+actionName);
		if("login".equals(actionName)){
			return invocation.invoke();
		}
		Object obj = invocation.getInvocationContext().getSession().get("user");
		if(obj==null){	//没有登录
			return Action.LOGIN;
		}
		return invocation.invoke();
	}		
}
