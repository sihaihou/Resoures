package com.hs.core;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler4 {
	public static void main(String[] args) throws SchedulerException {
		// 创建一个JobDetail
		JobDetail jobDetail = JobBuilder.newJob(HelloJob4.class)
				.withIdentity("helloDetailJob","helloDetailGroup")
				.build();
		// Cron表达式：  秒 分 时 日 月 周 年
		// 2018年每天10点15分执行：  0 15 10 ? * * 2017
		// 每天的14点整到14:59:59秒，以及18点整到18:59:59秒，每隔5秒执行一次： 0/5 14,18 * * * ？ 
		CronTrigger trigger = (CronTrigger)TriggerBuilder.newTrigger()
						.withSchedule(CronScheduleBuilder.cronSchedule("1/3 * * * * ? *"))
						.build();
		// 创建SchedulerFactory
		SchedulerFactory sf = new StdSchedulerFactory();
		// 创建Scheduler
		Scheduler scheduler = sf.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail,trigger);
	}
}
