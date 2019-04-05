package com.hs.test;

import com.hs.service.SomeService;
import com.hs.service.impl.SomeServiceWrapper;
import com.hs.service.impl.ToUpperService;
import com.hs.service.impl.TrimService;
import com.hs.service.impl.SomeServiceImpl;
/**
 * 装饰者设计模式
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		SomeService someServiceimpl = new SomeServiceImpl();
		
		SomeService trimService = new TrimService(someServiceimpl);
		
		SomeService toUpperService = new ToUpperService(trimService);
		
		String result = toUpperService.doSome();
		System.err.println(result);
	}
	
}
