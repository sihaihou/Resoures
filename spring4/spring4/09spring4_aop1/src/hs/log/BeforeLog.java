package hs.log;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;
/**
 * spring实现aop：
 * 		第一种方式：通过springAPI来实现，实现通知接口（AfterReturningAdvice，MethodBeforeAdvice等）
 * 
 *		 前置通知
 * @author Administrator
 */
public class BeforeLog implements MethodBeforeAdvice{
	/**
	 * @param method 被调用的方法
	 * @param args 被调用方法的参数
	 * @param target 被调用方法的目标对象
	 */
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println(target.getClass().getName()+"的"+method.getName()+"方法被执行啦");
	}
}
