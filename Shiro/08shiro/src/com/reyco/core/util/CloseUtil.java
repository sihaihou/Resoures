package com.reyco.core.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭方法
 * @author sihai.hou
 *
 */
public class CloseUtil {
	
	/**
	 * �رշ���
	 * @param close
	 */
	public static void close( Closeable... close) {
		for (Closeable closeable : close) {
			if(null != closeable) {
				try {
					closeable.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
}
