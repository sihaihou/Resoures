package com.reyco.jvm;
/**
 *   Exception in thread "main" java.lang.StackOverflowError
 * @author reyco
 *
 */
public class Test05 {
	//-Xss2m
	/**
	 * 栈调用次数
	 */
	private static int count;
	public static void recursion() {
		count++;
		recursion();
	}
	
	public static void main(String[] args) {
		try {
			recursion();
		} catch (Throwable e) {
			System.out.println("调用次数count="+count);
			e.printStackTrace();
			
		}
	}
	
}
