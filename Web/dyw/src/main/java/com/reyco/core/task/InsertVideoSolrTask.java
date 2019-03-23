package com.reyco.core.task;

import com.reyco.core.pojo.Video;
import com.reyco.core.service.impl.VideoSolrImpl;

public class InsertVideoSolrTask implements Runnable{
	
	private Video video;
	
	public InsertVideoSolrTask(Video video) {
		super();
		this.video = video;
	}

	@Override
	public void run() {
		try {
			VideoSolrImpl videoSolrImpl = new VideoSolrImpl();
			videoSolrImpl.insertVideoToSolr(video);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
