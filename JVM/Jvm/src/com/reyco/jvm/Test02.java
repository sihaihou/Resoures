package com.reyco.jvm;

public class Test02 {
	public static void main(String[] args) {
		
		Byte[] b =  new Byte[1*1024*1024];
		String str1= "aaa";
		System.out.println("max---"+Runtime.getRuntime().maxMemory());
		System.out.println("max---"+Runtime.getRuntime().freeMemory());
		System.out.println("max---"+Runtime.getRuntime().totalMemory());
		Byte[] c =  new Byte[1*1024*1024];
		String str2= "aaa";
		System.out.println("max---"+Runtime.getRuntime().maxMemory());
		System.out.println("max---"+Runtime.getRuntime().freeMemory());
		System.out.println("max---"+Runtime.getRuntime().totalMemory());
	}
}
