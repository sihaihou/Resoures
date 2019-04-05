package com.exam.core.util;

import java.io.Closeable;
import java.io.IOException;
/**
 * 工具类关闭流
 * 可变参数 : ...   只能在形参最后一位置，处理方式与数组一致！
 * @author Administrator
 */
public class CloseUtil {
	/**
	 * 一般的关闭流
	 * @param io
	 * @throws IOException
	 */
	public static void close(Closeable ...io) throws IOException{
		for(Closeable temp:io){
			if(null!=temp){
				temp.close();
			}
		}
	}
	/**
	 * 泛型
	 * @param io
	 * @throws IOException
	 */
	public static<T extends Closeable > void closeall(T ...io) throws IOException {
		for(T temp:io){
			if(null!=temp){
				temp.close();
			}
		}
	}
}
