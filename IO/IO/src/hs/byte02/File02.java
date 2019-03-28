package hs.byte02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
/**
 * д���ļ�
 * 1��������ϵ  ����File����   Ŀ�ĵ�
 * 2��ѡ����  �����ļ������
 * 		1��OutputStream
 * 		1��FileOutputStream
 * 3,������write+flush
 * 4,�ͷ���Դ  �����ر�
 * @author Administrator
 */
public class File02 {
		public static void main(String[] args) {
			//1��������ϵ  ����File����   Ŀ�ĵ�
			File file =new File("E:/test/02.java"); 
			//2��ѡ����  �����ļ������   1��OutputStream  FileOutputStream
			OutputStream os=null;
			//��׷����ʽд���ļ�
			try {
				 os=new FileOutputStream(file,false);//trueΪ׷��  falseΪ����   ��дĬ��Ϊ����
				// 3,������write+flush
				String str="ѡ����  �����ļ������  1��OutputStream 1��FileOutputStream"
						+ "3,������write+flush"
						+ "4,�ͷ���Դ  �����ر�";
				//�ַ���ת�ֽ�����
				byte[] car=str.getBytes();
				try {
					os.write(car, 0, str.length());
					os.flush();//ǿ��ˢ�³�ȥ
					System.out.println("�ļ�д���ɹ���");
				} catch (IOException e) {
					System.out.println("�ļ�д��ʧ��");
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				System.out.println("�ļ�������");
				e.printStackTrace();
				// 4,�ͷ���Դ  �����ر�
			}finally{
				if(null!=os){
					try {
						os.close();						
					} catch (IOException e) {
						System.out.println("�ļ��ͷ�ʧ��");
						e.printStackTrace();
					}
				}
			}
		}
}
