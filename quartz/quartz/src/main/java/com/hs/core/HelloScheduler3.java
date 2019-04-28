package com.hs.core;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler3 {
	public static void main(String[] args) throws SchedulerException {
		Date date = new Date();
		Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(date));
		date.setTime(date.getTime()+4000);
		// 创建一个JobDetail
		JobDetail jobDetail = JobBuilder.newJob(HelloJob3.class)
				.withIdentity("helloDetailJob","helloDetailGroup")
				.build();
		// 创建一个Trigger,距离当前时间4秒钟之后执行且仅执行一次任务
		SimpleTrigger trigger = (SimpleTrigger)TriggerBuilder.newTrigger()
						.startAt(date)
						.build();
		// 创建SchedulerFactory
		SchedulerFactory sf = new StdSchedulerFactory();
		// 创建Scheduler
		Scheduler scheduler = sf.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail,trigger);
	}
}
