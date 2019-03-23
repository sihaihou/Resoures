package com.reyco.core.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.reyco.core.constant.Contants;
import com.reyco.core.dao.VideoDao;
import com.reyco.core.pojo.Video;
import com.reyco.core.service.CategoryService;
import com.reyco.core.service.VideoService;
import com.reyco.core.task.InitSolrTask;
import com.reyco.core.task.InsertVideoSolrTask;
import com.reyco.core.task.UpdateVideoSolrTask;
import com.reyco.core.util.DateUtil;
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
		new Thread(new InsertVideoSolrTask(video)).start();
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
		new Thread(new UpdateVideoSolrTask(video)).start();
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
	@Override
	public Map<String,Object> searchPage(Integer pageNo,Integer pageSize,String name) throws SolrServerException, IOException{
		Map<String,Object> map = new HashMap<String,Object>();
		SolrClient client = new HttpSolrClient("http://39.107.247.102:80/solr");
		SolrQuery params = new SolrQuery();
		if(StringUtils.isBlank(name)) {
			params.setQuery("video_keywords:*");
		}else {
			params.setQuery("video_keywords:"+name);
		}
		params.setStart(pageSize*(pageNo-1));
		params.setRows(pageSize);
		QueryResponse response = client.query(params);
		return getSolrVideoList(response);
	}
	/**
	 * 
	 * @param videoList
	 * @return
	 */
	private Map<String,Object> getSolrVideoList(QueryResponse response){
		SolrDocumentList videoList = response.getResults();
		Map<String,Object> map = new HashMap<String,Object>();
		List<Video> list = new ArrayList<Video>();
		String path =PropertiesUtil.getValue("video.path");
		for (SolrDocument solrDocument : videoList) {
			Video video = new Video();
			String fieldValue = (String)solrDocument.getFieldValue("id");
			Integer id = Integer.parseInt(fieldValue);
			video.setId(id);
			video.setName((String)solrDocument.getFieldValue("video_name"));
			video.setCategoryId((Integer)solrDocument.getFieldValue("video_categoryId"));
			video.setVipId((Integer)solrDocument.getFieldValue("video_vipId"));
			video.setAccountId((Integer)solrDocument.getFieldValue("video_accountId"));
			video.setRecordPath(path+(String)solrDocument.getFieldValue("video_recordPath"));
			video.setHitQuantity((Integer)solrDocument.getFieldValue("video_hitQuantity"));
			video.setStatus((Integer)solrDocument.getFieldValue("video_status"));
			video.setDesc((String)solrDocument.getFieldValue("video_desc"));
			video.setGmtCreate(DateUtil.parseDateTime((String)solrDocument.getFieldValue("video_gmtCreate")));
			video.setGmtModified(DateUtil.parseDateTime((String)solrDocument.getFieldValue("video_gmtModified")));
			list.add(video);
		}
		map.put("totalCount", videoList.getNumFound());
		map.put("videos", list);
		return map;
	}
	public static void main(String[] args) throws SolrServerException, IOException {
		VideoServiceImpl videoServiceImpl = new VideoServiceImpl();
		Map<String, Object> map = videoServiceImpl.searchPage(1,12,"周星驰");
		System.out.println(map);
	}
	@Override
	public void Initialization() throws SolrServerException, IOException {
		List<Video> videos = videoDao.searchAll();
		saveVideoSolr(videos);
	}
	/**
	 * 
	 * @param list
	 */
	public void saveVideoSolr(List<Video> list) {
		// 数据集合大小
		int listSize = list.size();
		// 一个线程处理多少条数据,默认333
		int count = getEachTaskCount(listSize);
		// 开启的线程数
		int runThreadSize  = (listSize / count) + 1;   
		// 存放每个线程的执行数据
		//List<Video> newList = null;
		// 创建一个线程池,数量和开启线程的数量一样
	    ExecutorService executor = Executors.newFixedThreadPool(runThreadSize);
	    // 门闩
	    CountDownLatch latch = new CountDownLatch(runThreadSize);
	    long start = System.currentTimeMillis();
        // 循环创建线程
        for (int i=0;i<runThreadSize;i++) {
        	List<Video> newList = getEachTaskStartAndEnd(runThreadSize,count,list,i);
        	try {
				executor.execute(new InitSolrTask(newList));
				latch.countDown();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        long end = System.currentTimeMillis();
        System.out.println("###############################end-start......."+(end-start));
	}
	/**
	 * 获取每个任务的执行数据(开始和结束)
	 * @param runThreadSize  执行线程数
	 * @param count          每个任务的执行数量
	 * @param list           源数据集
	 * @param i              i
	 * @return
	 */
	private List getEachTaskStartAndEnd(Integer runThreadSize,Integer count,List list,Integer i ) {
		// 存放每个线程的执行数据
		List<Video> newList = null;
		if ((i + 1) == runThreadSize) {
            int startIndex = (i * count);
            int endIndex = list.size();
            newList = list.subList(startIndex, endIndex);
        } else {
            int startIndex = (i * count);
            int endIndex = ((i + 1) * count);
            newList = list.subList(startIndex, endIndex);
        }
		return newList;
	}
	/**
	 * 根据任务的大小,获取每个任务的执行数量
	 * @param size   数据集合的大小  
	 * @return
	 */
	private Integer getEachTaskCount(Integer size) {
		// 一个线程处理多少条数据,默认333
		Integer count =333; 
		// 根据数据量确定一个线程处理多少条数据
		if( size >= 1 && size < 100) {
			count = 33;
		}else if(size >= 100 && size < 500) {
			count = 53;
		}else if(size >= 500 && size < 1000) {
			count = 133;
		}else if(size >= 1000 && size < 10000) {
			count = 333;
		}else if(size >= 10000) {
			count = 1333;
		}
		return count;
	}
}