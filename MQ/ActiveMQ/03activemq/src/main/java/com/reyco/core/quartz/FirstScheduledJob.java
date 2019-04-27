package com.reyco.core.quartz;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.reyco.core.service.BaseService;

public class FirstScheduledJob extends QuartzJobBean {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private BaseService baseService;
	public BaseService getBaseService() {
		return baseService;
	}
	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		Format format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String formatDate = format.format(date);
		logger.info("#############################定时任务被执行啦"+formatDate);
	}
}
