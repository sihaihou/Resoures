package com.hs.core;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Trigger;

public class HelloJob2 implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Trigger trigger = context.getTrigger();
		System.out.println("startTime==="+format.format(trigger.getStartTime())+"----endTime==="+format.format(trigger.getEndTime()));
	}
}
