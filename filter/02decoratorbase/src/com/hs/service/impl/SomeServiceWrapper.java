package com.hs.service.impl;

import com.hs.service.SomeService;
/**
 * 装饰者父类
 * 		1,要实现与目标类相同的接口;
 * 		2,装饰者中要有目标接口作为成员变量,通过构造方法传入
 * 		3,必须带有无参构造器
 * 		4,对目标对象不做任何增强
 * @author Administrator
 *
 */
public class SomeServiceWrapper implements SomeService {
	private SomeService target;
	
	public SomeServiceWrapper() {
		super();
	}
	public SomeServiceWrapper(SomeService target) {
		super();
		this.target = target;
	}

	@Override
	public String doSome() {
		return target.doSome();
	}

}
