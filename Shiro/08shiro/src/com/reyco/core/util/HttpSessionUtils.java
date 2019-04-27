package com.reyco.core.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HttpSessionUtils {
	
	public static final String STAFF_HEAD = "staff_";

	public static void set(String key, Object value, HttpServletRequest request) {
		request.getSession().setAttribute(key, value);
	}

	public static Object get(String key, HttpServletRequest request) {
		return request.getSession().getAttribute(key);
	}

	public static Object get(String key, HttpServletRequest request, boolean create) {
		HttpSession session = request.getSession(create);
		return session != null ? session.getAttribute(key) : null;
	}
}
