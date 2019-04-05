package hs.log;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
/**
 * spring实现aop：
 * 		第一种方式：通过springAPI来实现，实现通知接口（AfterReturningAdvice，MethodBeforeAdvice等）
 * 
 *		 后置通知
 * @author Administrator
 */
public class AfterLog implements AfterReturningAdvice{
	/**
	 * retureValue 返回值
	 * method 被调用的方法
	 * args 被调用方法的参数
	 * target 被调用方法对象的目标对象
	 */
	@Override
	public void afterReturning(Object retureValue, Method method, Object[] args, Object target) 
			throws Throwable {
		System.out.println(target.getClass().getName()+"的"+method.getName()+"被执行了，返回值为:"+retureValue);
	}
}
