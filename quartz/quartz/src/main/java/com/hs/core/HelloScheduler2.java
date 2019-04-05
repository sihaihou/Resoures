package com.hs.core;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler2 {
	public static void main(String[] args) throws SchedulerException {
		Date date = new Date();
		Format format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(format.format(date));
		// 创建一个JobDetail
		JobDetail jobDetail = JobBuilder.newJob(HelloJob2.class).withIdentity("helloDetailJob","helloDetailGroup")
				.build();
		Date startDate = new Date();
		startDate.setTime(startDate.getTime()+3000);
		Date endDate = new Date();
		endDate.setTime(startDate.getTime()+6000);
		// 创建一个Trigger
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("helloTriggerJob","helloTriggerGroup")
				        // 设置多少秒后首次执行
						.startAt(startDate)
						// 设置多少秒后停止执行
						.endAt(endDate)
						// 每个2秒钟执行一次,且只执行3次
						.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(3))
						.build();
		// 创建SchedulerFactory
		SchedulerFactory sf = new StdSchedulerFactory();
		// 创建Scheduler
		Scheduler scheduler = sf.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail,trigger);
	}
}
