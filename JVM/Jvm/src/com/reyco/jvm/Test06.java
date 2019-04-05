package com.reyco.jvm;

import java.util.HashMap;
import java.util.Map;

public class Test06 {
	
	public static void main(String[] args) {
		/**
		 * 测试进入老年代的对象
		 */
		//-Xms100m -Xmx100m -XX:+UseSerialGC -XX:MaxTenuringThreshold=15 -XX:+PrintGCDetails
		Map<String,byte[]> map = new HashMap<String,byte[]>();
		for(int i=0;i<5;i++) {
			byte[] b = new byte[1024*1024];
			map.put("i",b );
		}
		for(int i=0;i<10;i++) {
			for(int j=0;j<100;j++) {
				byte[] b = new byte[1024*1024];
			}
		}
		
		
	}
}
