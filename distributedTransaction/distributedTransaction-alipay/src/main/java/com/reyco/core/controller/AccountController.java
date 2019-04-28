package com.reyco.core.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reyco.core.domain.Account;
import com.reyco.core.service.AccountService;
import com.reyco.core.service.MessageService;

@RequestMapping("account")
@Controller
public class AccountController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private AccountService accountService;
	@Autowired
	private MessageService messageService;
	
	@ResponseBody
	@RequestMapping("transfer")
	public String transfer(Integer accountId,Integer amount) {
		if(null == accountId || null == amount) {
			return "转账失败。。。";
		}
		logger.info("Parameter:\taccountId==="+accountId+"\tamount==="+amount);
		boolean flag = accountService.transfer(accountId, amount);
		if(flag) {
			logger.info("转账成功，预计24小时之内到账,请注意查收!");
			return "转账成功，预计24小时之内到账,请注意查收!";
		}
		return "转账失败。。。";
	}
	@ResponseBody
	@RequestMapping("callback")
	public String updateStatus(String param) {
		if(null == param || "".equals(param)) {
			return "fail";
		}
		logger.info("Parameter:\tparam==="+param.toString());
		try {
			messageService.updateStatusById(param);
			return "success";
		} catch (Exception e) {
			return "fail";
		}
	}
	@ResponseBody
	@RequestMapping("test")
	public String testUpdateStatus() {
		Account account = new Account();
		account.setId(1);
		accountService.testUpdateAccountById(account);
		return "ok";
	}
	
	
}
