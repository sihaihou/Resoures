package com.reyco.core.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.github.pagehelper.PageInfo;
import com.reyco.core.constant.Contants;
import com.reyco.core.constant.Status;
import com.reyco.core.pojo.Page;
import com.reyco.core.pojo.Video;
import com.reyco.core.service.VideoService;
import com.reyco.core.util.FileuploadUtil;
import com.reyco.core.util.JSONResult;
import com.reyco.core.util.PageUtil;
import com.reyco.core.util.PropertiesUtil;

@RequestMapping("/video")
@Controller("videoController")
public class VideoController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 *  常量  /
	 */
	private final static String SLASH = "/";
	
	@Autowired
	private VideoService videoService;
	
	@ResponseBody
	@RequestMapping("/searchPage")
	public String searchPage(Integer pageNo,Integer status,String name,Integer categoryId,Integer accountId) {
		if(pageNo < 1) {
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_SELECT).toJSON();
		}
		List<Video> list=videoService.searchPage(pageNo,status,name,categoryId,accountId);
		if(list.size() < 1) {
			return JSONResult.noDataCreate().toJSON();
		}
		PageInfo<Video> pageInfo=new PageInfo<Video>(list);
		return JSONResult.create(PageUtil.getPage(pageInfo)).toJSON();
	}
	/**
	 * 上传文件
	 * @param file
	 * @param type
	 * @param name
	 * @param desc
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
    @RequestMapping("/insertVideo")
    public String insertVideo(@RequestParam(value = "file", required = false) CommonsMultipartFile file,
                                  Integer categoryId,Integer vipId,Integer accountId,String name,String desc,HttpServletRequest request) throws Exception {
		// 文件部分路径  ../video/
		String fileuploadPath = PropertiesUtil.getValue("fileupload.path");
		if(StringUtils.isBlank(fileuploadPath) ) {
			return JSONResult.failCreate(JSONResult.INSERT_FAIL,JSONResult.INSERT_FAIL).toJSON();
		}
		// 文件部分路径  ../video/1(type值ֵ)
		String path = fileuploadPath+categoryId;
		if(StringUtils.isBlank(path) ) {
			return JSONResult.failCreate(JSONResult.INSERT_FAIL,JSONResult.INSERT_FAIL).toJSON();
		}
		Date date = new Date();
		//  时间戳
		long timeStr = date.getTime();
		if(file == null) {
			return JSONResult.failCreate(JSONResult.INSERT_FAIL,JSONResult.INSERT_FAIL).toJSON();
		}
		// 文件上传并返回上传后文件名
		String fileName = FileuploadUtil.fileupload(path, file,timeStr, request);
		if(StringUtils.isBlank(fileName)) {
			return JSONResult.failCreate(JSONResult.INSERT_FAIL,JSONResult.INSERT_FAIL).toJSON();
		}
		if(categoryId == null ) {
			return JSONResult.failCreate(JSONResult.INSERT_FAIL,JSONResult.INSERT_FAIL).toJSON();
		}
		if(StringUtils.isBlank(name)) {
			name = fileName;
		}
		if(StringUtils.isBlank(desc)) {
			desc = "点击修改备注";
		}
		//路径
		String recordPath = categoryId+SLASH+fileName;
		//状态
		Integer status = Status.NORMAL;
		// 访问量
		Integer hitQuantity = Status.HITQUANTITY;
		// 新增一条数据
		videoService.insertVideoUpdateCategory(categoryId,vipId,accountId,name, recordPath, hitQuantity,status, desc);
		/*Integer quantity = videoService.searchCount(null, categoryId, null);
		categoryService.updateCategory(categoryId, null, quantity++, null, null);*/
		return JSONResult.create("上传成功").toJSON();
	}
	
	/**
	 * 编辑
	 * @param id
	 * @param type
	 * @param name
	 * @param hitQuantity
	 * @param status
	 * @param desc
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateVideo")
	public String updateVideo(Integer id,Integer categoryId,String name,Integer hitQuantity,Integer status,String desc) {
		if(id < 1) {
			return JSONResult.failCreate(JSONResult.UPDATE_FAIL,JSONResult.ERROR_PARAMS).toJSON();
		}
		videoService.updateVideo(id, categoryId, name, hitQuantity, status, desc);
		return JSONResult.create("编辑成功").toJSON();
	}
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/searchById")
	public String searchById(Integer id) {
		if(null == id || id < 1) {
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_PARAMS).toJSON();
		}
		Video video = videoService.searchById(id);
		return JSONResult.create(video).toJSON();
	}
	
    /**
	 * 查询每个分类的N条数据
	 * @return
	 */
    @ResponseBody
    @RequestMapping("/searchByCategoryIdGroup")
    public String searchByCategoryIdGroup() {
    	List<List<Video>> dataVideo = new ArrayList<List<Video>>();
    	List<Video> type_1 = new ArrayList<Video>();
    	List<Video> type_2 = new ArrayList<Video>();
    	List<Video> type_3 = new ArrayList<Video>();
    	List<Video> type_4 = new ArrayList<Video>();
    	List<Video> type_5 = new ArrayList<Video>();
    	List<Video> type_6 = new ArrayList<Video>();
    	List<Video> type_7 = new ArrayList<Video>();
    	List<Video> videos = videoService.searchByCategoryIdGroup(Contants.SEAR_TYPE_SIZE);
    	String path =PropertiesUtil.getValue("video.path");
    	if( null == videos || videos.size() < 1) {
    		return JSONResult.noDataCreate().getMsg();
    	}
    	for (Video video : videos) {
			video.setRecordPath(path+video.getRecordPath());
			Integer type = video.getCategoryId();
			switch(type) {
				case 1:type_1.add(video);break;
				case 2:type_2.add(video);break;
				case 3:type_3.add(video);break;
				case 4:type_4.add(video);break;
				case 5:type_5.add(video);break;
				case 6:type_6.add(video);break;
				case 7:type_7.add(video);break;
				default:break;	
			}
		}
    	dataVideo.add(type_1);
    	dataVideo.add(type_2);
    	dataVideo.add(type_3);
    	dataVideo.add(type_4);
    	dataVideo.add(type_5);
    	dataVideo.add(type_6);
    	dataVideo.add(type_7);
    	return JSONResult.create(dataVideo).toJSON();
    }
    @ResponseBody
    @RequestMapping("/initSolr")
    public String init() throws Exception {
    	try {
			videoService.Initialization();
			return JSONResult.create("初始化成功...").toJSON();
		} catch (Exception e) {
			return JSONResult.failCreate("初始化失败...", "").toJSON();
		}
    }
    @ResponseBody
    @RequestMapping("/solrPage")
    public String searchPage(Integer pageNo,String keywords) throws Exception {
    	if(pageNo < 1) {
			return JSONResult.failCreate(JSONResult.ERROR_SELECT,JSONResult.ERROR_SELECT).toJSON();
		}
    	Map<String, Object> map = videoService.searchPage(pageNo,Contants.SEAR_TYPE_SIZE, keywords);
		if(map.size() < 1) {
			return JSONResult.noDataCreate().toJSON();
		}
		Long totalCount = (Long)map.get("totalCount");
		Page page = PageUtil.getPage(pageNo, Contants.SEAR_TYPE_SIZE,totalCount.intValue(), (List)map.get("videos"));
		return JSONResult.create(page).toJSON();
    }
    
    
}
