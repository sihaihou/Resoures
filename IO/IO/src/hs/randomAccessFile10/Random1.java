package hs.randomAccessFile10;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import hs.close.CloseUtil;
/**
 * seek ����
 * seek(50) ��50���ֽڿ�ʼ��ȡ
 * @author Administrator
 *
 */
public class Random1 {
	public static void main(String[] args) throws IOException {
		RandomAccessFile raf=new RandomAccessFile(new File("E:/test/06.txt"),"r");
		raf.seek(50);
		System.out.println();
		byte[] src=new byte[1024];
		int len;
		while(-1!=(len=raf.read(src))){
			System.out.println(new String(src,0,len));		
		}
		CloseUtil.closeall(raf);
	}
}
