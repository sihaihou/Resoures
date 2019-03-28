package hs.intercept;

import javax.naming.spi.DirStateFactory.Result;

import org.eclipse.jdt.internal.compiler.ast.Invocation;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 自定义拦截器:实现Interceptor接口或者继承AstractIntercept类
 * 		测试执行该拦截器需耗时
 * @author Administrator
 */
public class TimeIntercept extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		long start = System.currentTimeMillis();
		String result=invocation.invoke();
		long end=  System.currentTimeMillis();
		System.out.println("执行该拦截器需耗时："+(end - start)+"ms");		
		return result;
	}	
}
