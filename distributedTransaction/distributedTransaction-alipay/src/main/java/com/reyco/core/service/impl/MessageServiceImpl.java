package com.reyco.core.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reyco.core.dao.MessageDao;
import com.reyco.core.domain.MessageMQ;
import com.reyco.core.service.MessageService;

/**
 * messageService业务层
 * 
 * @author reyco
 *
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private MessageDao messageDao;

	@Override
	public void insertMessage(MessageMQ message) {
		messageDao.insertMessage(message);
	}

	@Transactional(rollbackFor = RuntimeException.class)
	@Override
	public void updateStatusById(String param) {
		try {
			// JSONObject jsonObject = JSONObject.parseObject(param);
			// String messageId = jsonObject.getString("messageId");
			// String respCode = jsonObject.getString("respCode");
			logger.info("############支付宝收到回调参数##########"+param);
			Integer id = Integer.parseInt(param);
			MessageMQ message = this.getMessageById(id);
			logger.info("############支付宝根据根据回调参数查询消息##########"+message);
			Integer search_id = message.getId();
			if (id.equals(search_id)) {
				Integer search_status = message.getStatus();
				if(search_status==1) {
					Integer status = 0;
					message.setStatus(status);
					logger.info("############支付宝根据根据回调修改消息状态##########"+message);
					messageDao.updateStatusById(message);
					logger.info("############支付宝消息已更新确认状态##########"+message);
				}
			}
		} catch (Exception e) {
			logger.error("############消息更新失败############。。。"+param);
			throw e;
		}
	}

	@Override
	public MessageMQ getMessageById(Integer id) {
		return messageDao.getMessageById(id);
	}
	
	@Override
	public List<MessageMQ> listMessageByStatus() {
		return messageDao.listMessageByStatus();
	}

}
