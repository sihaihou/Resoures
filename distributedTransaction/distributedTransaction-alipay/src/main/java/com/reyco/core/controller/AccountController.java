package com.reyco.core.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

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
		boolean flag = accountService.transfer(accountId, amount);
		if(flag) {
			return "update success";
		}
		return "update fail";
	}
	@ResponseBody
	@RequestMapping("callback")
	public String updateStatus(String param) {
		logger.info("param==="+param.toString());
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
