package com.reyco.jvm;

public class Test04 {
	public static void main(String[] args) {
		/**
		 * 内存溢出
		 *    -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d:/dump.dump  
		 */
		Byte[] b =null;
		for (int i = 0; i < 10; i++) {
			b = new Byte[1*1024*1024];
		}
		
		
	}
}
