package hs.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
/**
 * spring实现aop：
 * 			第三种方式：注解实现aop
 * @author Administrator
 */
@Aspect
public class Log {
	@Before("execution(* hs.service.impl.*.*(..))")
	public void before(){
		System.out.println("------方法执行前------ ");
	}
	@After("execution(* hs.service.impl.*.*(..))")
	public void after(){
		System.out.println("------方法执行后------ ");
	}
	
	//带参
	@Around("execution(* hs.service.impl.*.*(..))")
	public Object aroud(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("环绕前");
		System.out.println("签名："+jp.getSignature());
		//执行目标方法
		Object result = jp.proceed();
		System.out.println("环绕后");
		return result;
	}
}
