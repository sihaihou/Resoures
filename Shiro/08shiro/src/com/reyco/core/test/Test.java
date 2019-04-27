package com.reyco.core.test;

public class Test {
	public static void test(String str) {
		String src = 1+str.substring(str.lastIndexOf("."));
		System.out.println(src);
	}
	public static void main(String[] args) {
		test("1.2.3.mp4");
	}
}
