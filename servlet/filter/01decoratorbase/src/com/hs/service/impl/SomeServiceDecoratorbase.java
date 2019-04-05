package com.hs.service.impl;

import com.hs.service.SomeService;
/**
 * 装饰者
 * 		1,要实现与目标类相同的接口;
 * 		2,装饰者中要有目标对象作为成员变量,通过构造方法传入
 * @author Administrator
 *
 */
public class SomeServiceDecoratorbase implements SomeService {
	private SomeServiceImpl target;
	
	public SomeServiceDecoratorbase(SomeServiceImpl target) {
		super();
		this.target = target;
	}

	@Override
	public String doSome() {
		return target.doSome().toUpperCase();
	}

}
