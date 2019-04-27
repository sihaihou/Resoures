package com.reyco.core.util;

import java.math.BigInteger;

public class NumberUtils {

	// 十进制转换中把字符转换为数
	public static int changeDec(char ch) {
		int num = 0;
		if (ch >= 'A' && ch <= 'Z')
			num = ch - 'A' + 10;
		else if (ch >= 'a' && ch <= 'z')
			num = ch - 'a' + 36;
		else
			num = ch - '0';
		return num;
	}

	//任意进制转换为10进制
	public static BigInteger toDecimal(String input, int base) {
		BigInteger Bigtemp = BigInteger.ZERO, temp = BigInteger.ONE;
		int len = input.length();
		for (int i = len - 1; i >= 0; i--) {
			if (i != len - 1)
				temp = temp.multiply(BigInteger.valueOf(base));
			int num = changeDec(input.charAt(i));
			Bigtemp = Bigtemp.add(temp.multiply(BigInteger.valueOf(num)));
		}
		return Bigtemp;
	}

	// 数字转换为字符
	public static char changToNum(BigInteger temp) {
		int n = temp.intValue();

		if (n >= 10 && n <= 35)
			return (char) (n - 10 + 'A');

		else if (n >= 36 && n <= 61)
			return (char) (n - 36 + 'a');

		else
			return (char) (n + '0');
	}

	// 十进制转换为任意进制
	public static String toAnyConversion(BigInteger Bigtemp, int base) {
		String ans = "";
		BigInteger valueOf = BigInteger.valueOf(base);
		while (Bigtemp.compareTo(BigInteger.ZERO) != 0) {
			BigInteger temp = Bigtemp.mod(valueOf);
			Bigtemp = Bigtemp.divide(valueOf);
			char ch = changToNum(temp);
			ans = ch + ans;
		}
		return ans;
	}

	public static String convert(String input, int scouceBase, int targetBase) {
		BigInteger big = toDecimal(input, scouceBase);
		return toAnyConversion(big, targetBase);
	}

	public static void main(String[] args) {
		System.out.println(convert("253611911709841", 10, 16));
		System.out.println(convert("1A0ykpwzR", 62, 10));

		System.out.println(Long.toString(123078340L, 36));
		System.out.println(Long.parseLong("219zus", 36));
	}
}
