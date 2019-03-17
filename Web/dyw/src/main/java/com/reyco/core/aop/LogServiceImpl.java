package com.reyco.core.aop;

import java.net.URLDecoder;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/**
 * 日志的实现aop方式
 * @author reyco
 */
@Component
@Aspect
public class LogServiceImpl{
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 切入点
	 */
	@Pointcut("execution(* com.reyco.core.controller.*.*(..))")
	public void logPointcut() {
		// default not do nothing 
	}
	/**
	 * 前置通知:日志
	 */
	@Before("logPointcut()")
	public void log(JoinPoint point) {
		HttpServletRequest request = null;
		try {
			request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
			// 输出参数日志
			StringBuilder sb = new StringBuilder();
			sb.append("Parameter : ");
			Enumeration paramNames = request.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String paramName = (String) paramNames.nextElement();
				String[] paramValues = request.getParameterValues(paramName);
				if (paramValues != null) {
					String value = "";
					for (String s : paramValues) {
						if (StringUtils.isBlank(value)) {
							value += s;
						} else {
							value += "," + s;
						}
					}
					sb.append("[" + paramName + ":" + URLDecoder.decode(value) + "]");
				}
			}
			sb.append("cookies : ");
			if(request.getCookies() != null) {
				for (Cookie c : request.getCookies()) {
					sb.append("[" + c.getName() + ":" + URLDecoder.decode(c.getValue()) + "]");
				}
			}
			String to = request.getRequestURI();
			//logger.info("request to " + to + "  | " + sb.toString());
		} catch (Exception e) {
			//logger.error(e.getMessage(), e);
		}
	}
}
