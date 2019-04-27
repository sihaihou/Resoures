package com.reyco.core.service;

import com.reyco.core.domain.MessageMQ;

public interface MessageService {
	/**
	 *       查询
	 * @param id
	 * @return
	 */
	Integer countMessageById(Integer id);
	/**
	  *    新增message
	 * @param message   实体参数
	 */
	void insertMessage(MessageMQ message);
}