package com.reyco.core.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.reyco.core.service.PermissionService;

public class FirstScheduledJob extends QuartzJobBean {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private PermissionService baseService;
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
				logger.error("student��id==="+id+"/t�����ڹرճɹ���");
			}
		}else {
			logger.error(gmtExpire+"����û�е���");
		}
	}*/
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	public PermissionService getBaseService() {
		return baseService;
	}
	public void setBaseService(PermissionService baseService) {
		this.baseService = baseService;
	}
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		logger.error("#############################��ʱ����ִ����");
		
	}
}
