package com.reyco.core.service;

import java.util.List;

import com.reyco.core.domain.MessageMQ;
/**
 * messageService
 * @author reyco
 *
 */
public interface MessageService {
	/**
	  *     新增message
	 * @param message   实体参数
	 */
	void insertMessage(MessageMQ message);
	/**
	  *      查询
	 * @param id
	 * @return
	 */
	MessageMQ getMessageById(Integer id);
	/**
	  *      扫描未确认的消息
	 * @return
	 */
	List<MessageMQ> listMessageByStatus();
	/**
	  *      修改状态
	 * @param id
	 * @param status
	 */
	void updateStatusById(String param);
}
