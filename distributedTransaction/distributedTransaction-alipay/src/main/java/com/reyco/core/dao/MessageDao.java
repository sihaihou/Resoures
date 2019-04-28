package com.reyco.core.dao;

import java.util.List;

import com.reyco.core.domain.MessageMQ;

public interface MessageDao {
	/**
	  *     新增message
	 * @param message   实体参数
	 */
	void insertMessage(MessageMQ message);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	MessageMQ getMessageById(Integer id);
	/**
	 * 扫描未确认的消息
	 * @return
	 */
	List<MessageMQ> listMessageByStatus();
	/**
	 * 修改状态
	 * @param id
	 * @param status
	 */
	void updateStatusById(MessageMQ message);
}
