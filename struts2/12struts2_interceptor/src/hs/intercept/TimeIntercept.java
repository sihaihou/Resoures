package hs.intercept;

import javax.naming.spi.DirStateFactory.Result;

import org.eclipse.jdt.internal.compiler.ast.Invocation;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class TimeIntercept extends AbstractInterceptor{
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		long start = System.currentTimeMillis();
		String result=arg0.invoke();
		long end=  System.currentTimeMillis();
		System.out.println("Ö´ÐÐTimeÀ¹½ØÆ÷ÐèºÄÊ±£º"+(end - start)+"ms"+"\tresult:"+result);			
		return result;
	}	
}
