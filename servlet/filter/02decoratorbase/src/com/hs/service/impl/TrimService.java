package com.hs.service.impl;

import com.hs.service.SomeService;
/**
 * ����װ���ߣ�
 * 	1, �̳�װ���߻���SomeServiceWrapper
 * 	2,Ҫ�д��ι�����
 * 	3,����װ����ֻ���е�һ����ǿ
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
