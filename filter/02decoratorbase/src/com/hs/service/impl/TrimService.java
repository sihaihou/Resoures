package com.hs.service.impl;

import com.hs.service.SomeService;
/**
 * 具体装饰者：
 * 	1, 继承装饰者基类SomeServiceWrapper
 * 	2,要有带参构造器
 * 	3,具体装饰者只进行单一的增强
 * @author Administrator
 *
 */
public class TrimService extends SomeServiceWrapper {
	public TrimService() {
		super();
	}
	public TrimService(SomeService target) {
		super(target);
	}
	@Override
	public String doSome() {
		return super.doSome().trim();
	}
}
