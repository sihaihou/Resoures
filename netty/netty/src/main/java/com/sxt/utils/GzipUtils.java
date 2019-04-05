package com.sxt.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipUtils {
	
	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("D:\\3\\1.jpg");
		byte[] temp = new byte[fis.available()];
		int length = fis.read(temp);
		System.out.println("长度 : " + length);
		
		byte[] zipArray = GzipUtils.zip(temp);
		System.out.println("压缩后的长度 : " + zipArray.length);
		
		byte[] unzipArray = GzipUtils.unzip(zipArray);
		System.out.println("解压缩后的长度 : " + unzipArray.length);
		
		FileOutputStream fos = new FileOutputStream("D:\\3\\101.jpg");
		fos.write(unzipArray);
		fos.flush();
		
		fos.close();
		fis.close();
	}
	
	/**
	 * 解压缩
	 * @param source 源数据。需要解压的数据。
	 * @return 解压后的数据。 恢复的数据。
	 * @throws Exception
	 */
	public static byte[] unzip(byte[] source) throws Exception{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(source);
		// JDK提供的。 专门用于压缩使用的流对象。可以处理字节数组数据。
		GZIPInputStream zipIn = new GZIPInputStream(in);
		byte[] temp = new byte[256];
		int length = 0;
		while((length = zipIn.read(temp, 0, temp.length)) != -1){
			out.write(temp, 0, length);
		}
		// 将字节数组输出流中的数据，转换为一个字节数组。
		byte[] target = out.toByteArray();
		
		zipIn.close();
		out.close();
		
		return target;
	}
	
	/**
	 * 压缩
	 * @param source 源数据，需要压缩的数据
	 * @return 压缩后的数据。
	 * @throws Exception
	 */
	public static byte[] zip(byte[] source) throws Exception{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		// 输出流，JDK提供的，提供解压缩功能。
		GZIPOutputStream zipOut = new GZIPOutputStream(out);
		// 将压缩信息写入到内存。 写入的过程会实现解压。
		zipOut.write(source);
		// 结束。
		zipOut.finish();
		byte[] target = out.toByteArray();
		
		zipOut.close();
		
		return target;
	}
}
