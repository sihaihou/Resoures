package hs.intercept;

import javax.naming.spi.DirStateFactory.Result;

import org.eclipse.jdt.internal.compiler.ast.Invocation;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * �Զ���������:ʵ��Interceptor�ӿڻ��߼̳�AstractIntercept��
 * 		����ִ�и����������ʱ
 * @author Administrator
 */
public class TimeIntercept extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		long start = System.currentTimeMillis();
		String result=invocation.invoke();
		long end=  System.currentTimeMillis();
		System.out.println("ִ�и����������ʱ��"+(end - start)+"ms");		
		return result;
	}	
}
