package com.hs.event;

import com.hs.listenerable.Listenerable;

/**
 * �¼��ӿ�
 * @author Administrator
 *
 */
public interface Event {
	String INSERT = "insert";
	String DELETE = "delete";
	String UPDATE = "update";
	String SELECT = "select";
	/**
	 * ��ȡ�¼�Դ
	 * @return
	 */
	Listenerable getListenerable();
	/**
	 * ��ȡ�¼�����
	 * @return
	 */
	String getEventType();
}
