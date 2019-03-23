package com.reyco.core.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reyco.core.pojo.Base;
import com.reyco.core.service.BaseService;
import com.reyco.core.task.Bases;
import com.reyco.core.task.BatchInsertThread;
import com.reyco.core.task.DoSome1;
import com.reyco.core.task.EatSome1;
import com.reyco.core.task.InsertThread;
import com.reyco.core.util.JSONResult;
import com.reyco.core.util.PageUtil;
import com.reyco.core.util.PoiUtil;
import com.reyco.core.util.ResponseUtil;
/**
 * 专门作测试用的Action类
 * @author reyco
 *
 */
@RequestMapping("base")
@Controller("baseController")
public class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	public BaseService baseService;
	
	/**
	 * 测试根据name查询
	 * @param name
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "login")
	public String login(String name,String password) throws IOException {
		if(StringUtils.isBlank(name)) {
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_PARAMS).toJSON();
		}
		if(StringUtils.isBlank(password)) {
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_PARAMS).toJSON();
		}
		Base base = baseService.login(name);
		if(null == base) {
			return JSONResult.failCreate("用户不存在","用户不存在").toJSON();
		}
		if (!password.equals(base.getPassword())) {
			return JSONResult.failCreate("密码错误","密码错误").toJSON();
		}
		return JSONResult.create(base.getName()).toJSON();
	}
	/**
	 * 测试单条新增
	 * @param name
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/insert")
	public String insert(String name,String password) {
		if(null == name) {
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_PARAMS).toJSON();
		}
		if(null == password) {
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_PARAMS).toJSON();
		}
		Base base = new Base(name,password);
		baseService.insert(base);
		return JSONResult.create(JSONResult.INSERT_SUCCESS).toJSON();
	}
	/**
	 *  测试根据id查询
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/searchById")
	public String searchById(Integer id) {
		if(null == id) {
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_PARAMS).toJSON();
		}
		Base base = baseService.searchById(id);
		return JSONResult.create(base).toJSON();
	}
	/**
	 * 测试根据id单条更新
	 * @param id
	 * @param name
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateById")
	public String updateById(Integer id,String name,String password) {
		if(null == id) {
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_PARAMS).toJSON();
		}
		Base base = new Base(id,name,password);
		baseService.updateById(base);
		return JSONResult.create(JSONResult.UPDATE_SUCCESS).toJSON();
	}
	/**
	 * 测试分页
	 * @param pageNo
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/searchPage")
	public String searchPage(Integer pageNo,String name) {
		if(null == pageNo) {
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_PARAMS).toJSON();
		}
		Base base = new Base(name);
		PageHelper.startPage(pageNo,PageUtil.PAGESIZE);
		PageInfo<Base> pageInfo = baseService.searchPage(base);
		List<Base> list = pageInfo.getList();
		if(list.size() < 1) {
			return JSONResult.noDataCreate().toJSON();
		}
		return JSONResult.create(PageUtil.getPage(pageInfo)).toJSON();
	}
	/**
	 * excel批量新增数据
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("batchInsert")
	public String batchInsert(@RequestParam("file")CommonsMultipartFile file,HttpServletRequest request) throws IOException {
		//读取流
		InputStream is = file.getInputStream();
		//根据is流创建wb
		HSSFWorkbook wb = new HSSFWorkbook(is);
		//获取页
		HSSFSheet sheet = wb.getSheetAt(0);
		if(sheet != null) {
			//过滤表格数据到List集合
			List<Base> baseList = filterSheet(sheet);
			//保存/提交数据
			saveBaseInfoList(baseList);
			return JSONResult.create("上传成功").toJSON();
		}
		return JSONResult.failCreate("上传失败", "").toJSON();
	}
	/**
	 * 读取表格数据加入到List容器
	 * @return
	 */
	private List<Base> filterSheet(HSSFSheet sheet){
		// 作返回值
		List<Base> list = null;
		// 为null直接返回
		if(null != sheet) {
			list = new ArrayList<Base>();;
			//循环读取表格数据
			for(int i=1;i<sheet.getLastRowNum()+1;i++) {
				HSSFRow row = sheet.getRow(i);
				//当前行为null
				if(null == row) {
					continue;
				}
				// 第二列开始读,当前列如果没有数据，
				String name = PoiUtil.formatCell(row.getCell(1));
				String password = PoiUtil.formatCell(row.getCell(2));
				//name为null或空串直接返回,不要添加到List集合
				if(StringUtils.isBlank(name)) {
					continue;
				}
				//如果没有指定密码，给默认密码
				if(StringUtils.isBlank(password)) {
					password="123456";
				}
				//封装数据到实体类中
				Base base = new Base(name,password);
				//封装对象到List
				list.add(base);
			}
			return list;
		}
		return null;
	}
	/**
	 * 保存操作
	 */
	public void saveBaseInfoList(List<Base> list) {
		int listSize = list.size();// 数据集合大小
		int count =999; // 一个线程处理多少条数据,默认1000
		//根据数据量确定一个线程处理多少条数据
		if( listSize >= 1 && listSize < 1000) {
			count = 333;
		}else if(listSize >= 1000 && listSize < 10000) {
			count = 1333;
		}else if(listSize >= 10000) {
			count = 5333;
		}
		int runThreadSize  = (listSize / count) + 1;    // 开启的线程数
		logger.error("--------runThreadSize-------====="+runThreadSize);
		List<Base> newList = null;// 存放每个线程的执行数据
	//	ExecutorService executor = Executors.newFixedThreadPool(runThreadSize);// 创建一个线程池,数量和开启线程的数量一样
		// 创建两个个计数器
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(runThreadSize);
        // 循环创建线程
        for (int i=0;i<runThreadSize;i++) {
        	if ((i + 1) == runThreadSize) {
                int startIndex;
                startIndex = (i * count);
                int endIndex = list.size();
                newList = list.subList(startIndex, endIndex);
            } else {
                int startIndex = (i * count);
                int endIndex = ((i + 1) * count);
                newList = list.subList(startIndex, endIndex);
            }
        	createBatchInsertThread(newList,begin,end);
		}
	}
	/**
	 * 创建insert线程
	 * @param newList
	 * @param begin
	 * @param end
	 */
	private void createInsertThread(List<Base> newList, CountDownLatch begin,CountDownLatch end) {
		InsertThread insertThread = new InsertThread(newList,begin,end);
    	new Thread(insertThread).start();
	}
	/**
	 * 创建batchInsert线程
	 * @param newList
	 * @param begin
	 * @param end
	 */
	private void createBatchInsertThread(List<Base> newList, CountDownLatch begin,CountDownLatch end) {
		BatchInsertThread batchinsertThread = new BatchInsertThread(newList,begin,end);
    	new Thread(batchinsertThread).start();
	}
	
	@ResponseBody
	@RequestMapping("moshiBatchInsert")
	public  String moshiBatchInsert(@RequestParam("file")CommonsMultipartFile file,HttpServletRequest request) throws IOException {
		//读取流
		InputStream is = file.getInputStream();
		//根据is流创建wb
		HSSFWorkbook wb = new HSSFWorkbook(is);
		//获取页
		HSSFSheet sheet = wb.getSheetAt(0);
		if(sheet != null) {
			//过滤表格数据到List集合
			List<Base> baseList = filterSheet(sheet);
			//doSome使用
			//List<List<Base>> list = getList(baseList);
			//保存/提交数据
			//共同的资源
			Bases bases=new Bases();
			//DoSome doSome=new DoSome(bases,list);
			//EatSome eatSome=new EatSome(bases,list);
			DoSome1 doSome= new DoSome1(bases,baseList);
			EatSome1 eatSome= new EatSome1(bases,baseList);
			Thread t=new Thread(doSome);
			Thread t2=new Thread(eatSome);
			t.start();
			t2.start();
			return JSONResult.create("上传成功").toJSON();
		}
		return JSONResult.failCreate("上传失败", "").toJSON();
	}
	/**
	 * 获取List<List<Base>>对象
	 * @param baseList
	 * @return
	 */
	private List<List<Base>> getList(List<Base> baseList){
		List<List<Base>> list = new ArrayList<List<Base>>();
		if(null == baseList) {
			return null;
		}
		int listSize = baseList.size();
		int count = 333;
		if(listSize >= 1 && listSize < 1000) {
			count = 333;
		}else if(listSize >= 1000 && listSize < 10000) {
			count = 1333;
		}else {
			count = 5000;
		}
		int size = (listSize/count)+1;
		for(int i=0;i<size;i++) {
			List<Base> newList = new ArrayList<Base>();
			if((i+1) == size) {
				newList = baseList.subList(i*count, listSize);
			}else {
				newList = baseList.subList(i*count, (i+1)*count);
			}
			list.add(newList);
		}
		return list;
	}
	@ResponseBody
	@RequestMapping("searchList")
	public String searchList(String name,HttpServletRequest request,HttpServletResponse response) throws Exception {
		String fileName ="account.xls";
		Workbook wb = new HSSFWorkbook();
		String columnNames[]={"编号","呢称","密码"};
		String[] keys = {"id","name","password"};
		List<Base> bases = baseService.searchList(name);
		List<Map<String, Object>> listmap = createExcelRecord(bases);
		PoiUtil.excelData(listmap, wb, keys,columnNames);
		ResponseUtil.export(response, fileName, wb);
		return JSONResult.create("null").toJSON();
	}
	/**
	 * 将数据封装 List<Map<String,Object>>
	 * @param account
	 * @return
	 */
	private List<Map<String,Object>> createExcelRecord(List<Base> base){
		List<Map<String,Object>> listmap = new ArrayList<Map<String,Object>>();
		for(int i=0;i<base.size();i++) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",Integer.valueOf(base.get(i).getId()));
			map.put("name", base.get(i).getName());
			map.put("password", base.get(i).getPassword());
			listmap.add(map);
		}
		return listmap;
	}
	
}
