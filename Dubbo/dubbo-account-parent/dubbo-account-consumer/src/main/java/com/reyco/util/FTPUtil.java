package com.reyco.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPUtil {
	private static FTPClient fc;
	static {
		fc = new FTPClient();
		try {
			//设置连接地址和端口
			fc.connect("192.168.2.101", 21);
			//设置用户和密码
			fc.login("ftpuser", "123456");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		Boolean upload=false;
		try {
			FileInputStream fileInputStream = new FileInputStream("D:/test/1.jpg");
			upload = uploadImage("1.jpg",fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("上传==="+upload);
	}
	/**
	 * FTPClient图片文件上传
	 * @param filename  上传到服务器的文件名称
	 * @return
	 */
	public static Boolean uploadImage(String filename,InputStream is) {
		try {
			//创建目录---只能创建单极目录
			//fc.makeDirectory("aaa");
			fc.changeWorkingDirectory("images");
			//设置文件类型
			fc.setFileType(FTP.BINARY_FILE_TYPE);
			//上传
			return fc.storeFile(new String(filename.getBytes("utf-8"),"iso-8859-1"),is);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally {
			//关闭连接
			if(null != fc) {
				try {
					fc.disconnect();
					System.out.println(fc);
					fc=null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
}
