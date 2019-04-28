package com.hs.core;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler {
	public static void main(String[] args) throws SchedulerException {
		// 创建一个JobDetail
		JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("helloDetailJob","helloDetailGroup")
				.usingJobData("detailMsg","helloDetailMsg").usingJobData("detailDouble",2.0D)
				.build();
		// 创建一个Trigger
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("helloTriggerJob","helloTriggerGroup")
						.usingJobData("triggerMsg", "helloTriggerMsg").usingJobData("triggerFloat", 3.0F)
						.startNow().withSchedule(SimpleScheduleBuilder.simpleSchedule().
						withIntervalInSeconds(10).repeatForever()).build();
		// 创建SchedulerFactory
		SchedulerFactory sf = new StdSchedulerFactory();
		// 创建Scheduler
		Scheduler scheduler = sf.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail,trigger);
	}
}
