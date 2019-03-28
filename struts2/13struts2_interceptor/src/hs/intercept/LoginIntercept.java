package hs.intercept;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginIntercept extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		/**
		 * �ж��Ƿ�login.action ����ǣ�ֱ��ִ����һ����������
		 * ������ǣ��ж��Ƿ��¼������ѵ�¼��ֱ��ִ����һ����������
		 * ���û�е�¼�򷵻ص�¼ҳ��
		 * actionName û����չ��
		 */
		String actionName = invocation.getProxy().getActionName();
		System.out.println("LoginactionName:"+actionName);
		if("login".equals(actionName)){
			return invocation.invoke();
		}
		Object obj = invocation.getInvocationContext().getSession().get("user");
		if(obj==null){	//û�е�¼
			return Action.LOGIN;
		}
		return invocation.invoke();
	}		
}
