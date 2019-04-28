package com.hs.core;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

public class HelloJob implements Job{
	private String detailMsg;
	private float detailDouble;
	private String triggerMsg;
	private float triggerFloat;
	
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobKey jobKey = context.getJobDetail().getKey();
		System.out.println("jobName=="+jobKey.getName()+"-------jobGroup=="+jobKey.getGroup());
		
		TriggerKey triggerKey = context.getTrigger().getKey();
		System.out.println("triggerName=="+triggerKey.getName()+"-------triggerGroup=="+triggerKey.getGroup());
		
		JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();
		String detailMsg = jobDataMap.getString("detailMsg");
		double detailDouble = jobDataMap.getDouble("detailDouble");
		System.out.println("detailMsg=="+detailMsg+"----------detailDouble=="+detailDouble);
		
		//通过setting/getting获取参数
		System.out.println("detailMsg=="+detailMsg+"----------detailDouble=="+detailDouble+";triggerMsg=="+triggerMsg+"----------triggerFloat=="+triggerFloat);
	}
	public String getDetailMsg() {
		return detailMsg;
	}
	public void setDetailMsg(String detailMsg) {
		this.detailMsg = detailMsg;
	}
	public float getDetailDouble() {
		return detailDouble;
	}
	public void setDetailDouble(float detailDouble) {
		this.detailDouble = detailDouble;
	}
	public String getTriggerMsg() {
		return triggerMsg;
	}
	public void setTriggerMsg(String triggerMsg) {
		this.triggerMsg = triggerMsg;
	}
	public float getTriggerFloat() {
		return triggerFloat;
	}
	public void setTriggerFloat(float triggerFloat) {
		this.triggerFloat = triggerFloat;
	}
}
