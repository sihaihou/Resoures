package com.reyco.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.reyco.dyw.service.AccountDubboService;
import com.reyco.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	/**
	 * dubbo的注解，引人服务bean
	 */
	@Reference
	private AccountDubboService accountDubboService;
	
	@Override
	public Boolean login(String name, String password) {
		return accountDubboService.login(name, password);
	}

}
