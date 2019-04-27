package com.reyco.core.quartz;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.reyco.core.domain.MessageMQ;
import com.reyco.core.service.MessageService;
import com.reyco.core.service.QueueProducerService;
import com.reyco.core.task.MessageTask;

/**
  *         定时扫描消息发送失败的消息
  *         重发失败消息
 * @author reyco
 *
 */
public class MessageScheduledJob extends QuartzJobBean {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * messageService
	 */
	private MessageService messageService;
	/**
	 * MQ queueService
	 */
	private QueueProducerService queueProducerService;
	
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}
	public void setQueueProducerService(QueueProducerService queueProducerService) {
		this.queueProducerService = queueProducerService;
	}
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("###################定时任务被执行啦################");
		List<MessageMQ> messages = messageService.listMessageByStatus();
		if(messages.size() < 1) {
			logger.info("###################没有发送失败的消息################");
			return;
		}
		// 
		MessageTask task = new MessageTask();
		task.setMessages(messages);
		task.setQueueProducerService(queueProducerService);
		task.run();
	}
	
	
	
	
	
	
}
