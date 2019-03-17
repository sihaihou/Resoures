package com.reyco.core.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAop {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Pointcut("execution(* com.reyco.core.controller.AccountController.login(..))")
	public void loginPointcut() {
	}
	
	@Before("loginPointcut()")
	public void before() {
		logger.info("---前置通知---");
	}
	
	@After("loginPointcut()")
	public void after() {
		logger.info("---后置通知---");
	}
	
	@AfterReturning("loginPointcut()")
	public void afterReturning() {
		logger.info("---返回后通知---");
	} 
	//@Around("logPointcut()")
	public void around() {
		logger.info("---环绕通知---");
	} 
	@AfterThrowing(pointcut="loginPointcut()",throwing="ex")
	public void AfterThrowing (Exception ex) {
		//logger.info(ex.getMessage(),ex);
	}
	
}
