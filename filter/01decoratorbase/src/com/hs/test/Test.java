package com.hs.test;

import com.hs.service.SomeService;
import com.hs.service.impl.SomeServiceDecoratorbase;
import com.hs.service.impl.SomeServiceImpl;
/**
 * װ�������ģʽ
 * @author Administrator
 *
 */
public class Test {
	public static void main(String[] args) {
		SomeService someService = new SomeServiceDecoratorbase(new SomeServiceImpl());
		String result = someService.doSome();
		System.err.println(result);
	}
	
}
