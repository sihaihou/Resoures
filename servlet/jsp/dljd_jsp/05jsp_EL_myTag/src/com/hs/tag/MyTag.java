package com.hs.tag;
/**
 * ��ǩ�Ĵ�����
 * @author Administrator
 */
public class MyTag{
	/**
	 * ת��д
	 * @param str
	 * @return
	 */
	public static String toUpper(String str) {
		return str.toUpperCase();
	} 
	/**
	 * תСд
	 * @param str
	 * @return
	 */
	public static String toLower(String str) {
		return str.toLowerCase();
	} 
	/**
	 * ת����ĸ��д,����Сд
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
