package com.reyco.core.controller;

import java.io.InputStream;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageInfo;
import com.reyco.core.constant.Status;
import com.reyco.core.pojo.Account;
import com.reyco.core.pojo.User;
import com.reyco.core.service.AccountService;
import com.reyco.core.util.CusAccessObjectUtil;
import com.reyco.core.util.DateUtil;
import com.reyco.core.util.IPDataUtils;
import com.reyco.core.util.JSONResult;
import com.reyco.core.util.PageUtil;
import com.reyco.core.util.PoiUtil;
import com.reyco.core.util.ResponseUtil;

@RequestMapping("/account")
@Controller("accountController")
public class AccountController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private AccountService accountService;

	/**
	 * login 登录
	 * 
	 * @param phone
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = { "/login" }, method = { RequestMethod.POST })
	public String login(String phone, String password, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String logObj = (String) session.getAttribute("user");
		if (!StringUtils.isBlank(logObj)) {
			return JSONResult.failCreate("登录失败,您已登录，请先退出...", "用户已登录...").toJSON();
		}
		if (StringUtils.isBlank(phone)) {
			return JSONResult.failCreate("登录失败,用户名不能为空...", "用户名不能为空...").toJSON();
		}
		Account account = accountService.login(phone);
		if (account == null) {
			return JSONResult.failCreate("用户名或密码错误,请重新输入...", "此用户不存在...").toJSON();
		}
		if (StringUtils.isBlank(password)) {
			return JSONResult.failCreate("登录失败,密码不能为空...", "密码不能为空...").toJSON();
		}
		String accountPassword = account.getPassword();
		if (!password.equals(accountPassword)) {
			return JSONResult.failCreate("用户名或密码错误,请重新输入...", "密码错误...").toJSON();
		}
		Integer accountStatus = account.getStatus();
		if (accountStatus == 1) {
			return JSONResult.failCreate("用户名或密码错误,请重新输入...", "此用户已删除...").toJSON();
		}
		if (accountStatus == 2) {
			return JSONResult.failCreate("用户名或密码错误,请重新输入...", "此用户已被禁用...").toJSON();
		}
		account.setPassword("");
		//获取登录ip
		String ip = CusAccessObjectUtil.getIpAddress(request);
		//获取登录城市
		String cityName = IPDataUtils.getCityName(ip);
		//获取登录用户
		String loginPhone = account.getPhone();
		User user = new User(ip,cityName,loginPhone);
		session.setAttribute("user",user);
		return JSONResult.create(account).toJSON1();
	}

	/**
	 * 登出
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		User user = (User)session.getAttribute("user");
		if (user == null) {
			return JSONResult.failCreate("未登录", "未登录").toJSON();
		}
		session.invalidate();
		return JSONResult.create("退出成功").toJSON();
	}

	/**
	 * 验证登录
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("checkUser")
	public String checkUser(HttpSession session) {
		User user = (User)session.getAttribute("user");
		if (null == user) {
			return JSONResult.failCreate("未登录", "没有session").toJSON();
		}
		return JSONResult.create(user).toJSON();
	}

	/**
	 * 注册
	 * 
	 * @param phone
	 * @param password
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/register")
	public String register(String phone, String password, String name) {
		if (StringUtils.isBlank(phone)) {
			return JSONResult.failCreate("注册失败,用户名不能为空...", "用户名不能为空...").toJSON();
		}
		if (StringUtils.isBlank(password)) {
			return JSONResult.failCreate("注册失败,密码不能为空...", "密码不能为空...").toJSON();
		}
		boolean flag = accountService.searchCountByPhone(phone);
		if (flag) {
			Integer status = Status.NORMAL;
			if (StringUtils.isBlank(name)) {
				name = "用户呢称";
			}
			String desc = "点击修改备注";
			accountService.register(phone.trim(), password.trim(), name.trim(),null,null,null,status,desc.trim());
			return JSONResult.create(phone + ":恭喜您！注册成功！成为我们的一员！").toJSON();
		}
		return JSONResult.failCreate("该手机已注册，请直接登录！", "该手机已注册").toJSON();
	}

	/**
	 * 分页
	 * 
	 * @param pageNo
	 * @param name
	 * @param phone
	 * @param status
	 * @param vipId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/searchPage")
	public String searchPage(Integer pageNo, String name, String phone, Integer status, Integer vipId, String startTime,
			String endTime) {
		if (pageNo < 1) {
			return JSONResult.failCreate(JSONResult.ERROR_SELECT, JSONResult.ERROR_SELECT).toJSON();
		}
		List<Account> list = accountService.searchPage(pageNo,name, phone, status, vipId, startTime, endTime);
		if (list.size() < 1) {
			return JSONResult.noDataCreate().toJSON();
		}
		PageInfo<Account> pageInfo = new PageInfo<Account>(list);
		return JSONResult.create(PageUtil.getPage(pageInfo)).toJSON();
	}
	/**
	 * 修改密码
	 * 
	 * @param phone
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updatePassword")
	public String updatePassword(String phone, String oldPassword, String newPassword, HttpSession session) {
		if (StringUtils.isBlank(phone)) {
			return JSONResult.failCreate("用户名不能为空", "用户名不能为空").toJSON();
		}
		if (StringUtils.isBlank(oldPassword)) {
			return JSONResult.failCreate("原密码不能为空,请重新输入", "原密码不能为空,请重新输入").toJSON();
		}
		if (StringUtils.isBlank(newPassword)) {
			return JSONResult.failCreate("新密码不能为空,请重新输入", "新密码不能为空,请重新输入").toJSON();
		}
		Account account = accountService.login(phone);
		if (account == null) {
			return JSONResult.failCreate("此用户不存在", "此用户不存在").toJSON();
		}
		String account_password = account.getPassword();
		if (account_password.equals(newPassword)) {
			return JSONResult.failCreate("新密码不能和原密码相同,请重新输入", "新密码不能和原密码相同,请重新输入").toJSON();
		}
		if (!account_password.equals(oldPassword)) {
			return JSONResult.failCreate("密码错误，请重新输入！", "密码错误，请重新输入！").toJSON();
		}
		Integer account_id = account.getId();
		accountService.updatePassword(account_id, newPassword.trim());
		session.invalidate(); // 修改密码后 把session失效
		return JSONResult.create("修改成功").toJSON();
	}

	@ResponseBody
	@RequestMapping("/searchById")
	public String searchAccount(Integer id) {
		if (null == id) {
			return JSONResult.failCreate(JSONResult.ERROR_PARAMS, JSONResult.ERROR_PARAMS).toJSON();
		}
		Account account = accountService.searchById(id);
		return JSONResult.create(account).toJSON1();
	}

	@ResponseBody
	@RequestMapping("/updateAccount")
	public String updateAccount(Integer id, Integer integral, String name, String password, Integer status, Integer gender,
			String birthday, String email, String desc) {
		if (null == id) {
			return JSONResult.failCreate(JSONResult.ERROR_PARAMS, JSONResult.ERROR_PARAMS).toJSON();
		}
		accountService.updateAccount(id, integral, null, name, password, status, gender, birthday, email, desc);
		return JSONResult.create("修改成功").toJSON();
	}
	/**
	 * 导出用户
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/exportAccount")
	public String exportAccount(HttpServletResponse response,Integer status,Integer vid) throws Exception {
		String fileName ="account.xls";
		Workbook wb = accountService.exportAccount(status, vid);
		ResponseUtil.export(response, fileName, wb);
		return JSONResult.create("null").toJSON();
	}
	@ResponseBody
	@RequestMapping(value= {"/insertAccount"},method= {RequestMethod.POST})
	public String insertAccount(@RequestParam("file")CommonsMultipartFile file,HttpServletRequest request) throws Exception{
		InputStream is = file.getInputStream();
		HSSFWorkbook wb = new HSSFWorkbook(is);
		HSSFSheet sheet = wb.getSheetAt(0);
		if(sheet != null) {
			for(int i=1;i<sheet.getLastRowNum()+1;i++) {
				HSSFRow row = sheet.getRow(i);
				if(null == row) {
					continue;
				}
				String phone = PoiUtil.formatCell(row.getCell(1));
				String name = PoiUtil.formatCell(row.getCell(2));
				String password = PoiUtil.formatCell(row.getCell(3));
				Integer gender = Integer.valueOf(PoiUtil.formatCell(row.getCell(4)));
				String birthday = PoiUtil.formatCell(row.getCell(5));
				String email = PoiUtil.formatCell(row.getCell(6));
				Integer status = Integer.valueOf(PoiUtil.formatCell(row.getCell(7)));
				String desc = PoiUtil.formatCell(row.getCell(8));
				accountService.register(phone,password,name,gender,birthday,email,status,desc);
			}
			return JSONResult.create("上传成功").toJSON();
		}
		return JSONResult.failCreate("上传失败", "").toJSON();
	}
	@ResponseBody
	@RequestMapping(value= {"/insert"},method= {RequestMethod.POST})
	public String insert(@RequestParam("file")CommonsMultipartFile file,HttpServletRequest request) throws Exception{
		InputStream is = file.getInputStream();
		HSSFWorkbook wb = new HSSFWorkbook(is);
		HSSFSheet sheet = wb.getSheetAt(0);
		if(sheet != null) {
			Vector<Account> vectorAccount = filterSheet(sheet);
			long end = System.currentTimeMillis();
			for (Account account : vectorAccount) {
				 Runnable runnable = new Runnable(){
					@Override
					public void run() {
						accountService.insert(account);
					}
				};
				new Thread(runnable).start();
			}
			return JSONResult.create("上传成功").toJSON();
		}
		return JSONResult.failCreate("上传失败", "").toJSON();
	}
	/**
	 * 过滤表格数据
	 * @return
	 */
	private Vector<Account> filterSheet(HSSFSheet sheet){
		// 作返回值
		Vector<Account> vector = null;
		// 为null直接返回
		if(null != sheet) {
			vector = new Vector<Account>();;
			//循环读取表格数据
			for(int i=1;i<sheet.getLastRowNum()+1;i++) {
				HSSFRow row = sheet.getRow(i);
				//当前行为null
				if(null == row) {
					continue;
				}
				// 第二列开始读,当前列如果没有数据，
				String phone = PoiUtil.formatCell(row.getCell(1));
				String name = PoiUtil.formatCell(row.getCell(2));
				String password = PoiUtil.formatCell(row.getCell(3));
				String genderStr = PoiUtil.formatCell(row.getCell(4));
				if(StringUtils.isBlank(genderStr)) {
					genderStr="1";
				}
				Integer gender = Integer.valueOf(genderStr);
				String birthday = PoiUtil.formatCell(row.getCell(5));
				String email = PoiUtil.formatCell(row.getCell(6));
				String statusStr = PoiUtil.formatCell(row.getCell(7));
				if(StringUtils.isBlank(statusStr)) {
					statusStr="0";
				}
				Integer status = Integer.valueOf(statusStr);
				String desc = PoiUtil.formatCell(row.getCell(8));
				if(StringUtils.isBlank(phone)) {
					continue;
				}
				Account account = dateToAccount(phone,name,password,gender,birthday,email,status,desc);
				vector.add(account);
			}
			return vector;
		}
		return null;
	}
	/**
	 *    将row数据封装到实体对象中
	 * @param phone
	 * @param name
	 * @param password
	 * @param gender
	 * @param birthday
	 * @param email
	 * @param status
	 * @param desc
	 * @return
	 */
	private Account dateToAccount(String phone,String name,String password,Integer gender,String birthday,String email,Integer status,String desc) {
		Account account = new Account();
		account.setPhone(phone);
		if(StringUtils.isBlank(name)){
			name=phone.substring(7);
		}
		account.setName(name);
		if(StringUtils.isBlank(password)){
			password="123456";
		}
		account.setPassword(password);
		if(null == gender) {
			gender = 1;
		}
		account.setGender(gender);
		if(null == birthday) {
			birthday = "2001-01-01";
		}
		account.setBirthday(DateUtil.parseDate(birthday));
		if(null == email) {
			email = "";
		}
		account.setEmail(email);
		if(null == status) {
			status = 0;
		}
		account.setStatus(status);
		if(null == desc) {
			desc = "备注";
		}
		account.setDesc(desc);
		return account;
	}
	class UploadThread implements Runnable{
		Vector<Account> vector;
		@Override
		public void run() {
			for (Account account : vector) {
				accountService.insert(account);
			}
		}
		public Vector<Account> getVector() {
			return vector;
		}
		public void setVector(Vector<Account> vector) {
			this.vector = vector;
		}
	}
	
	
}
