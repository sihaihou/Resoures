package com.reyco.core.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.reyco.core.dao.CategoryDao;
import com.reyco.core.dao.VideoDao;
import com.reyco.core.pojo.Video;
import com.reyco.core.service.CategoryService;
import com.reyco.core.service.VideoService;
import com.reyco.core.util.JSONResult;
import com.reyco.core.util.PageUtil;
import com.reyco.core.util.PropertiesUtil;

@SuppressWarnings("all")
@Service("videoService")
public class VideoServiceImpl implements VideoService {

	@Autowired
	private VideoDao videoDao;
	@Autowired
	private CategoryService categoryService;

	@Override
	public List<Video> searchPage(Integer pageNo,Integer status,String name,Integer categoryId,Integer accountId) {
		Video v = new Video(categoryId,accountId,name,status);
		PageHelper.startPage(pageNo,PageUtil.PAGESIZE);
		List<Video> list = videoDao.searchPage(v);
		String path =PropertiesUtil.getValue("video.path");
		for (Video video : list) {
			video.setRecordPath(path+video.getRecordPath());
			video.setStatus_info(getStatusInfo(video.getStatus()));
		}
		return list;
	}
	/**
	 * 根据状态值获取状态消息
	 * @param status
	 * @return
	 */
	private String getStatusInfo(Integer status) {
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(0, "正常");
		map.put(1, "已删除");
		map.put(2, "待审核");
		return map.get(status);
	}
	/**
	 * video单独新增
	 */
	private void insertVideo(Integer categoryId,Integer vipId,Integer accountId, String name, String recordPath, Integer hitQuantity,Integer status, String desc) {
		Video video = new Video(categoryId,vipId,accountId,name,recordPath,hitQuantity,status,desc);
		videoDao.insertVideo(video);
	}
	/**
	 * video新增+category更新
	 */
	@Override
	public void insertVideoUpdateCategory(Integer categoryId,Integer vipId,Integer accountId, String name, String recordPath, Integer hitQuantity,Integer status, String desc) {
		insertVideo(categoryId, vipId,accountId,name, recordPath, hitQuantity,status,desc);
		Integer quantity = searchCount(null, categoryId, null);
		Integer activeQuantity = searchCount(0, categoryId, null);
		categoryService.updateCategory(categoryId, null,activeQuantity++,quantity++, null, null);
	}
	/**
	 * 编辑
	 */
	@Override
	public void updateVideo(Integer id, Integer categoryId, String name,Integer hitQuantity,Integer status, String desc) {
		Video video = new Video(id,categoryId,name,hitQuantity,status,desc);
		videoDao.updateVideo(video);
		if(null != status) {
			if(1==status) {
				//删除文件-----暂时不删除,采用定时任务删除文件
				//deleteVideo(id);
				Integer activeQuantity = searchCount(0, categoryId, null);
				categoryService.updateCategory(categoryId, null, activeQuantity,null, null, null);
			}
		}
	}
	 /**
     * 删除音频文件 (time.mp4)
     * @param id     音频的 id
     */
    private void deleteVideo(Integer id) {
    	String videoPath = PropertiesUtil.getValue("fileupload.path");
    	if(null != id && !StringUtils.isBlank(videoPath)) {
             Video video = searchById(id);
             if(null !=video) {
            	 String recordPath = video.getRecordPath();
            	 if (!StringUtils.isBlank(recordPath)) {
                     String videoFileName = videoPath + recordPath;
                     String[] fileName = {videoFileName};
                     deleteFile(fileName);
                 }
             }
    	}
    }
    /**
     * 删除文件
     * @param src 文件全路径数组
     */
    private void deleteFile(String[] src){
    	for (String fileName : src) {
			File file = new File(fileName);
			if (file.exists() && file.isFile()) {
				file.delete();
            }
		}
    }
	/**
	 * 根据id查询
	 */
	@Override
	public Video searchById(Integer id) {
		return videoDao.searchById(id);
	}

	@Override
	public List<Video> searchByCategoryIdGroup(Integer count) {
		return videoDao.searchByCategoryIdGroup(count);
	}

	@Override
	public Integer searchCount(Integer status, Integer categoryId, Integer accountId) {
		Video video = new Video(categoryId,accountId,status);
		return videoDao.searchCount(video);
	}
}
