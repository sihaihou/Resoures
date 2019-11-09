package com.reyco.aop;

import org.springframework.stereotype.Component;

import com.reyco.aop.core.annotation.MyAround;
import com.reyco.aop.core.annotation.MyAspect;

@MyAspect
@Component
public class TestAop {

	//@MyBefore("com.reyco.dao")
	public void testBefore() {
		System.out.println("before   ------------------  测试成功！");
	}

	//@MyAfter("com.reyco.dao")
	public void testAfter() {
		System.out.println("after   ------------------  测试成功！");
	}

	@MyAround("com.reyco.dao")
	public void testAround() {
		System.out.println("around   ------------------  测试成功！");
	}
	
}
