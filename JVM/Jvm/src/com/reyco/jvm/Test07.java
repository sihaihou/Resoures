package com.reyco.jvm;

import java.util.HashMap;
import java.util.Map;

public class Test07 {
	public static void main(String[] args) {
		/**
		 * 测试
		 */
		//   -Xms10m -Xmx10m -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1000
		// 这种现象原因：虚拟机对应体积不大的对象会优先把数据分配到TLAB区域中，因此就失去了在老年代分配的机会
		//   -Xms10m -Xmx10m -XX:+UseSerialGC -XX:+PrintGCDetails -XX:PretenureSizeThreshold=1000 -XX:-UseTLAB
		Map<Integer,byte[]> map = new HashMap<Integer,byte[]>();
		for(int i=0;i<5*1024;i++) {
			byte[] b = new byte[1024];
			map.put(i, b);
		}
	}
}
