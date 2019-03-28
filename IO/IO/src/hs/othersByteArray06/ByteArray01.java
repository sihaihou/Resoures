package hs.othersByteArray06;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * 读取字节数组
 * 		ByteArrayInputStream  字节数组输入流
 * @author 侯四海
 *
 */
public class ByteArray01 {
	public static void read() throws IOException{		
		String str="举头望明月";
		byte[] src=str.getBytes();
		InputStream is=new BufferedInputStream(new ByteArrayInputStream(src));		
		byte[] flush=new byte[1024];
		int len=0;
		while(-1!=(len=is.read(flush))){			  ;
			System.out.println(new String(flush,0,len));
		}		
	}
	/**
	 * @param src   字节数组
	 * @throws IOException
	 */
	public static void read(byte[] src) throws IOException{	
		read();
	}
	public static void main(String[] args) throws IOException {
		String str="举头望明月";
		byte[] src=str.getBytes();
		read(src);
		read();
	}
}
