package com.reyco.jvm;

public class Test03 {
	
	public static void main(String[] args) {
		//配置一：  XX:SurvivorRatio:  eden/s0
		//  -Xms20m -Xmx20m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
		
		//配置二： 
		//  -Xms20m -Xmx20m -Xmn7m -XX:SurvivorRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
		
		//配置三： XX:NewRatio： 老年代/新生代
		//  -Xms20m -XX:NewRatio=2 -XX:+PrintGCDetails -XX:+UseSerialGC
		for(int i=0;i<10;i++) {
			Byte[] b = new Byte[1*1024*1024];
		}
	}
}
