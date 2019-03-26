package com.reyco.core.task;

import java.util.List;

import com.reyco.core.pojo.Video;
import com.reyco.core.service.impl.VideoSolrImpl;

/**
 * 初始化Solr任务
 * @author reyco
 *
 */
public class InitVideoSolrTask implements Runnable {
	
	private List<Video> list;

	public InitVideoSolrTask(List<Video> list) {
		super();
		this.list = list;
	}

	@Override
	public void run() {
		try {
			VideoSolrImpl videoSolrImpl = new VideoSolrImpl();
			videoSolrImpl.initSolr(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
