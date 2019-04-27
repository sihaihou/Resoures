package hs.byte02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/**
 * ��ȡ�ļ�
 * 1��������ϵ  ����File����
 * 2��ѡ����
 *   1��InputStream
 *   2)FileInputStream
 * 3,�����������С+read
 * 4,�ͷ���Դ
 * @author Administrator
 */
public class File01 {
	public static void main(String[] args) {
		//1��������ϵ  ����File����
		File file=new File("E:/test/01.java");
		//2��ѡ����
		InputStream is=null;  //����������
		try {
			is=new FileInputStream(file);
			//3���������϶�ȡ����������
			byte[] car=new byte[1024];
			int len;  //����ʵ�ʶ�ȡ��С
			try {//ѭ����ȡ
				while(-1!=(len=is.read(car))){
					//������ֽ�����ת�ַ���
					String info=new String(car,0,len);
					System.out.println(info);
				}
			} catch (IOException e) {
				System.out.println("�ļ���ȡʧ��");
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�������");
			e.printStackTrace();
			//4,�ͷ���Դ
		}finally{
			if(null!=is){
				try {
					is.close();
				} catch (IOException e) {
					System.out.println("�ļ��ͷ�ʧ��");
					e.printStackTrace();
				}
			}
		}		
	}
}
