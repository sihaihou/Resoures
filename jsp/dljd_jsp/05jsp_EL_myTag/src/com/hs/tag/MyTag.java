package com.hs.tag;
/**
 * 标签的处理类
 * @author Administrator
 */
public class MyTag{
	/**
	 * 转大写
	 * @param str
	 * @return
	 */
	public static String toUpper(String str) {
		return str.toUpperCase();
	} 
	/**
	 * 转小写
	 * @param str
	 * @return
	 */
	public static String toLower(String str) {
		return str.toLowerCase();
	} 
	/**
	 * 转首字母大写,其他小写
	 * @param str
	 * @return
	 */
	public static String toUpperLower(String str) {
		String lower = toLower(str);
		String temp0 = lower.substring(0, 1);
		String temp1 = lower.substring(1,str.length());
		return toUpper(temp0) + temp1;
	} 
}
