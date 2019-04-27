package hs.convert05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流   字节转字符
 *  1，InputStreamReader  解码
 *  2，OutputStreamWriter 编码
 * @author 侯四海
 */
public class Convert3 {
	public static void main(String[] args) throws IOException, InterruptedException {
		//指定解码字符集
		BufferedReader br=new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								//如果不指定字符集。编码 、解码字符集统一——不乱码
								new File("E:/test/07.java")),"utf-8")
				);
		//指定编码字符集
		BufferedWriter bw=new BufferedWriter(
				new OutputStreamWriter(
						new FileOutputStream(
								new File("E:/test/08.java")),"utf-8")
				);
		String str =null;
		while(null!=(str=br.readLine())){
			bw.write(str);
			bw.newLine();
		}
		bw.flush();		
		bw.close();
		br.close();
	}
}
