package hs.buffered04;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * 
 * ������
 * �ļ��Ŀ���    +  ��ӵĻ�����     ���������������
 * 			������(�ֽ���)
 * 
 * 1��������ϵ   File����  Դͷ Ŀ�ĵ�
 * 2��ѡ����
 *    	�ļ�������	InputStream  FileInputStream
 *     	�ļ������    	OutputStream  FileOutputStream	
 * 3������: ����
 * 		byte[] flush=new byte[1024];
 *      int len=0;
 *      while(-1=(len=��������read(flush))){
 *      	����� write(flush,0,len)
 *      }
 *      �������flush��
 * 4���ͷ���Դ���ر�������     
 */
public class Bufferedbyte {
	 public static void copyFile(String srcpath,String destpath ) throws Exception{
	    	try {	    		
	    		//1��������ϵ(������Ϊ�ļ�)  +Ŀ�ĵ�(�ļ����Բ�����)
	    		File src=new File(srcpath);
	    		File dest=new File(destpath);	
	    		if(!src.isFile()){//�����ļ�����Ϊnull	
//	    			System.out.println("ֻ�ܿ����ļ�");	
	    			throw new Exception("ֻ�ܿ����ļ�");																					
				}
	    		//destΪ�Ѿ����ڵ��ļ��У����ܴ������ļ���ͬ�����ļ�
	    		if(dest.isDirectory()){
	    			throw new Exception("���ܴ������ļ���ͬ�����ļ�");
	    		}
	    		//ѡ����
				InputStream is=new BufferedInputStream(new FileInputStream(src));
				OutputStream os=new BufferedOutputStream(new FileOutputStream(dest,true));//trueΪ׷��  falseΪ����   ��дĬ��Ϊ����							
				//3.�ļ�����     ѭ��+��ȡ+д��
				byte[] car = new byte[1024];
				int len=0;
				try {
					//��ȡ
					while(-1!=(len=is.read(car))){
						//д��
						os.write(car, 0, len);						
					}
					//ǿ��ˢ�³�ȥ
					os.flush();
					//�ر���
					is.close();
					os.close();
				} catch (IOException e) {	
					System.out.println("�����ļ�ʧ��");
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				System.out.println("�ļ�������");
				e.printStackTrace();
			}
	    }
		public static void main(String[] args) throws Exception   {
			 String src="E:/test/test1.java";
			 String dest="E:/test/test2.txt";	
		     copyFile(src, dest);
		
		}
}
