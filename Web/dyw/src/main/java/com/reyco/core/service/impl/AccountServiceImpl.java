package com.reyco.core.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.reyco.core.dao.AccountDao;
import com.reyco.core.pojo.Account;
import com.reyco.core.service.AccountService;
import com.reyco.core.util.DateUtil;
import com.reyco.core.util.PageUtil;
import com.reyco.core.util.PoiUtil;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;
	/**
	 * login 登录
	 */
	@Override
	public Account login(String phone) {
		return accountDao.login(phone);
	}
	@Override
	public void register(String phone, String password, String name,Integer gender,String birthday,String email,Integer status, String desc) {
		Date birthdayDate = DateUtil.parseDateTime(birthday);
		Account account = new Account(phone,password,name,status,gender,birthdayDate,email,desc);
		accountDao.register(account);
	}
	@Override
	public void insert(Account account) {
		accountDao.register(account);
	}
	@Override
	public List<Account> searchPage(Integer pageNo,String name, String phone, Integer status, Integer vipId, String startTime,
			String endTime) {
		PageHelper.startPage(pageNo, PageUtil.PAGESIZE);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("phone", phone);
		map.put("status", status);
		map.put("vipId", vipId);
		map.put("startTime", startTime);
		map.put("endTime", endTime);
		List<Account> list = accountDao.searchPage(map);
		for (Account account : list) {
			account.setStatus_info(getStatusInfo(account.getStatus()));
		}
		return list;
	}

	/**
	 * 获取状态信息
	 * 
	 * @param status
	 * @return
	 */
	private String getStatusInfo(Integer status) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(0, "正常");
		map.put(1, "已删除");
		map.put(2, "待审核");
		return map.get(status);
	}
	/**
	 * 过滤用户名不能重复
	 */
	@Override
	public boolean searchCountByPhone(String phone) {
		Integer phoneCount = accountDao.searchCountByPhone(phone);
		if(phoneCount == 0) {
			return true;
		}
		return false;
	}
	@Override
	public void updateAccount(Integer id,Integer integral, String phone,String name, String password, Integer status,Integer gender,String birthday,String email, String desc) {
		Date birthdayDate = DateUtil.parseDate(birthday);
		Account account = new Account(id,integral,phone,password,name,status,gender,birthdayDate,email,desc);
		accountDao.updateAccount(account);
	}
	@Override
	public void updatePassword(Integer id,String password) {
		Account account = new Account(id,password);
		accountDao.updateAccount(account);
	}
	@Override
	public Account searchById(Integer id) {
		return accountDao.searchById(id);
	}
	@Override
	public List<Account> searchList(Integer status,Integer vid) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status",status);
		map.put("vid", vid);
		return accountDao.searchList(map);
	}
	@Override
	public Workbook exportAccount(Integer status,Integer vid) {
		Workbook wb = new HSSFWorkbook();
		String columnNames[]={"账号","呢称","会员","积分","邮箱","状态","注册日期"};
		String[] keys = {"phone","name","vipName","integral","email","status","gmtCreate"};
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status",status);
		map.put("vid", vid);
		List<Account> accounts = accountDao.searchList(map);
		List<Map<String, Object>> listmap = createExcelRecord(accounts);
		PoiUtil.excelData(listmap, wb, keys,columnNames);
		return wb;
	}
	/**
	 * 将对象封装 List<Map<String,Object>>
	 * @param account
	 * @return
	 */
	private List<Map<String,Object>> createExcelRecord(List<Account> account){
		List<Map<String,Object>> listmap = new ArrayList<Map<String,Object>>();
		for(int i=0;i<account.size();i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("phone", account.get(i).getPhone());
			map.put("name", account.get(i).getName());
			map.put("vipName", account.get(i).getVipName());
			map.put("integral",account.get(i).getIntegral());
			map.put("email",account.get(i).getEmail()==null?"":account.get(i).getEmail());
			map.put("status",getStatusInfo(account.get(i).getStatus()));
			map.put("gmtCreate",DateUtil.formatDateTime(account.get(i).getGmtCreate()));
			listmap.add(map);
		}
		return listmap;
	}
}
