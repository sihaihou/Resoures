package hs.convert05;

import java.io.UnsupportedEncodingException;
/**
 * ����������ַ���������ͬ   ��������
 * �ֽ�ȱ�٣����ȶ�ʧ�������������룡
 * @author Administrator
 */
public class Convert {
		private static int utf;
		public static void main(String[] args) throws UnsupportedEncodingException {
			//���룺byte-->char   eclipseĬ�� GBK
			String str="�й�";
			byte[] date=str.getBytes();
			//���� �������ַ���ͳһ����û����
			System.out.println(new String(date));
			
			//����  char-->byte
			//�趨�����ַ���
			date = str.getBytes("utf-8");
			//���� �������ַ�����ͳһ��������
			System.out.println("���ñ��뼯utf-8:"+new String(date));	
			
			//���룺
			 date="�й�".getBytes("utf-8");
	        //����  ������ѡһ
//			str=new String(src1,"utf-8");//�趨�����ַ���
			str=new String(date);
			System.out.println(new String(str));	
			
			System.out.println("=======�ֽ�ȱ�٣����ȶ�ʧ�������������룡=========");
			String str1="�й�";
			date=str1.getBytes();
			//�ֽ�ȱ�٣����ȶ�ʧ�������������룡	
			System.out.println(new String(date,0,3));		
		}
}
