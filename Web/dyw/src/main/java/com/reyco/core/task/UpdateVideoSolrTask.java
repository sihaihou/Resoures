package com.reyco.core.task;

import com.reyco.core.pojo.Video;
import com.reyco.core.service.impl.VideoSolrImpl;
/**
 * 更新Solr数据任务
 * @author reyco
 *
 */
public class UpdateVideoSolrTask implements Runnable{
	
	private Video video;
	
	public UpdateVideoSolrTask(Video video) {
		super();
		this.video = video;
	}
	@Override
	public void run() {
		try {
			VideoSolrImpl videoSolrImpl = new VideoSolrImpl();
			videoSolrImpl.updateVideoSolr(video);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
