package com.reyco.core.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.AbstractUpdateRequest.ACTION;
import org.apache.solr.client.solrj.request.UpdateRequest;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;

import com.reyco.core.pojo.Video;
import com.reyco.core.service.SolrService;
import com.reyco.core.util.DateUtil;

public class VideoSolrImpl implements SolrService<Video>{
	
	private SolrClient solrClient;
	
	public VideoSolrImpl() {
		super();
		this.solrClient = new HttpSolrClient("http://ip:80/solr");
	}
	@Override
	public SolrInputDocument getSolrInputDocumentByVideo(Video video) {
		SolrInputDocument doc = new SolrInputDocument();
		doc.setField("id", video.getId().toString());
		doc.setField("video_name", video.getName());
		doc.setField("video_categoryId",video.getCategoryId().toString());
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
	@Override
	public void insertVideoToSolr(Video video) {
		try {
			SolrInputDocument doc = getSolrInputDocumentByVideo(video);
			solrClient.add(doc);
			solrClient.commit();
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}finally {
			try {
				solrClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void insertListToSolr(List<Video> list) {
		for (Video video : list) {
			try {
				SolrInputDocument doc = getSolrInputDocumentByVideo(video);
				solrClient.add(doc);
			} catch (SolrServerException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			solrClient.commit();
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
		}finally {
			try {
				solrClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 初始化Solr
	 * @param list
	 */
	@Override
	public void initSolr(List<Video> list) {
		try {
			solrClient.deleteByQuery("*:*");
			solrClient.commit();
		} catch (SolrServerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		insertListToSolr(list);
	}
	@Override
	public List<Video> addVideoToList(Video video) {
		List<Video> list = new ArrayList<Video>();
		list.add(video);
		return list;
	}
	@Override
	public void updateVideoSolr(Video video) {
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
		UpdateRequest request = new UpdateRequest();
		request.setAction(ACTION.COMMIT, false, false);
		request.add(doc);
		try {
			UpdateResponse resp = request.process(solrClient);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}