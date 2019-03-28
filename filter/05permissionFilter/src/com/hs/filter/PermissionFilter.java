package com.hs.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
public class PermissionFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		String servletPath = req.getServletPath();
		if(servletPath.startsWith("/user")) {
			HttpSession session = req.getSession();
			if(session != null) {
				String user = (String) session.getAttribute("user");
				if(user != null) {
					chain.doFilter(request, response);
				}else {
					req.getRequestDispatcher("/login.jsp").forward(request, response);;
					return;
				}
			}else {
				req.getRequestDispatcher("/login.jsp").forward(request, response);;
				return;
			}
		}else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
	@Override
	public void destroy() {
		
	}
}
