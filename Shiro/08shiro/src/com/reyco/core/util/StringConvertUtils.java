package com.reyco.core.util;

import org.apache.commons.lang.StringUtils;


public class StringConvertUtils {
	
	public static String toBit(byte b) {
		StringBuilder builder = new StringBuilder();
		for (int i = 7; i >= 0; i--) {
			builder.append((b >> i & 1));
		}
		return builder.toString();
	}

	public static String convert(String input) {
		StringBuilder builder = new StringBuilder();
		byte[] bytes = input.getBytes();
		for (byte b : bytes) {
			String bits = toBit(b);
			builder.append(bits);
		}
		return NumberUtils.convert(builder.toString(), 2, 62);
	}

	public static String reverse(String input) {
		String string = NumberUtils.convert(input,62, 2);
		int mod = string.length() % 8; 
		if (mod != 0) {
			string = StringUtils.leftPad(string, (8 - mod) + string.length(), "0");
		}
		int length = string.length() / 8;
		byte[] bytes = new byte[length];
		for(int i = 0; i < bytes.length; i++) {
			String bits = string.substring(i*8, (i+1) *8);
			bytes[i] = toByte(bits);
		}
		return new String(bytes);
	}

	public static byte toByte(String bits) {
		byte b = 0;
		for (int i = 0; i < 8; i++) {
			int bit = 7-i;
			if (bits.charAt(i) == '1') {
				b |= (0x1 << bit);
			} else {
				b &= ~(0x1 << bit);
			}
		}
		return b;
	}

	public static void main(String[] args) throws Exception {
		String z = "iP";
		System.out.println(reverse(convert(z)));
	}
}
