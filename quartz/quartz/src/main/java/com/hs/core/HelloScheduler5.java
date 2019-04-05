package com.hs.core;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class HelloScheduler5 {
	public static void main(String[] args) throws Exception {
		// 创建一个JobDetail
		JobDetail jobDetail = JobBuilder.newJob(HelloJob5.class)
				.withIdentity("helloDetailJob","helloDetailGroup")
				.build();
		//Cron表达式：  秒 分 时 日 月 周 年
		CronTrigger trigger = (CronTrigger)TriggerBuilder.newTrigger()
						.withSchedule(CronScheduleBuilder.cronSchedule("* * * * * ? *"))
						.build();
		// 创建SchedulerFactory
		SchedulerFactory sf = new StdSchedulerFactory();
		// 创建Scheduler
		Scheduler scheduler = sf.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail,trigger );
		//执行5秒钟后挂起：暂时不执行，可以再次开启的
		Thread.sleep(5000);
		scheduler.standby();
		
		// scheduler挂起5秒钟后重新启动
		Thread.sleep(5000);
		scheduler.start();
		// 关闭 
		// scheduler.shutdown(true):表示等待所有正在执行的job执行完毕之后，再关闭scheduler
		// scheduler.shutdown(false):直接关闭
		//scheduler.shutdown(true);
	}
}
