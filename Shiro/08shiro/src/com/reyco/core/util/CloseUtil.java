package com.reyco.core.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * 鍏抽棴鏂规硶
 * @author sihai.hou
 *
 */
public class CloseUtil {
	
	/**
	 * 关闭方法
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
