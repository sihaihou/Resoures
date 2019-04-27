package com.reyco.ftpClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
/**
 *    测试代码
 * @author reyco
 */
public class Test {
	public static void main(String[] args) {
		FTPClient fc = null;
		try {
			//创建ftp客户端
			fc = new FTPClient();
			//设置连接地址和端口
			fc.connect("192.168.2.101", 21);
			//设置用户和密码
			fc.login("ftpuser", "123456");
			//设置文件类型
			fc.setFileType(FTP.BINARY_FILE_TYPE);
			//上传
			boolean flag = fc.storeFile("a.jpg", new FileInputStream(new File("D:/test/1.jpg")));
			if(flag)
				System.out.println("上传成功...");
			else
				System.out.println("上传失败...");
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			//关闭连接
			if(null != fc) {
				try {
					fc.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
