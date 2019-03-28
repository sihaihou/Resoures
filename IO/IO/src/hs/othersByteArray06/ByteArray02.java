package hs.othersByteArray06;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * 字节数组    节点流
 * 数组的长度有限，数据量不会很大！
 * 文件内容不用太大
 * 		1，字符串--->字节数组
 *	    2，字节数组 --->字符串
 * @author 侯四海
 */
public class ByteArray02 {
	public static byte[] write() throws IOException{	
		//目的地
		byte[] dest;
		//选择流   不同点
		ByteArrayOutputStream bos=new ByteArrayOutputStream();	
		//操作写出
		String str="举头望明月";
		byte[] src=str.getBytes();
		bos.write(src, 0,src.length);
		//获取数据
		dest=bos.toByteArray();
		bos.close();
		return dest;
	}
	public static void read(byte[]src) throws IOException{				
		InputStream is=new BufferedInputStream(new ByteArrayInputStream(src));		
		byte[] flush=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))){
			String  str=new String(flush,0,len);
			System.out.println(str);
		}		
	}
	public static void main(String[] args) throws IOException {
		read(write());
	}
}
