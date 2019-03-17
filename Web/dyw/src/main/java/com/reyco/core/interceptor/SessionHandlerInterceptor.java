package com.reyco.core.interceptor;

import java.net.URLDecoder;
import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 日志拦截器
 * @author reyco
 */
public class SessionHandlerInterceptor implements HandlerInterceptor {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		try {
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
			logger.info("request to " + to + "  | " + sb.toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
			//default not do something
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		//default not do something
	}
}
