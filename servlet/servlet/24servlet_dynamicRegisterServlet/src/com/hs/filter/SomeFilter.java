package com.hs.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SomeFilter implements Filter {
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.err.println("SomeFilterÒÑ±»×¢²á£¡");
		chain.doFilter(request, response);
	}
	
	
    public SomeFilter() {
    }
	public void destroy() {
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
}
