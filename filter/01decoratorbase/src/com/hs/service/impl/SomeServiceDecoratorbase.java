package com.hs.service.impl;

import com.hs.service.SomeService;
/**
 * װ����
 * 		1,Ҫʵ����Ŀ������ͬ�Ľӿ�;
 * 		2,װ������Ҫ��Ŀ�������Ϊ��Ա����,ͨ�����췽������
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
