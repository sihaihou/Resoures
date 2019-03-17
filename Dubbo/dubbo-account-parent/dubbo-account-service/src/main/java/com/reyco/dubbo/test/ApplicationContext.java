package com.reyco.dubbo.test;

import java.io.IOException;

import com.alibaba.dubbo.container.Main;

public class ApplicationContext {
	
	public static void main(String[] args) throws IOException {
		//采用dubbo建议的启动provider的服务
		Main.main(args);
	}
	
}
