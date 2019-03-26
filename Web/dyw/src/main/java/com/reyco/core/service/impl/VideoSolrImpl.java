package com.reyco.core.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.AbstractUpdateRequest.ACTION;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import com.reyco.core.pojo.Video;
import com.reyco.core.service.VideoSolrService;
import com.reyco.core.util.DateUtil;
import com.reyco.core.util.PropertiesUtil;

public class VideoSolrImpl implements VideoSolrService<Video> {

	private SolrClient solrClient;

	public VideoSolrImpl() {
		super();
		this.solrClient = new HttpSolrClient("http://ip:port/solr");
	}

	@Override
	public SolrInputDocument getSolrInputDocument(Video video) {
		SolrInputDocument doc = new SolrInputDocument();
		doc.setField("id", video.getId().toString());
		doc.setField("video_name", video.getName());
		doc.setField("video_categoryId", video.getCategoryId().toString());
		doc.setField("video_vipId", video.getVipId().toString());
		doc.setField("video_accountId", video.getAccountId().toString());
		doc.setField("video_recordPath", video.getRecordPath());
		doc.setField("video_hitQuantity", video.getHitQuantity().toString());
		doc.setField("video_status", video.getStatus().toString());
		doc.setField("video_desc", video.getDesc());
		doc.setField("video_gmtCreate", DateUtil.formatDateTime(video.getGmtCreate()));
		doc.setField("video_gmtModified", DateUtil.formatDateTime(video.getGmtModified()));
		return doc;
	}
	/**
	 * 将video对象封装SolrInputDocument
	 * @param video
	 * @return
	 */
	public SolrInputDocument getVideoSolrInputDocument(Video video) {
		return getSolrInputDocument(video);
	}
	/**
	 * 单条数据添加到Solr
	 * @param video
	 */
	public void insertSolr(Video video) {
		// 将Video对象加入List集合
		List<Video> list = addVideoToList(video);
		BatchInsertSolr(list);
	}
	/**
	 * 单条数据添加到Solr
	 * @param video
	 */
	public void insertVideoSolr(Video video) {
		try {
			SolrInputDocument doc = getSolrInputDocument(video);
			solrClient.add(doc);
			solrClient.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			// 关闭流
			if (null != solrClient) {
				try {
					solrClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void BatchInsertSolr(List<Video> list) {
		try {
			for (Video video : list) {
				SolrInputDocument doc = getSolrInputDocument(video);
				solrClient.add(doc);
			}
			solrClient.commit();
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭流
			if (null != solrClient) {
				try {
					solrClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 批量新增Video到Solr
	 * @param list
	 */
	public void BatchInsertVideoSolr(List<Video> list) {
		BatchInsertSolr(list);
	}
	/**
	 * 初始化Solr
	 * 
	 * @param list
	 */
	@Override
	public void initSolr(List<Video> list) {
		try {
			// 删除Solr所有数据
			solrClient.deleteByQuery("*:*");
			solrClient.commit();
			// 数据初始化
			BatchInsertSolr(list);
		} catch (SolrServerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	/**
	 * 初始化Solr----video
	 * @param list
	 */
	public void initVideoSolr(List<Video> list) {
		initSolr(list);
	}
	@Override
	public List<Video> addVideoToList(Video video) {
		List<Video> list = new ArrayList<Video>();
		list.add(video);
		return list;
	}
	@Override
	public void updateSolr(Video video) {
		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", video.getId());
		doc.addField("video_name", video.getName());
		doc.addField("video_categoryId", video.getCategoryId());
		doc.addField("video_vipId", video.getVipId());
		doc.addField("video_accountId", video.getAccountId());
		doc.addField("video_recordPath", video.getRecordPath());
		doc.addField("video_hitQuantity", video.getHitQuantity());
		doc.addField("video_status", video.getStatus());
		doc.addField("video_desc", video.getDesc());
		doc.addField("video_gmtCreate", video.getGmtCreate());
		doc.addField("video_gmtModified", video.getGmtModified());
		try {
			UpdateRequest request = new UpdateRequest();
			request.setAction(ACTION.COMMIT, false, false);
			request.add(doc);
			UpdateResponse resp = request.process(solrClient);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 更新Video数据
	 * @param video
	 */
	public void updateVideoSolr(Video video) {
		updateSolr(video);
	}
	
	@Override
	public Map searchSolr(Integer pageNo, Integer pageSize, String keywords) {
		Map<String,Object> map = new HashMap<String,Object>();
		SolrQuery params = new SolrQuery();
		if(StringUtils.isBlank(keywords)) {
			params.setQuery("video_keywords:*");
		}else {
			params.setQuery("video_keywords:"+keywords);
		}
		params.setStart(pageSize*(pageNo-1));
		params.setRows(pageSize);
		//开启高亮显示
		params.setHighlight(true);
		params.addHighlightField("video_name");
		params.setHighlightSimplePre("<span style='color:red'>");
		params.setHighlightSimplePost("</span>");
		try {
			QueryResponse response = solrClient.query(params);
			return getSolrVideoList(response);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * @param videoList
	 * @return
	 */
	private Map<String,Object> getSolrVideoList(QueryResponse response){
		// 未高亮内容
		SolrDocumentList videoList = response.getResults();
		// 高亮内容
		Map<String, Map<String, List<String>>> hh = response.getHighlighting();
		Map<String,Object> map = new HashMap<String,Object>();
		List<Video> list = new ArrayList<Video>();
		String path =PropertiesUtil.getValue("video.path");
		for (SolrDocument solrDocument : videoList) {
			Video video = new Video();
			String fieldValue = (String)solrDocument.getFieldValue("id");
			Integer id = Integer.parseInt(fieldValue);
			video.setId(id);
			List<String> hhList = hh.get(solrDocument.getFieldValue("id")).get("video_name");
			if(null != hhList && hhList.size()>0) {
				video.setName(hhList.get(0));
			}else {
				video.setName(solrDocument.getFieldValue("video_name").toString());
			}
			video.setCategoryId((Integer)solrDocument.getFieldValue("video_categoryId"));
			video.setVipId((Integer)solrDocument.getFieldValue("video_vipId"));
			video.setAccountId((Integer)solrDocument.getFieldValue("video_accountId"));
			video.setRecordPath(path+solrDocument.getFieldValue("video_recordPath").toString());
			video.setHitQuantity((Integer)solrDocument.getFieldValue("video_hitQuantity"));
			video.setStatus((Integer)solrDocument.getFieldValue("video_status"));
			video.setDesc(solrDocument.getFieldValue("video_desc").toString());
			video.setGmtCreate(DateUtil.parseDateTime(solrDocument.getFieldValue("video_gmtCreate").toString()));
			video.setGmtModified(DateUtil.parseDateTime(solrDocument.getFieldValue("video_gmtModified").toString()));
			list.add(video);
		}
		map.put("totalCount", videoList.getNumFound());
		map.put("videos", list);
		return map;
	}
	
}