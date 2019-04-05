package com.exam.core.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
	@Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }
	
    @Bean
    public FilterRegistrationBean<MyFilter> testFilterRegistration() {
        FilterRegistrationBean<MyFilter> registration = new FilterRegistrationBean<MyFilter>();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }
    
	public class MyFilter implements Filter {
		@Override
		public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
				throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) servletRequest;
			String requestMethod = request.getMethod();
			String ip = request.getRemoteAddr();
			int port = request.getServerPort();
			String url = request.getRequestURI();
			Map<String, String[]> parameterMap = request.getParameterMap();
			System.out.print("parameter:");
			for(String key:parameterMap.keySet()) {
				String[] str = parameterMap.get(key);
				for (String string : str) {
					System.out.print("\r\tkey="+key+",value="+string);
					System.out.println();
				}
			}
			System.out.println();
			System.out.print("url:");
			System.out.print("\r\t"+requestMethod+":"+ip+"://"+port+url);
			filterChain.doFilter(servletRequest, servletResponse);
		}
		@Override
		public void init(FilterConfig arg0) throws ServletException {
			System.out.println("过滤器---初始化");
		}
		@Override
		public void destroy() {
			System.out.println("过滤器---销毁");
		}
    }
}
