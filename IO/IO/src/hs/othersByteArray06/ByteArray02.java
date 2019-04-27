package hs.othersByteArray06;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/**
 * �ֽ�����    �ڵ���
 * ����ĳ������ޣ�����������ܴ�
 * �ļ����ݲ���̫��
 * 		1���ַ���--->�ֽ�����
 *	    2���ֽ����� --->�ַ���
 * @author ���ĺ�
 */
public class ByteArray02 {
	public static byte[] write() throws IOException{	
		//Ŀ�ĵ�
		byte[] dest;
		//ѡ����   ��ͬ��
		ByteArrayOutputStream bos=new ByteArrayOutputStream();	
		//����д��
		String str="��ͷ������";
		byte[] src=str.getBytes();
		bos.write(src, 0,src.length);
		//��ȡ����
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
