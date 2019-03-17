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
	/*@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		Date date = new Date();
		Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String gmtExpire = format.format(date);
		logger.error(gmtExpire);
		List<Integer> ids = studentService.searchIdByStatusAndGmtExpire(gmtExpire);
		if(null != ids && ids.size()>=1) {
			for (Integer id : ids) {
				studentService.updateStatus(id);
				logger.error(gmtExpire);
				logger.error("student的id==="+id+"/t服务到期关闭成功！");
			}
		}else {
			logger.error(gmtExpire+"服务没有到期");
		}
	}*/
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
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
		System.out.println("baseService===="+baseService);
	}
}
