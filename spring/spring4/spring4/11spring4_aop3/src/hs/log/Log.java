package hs.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
/**
 * springʵ��aop��
 * 			�����ַ�ʽ��ע��ʵ��aop
 * @author Administrator
 */
@Aspect
public class Log {
	@Before("execution(* hs.service.impl.*.*(..))")
	public void before(){
		System.out.println("------����ִ��ǰ------ ");
	}
	@After("execution(* hs.service.impl.*.*(..))")
	public void after(){
		System.out.println("------����ִ�к�------ ");
	}
	
	//����
	@Around("execution(* hs.service.impl.*.*(..))")
	public Object aroud(ProceedingJoinPoint jp) throws Throwable{
		System.out.println("����ǰ");
		System.out.println("ǩ����"+jp.getSignature());
		//ִ��Ŀ�귽��
		Object result = jp.proceed();
		System.out.println("���ƺ�");
		return result;
	}
}
