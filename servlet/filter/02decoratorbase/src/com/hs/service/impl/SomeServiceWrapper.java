package com.hs.service.impl;

import com.hs.service.SomeService;
/**
 * װ���߸���
 * 		1,Ҫʵ����Ŀ������ͬ�Ľӿ�;
 * 		2,װ������Ҫ��Ŀ��ӿ���Ϊ��Ա����,ͨ�����췽������
 * 		3,��������޲ι�����
 * 		4,��Ŀ��������κ���ǿ
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
