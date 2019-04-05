package com.exam.core.intercrpter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootConfiguration
public class UserSpringMVCConfig extends WebMvcConfigurerAdapter {
		
		@Autowired
		private UserConfig userConfig;
		
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			//是拦截请求
			 registry.addInterceptor(userConfig).addPathPatterns("/student/login")
			//无需拦截的请求
			.excludePathPatterns("/student/logout","/student/register");
			super.addInterceptors(registry);
		}
}
