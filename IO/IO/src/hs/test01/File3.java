package hs.test01;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * ��̬���
 * 		�����ļ�
 * 		������ʱ�ļ�
 * @author Administrator
 *
 */
public class File3 {
		public static void test() throws IOException, InterruptedException {
			 String src=("E:/test/04.txt");
				File file = new File(src);
				//��������ڣ��������ļ�
				if(!file.exists()){
					boolean a = file.createNewFile();			
					System.out.println(a?"�����ɹ�":"����ʧ��");
				}
				boolean b=file.delete();
				System.out.println(b?"ɾ���ɹ�":"ɾ��ʧ��");				
				//������ʱ�ļ�
				File temp = File.createTempFile("001", ".txt", new File("E:/test"));	
				System.out.println("������ʱ�ļ��ɹ���");
				Thread.sleep(5000);			
				temp.deleteOnExit();
				System.out.println("������ʱ��ɾ����");				
		}
		public static void main(String[] args) throws IOException, InterruptedException  {
			test();
		}
}
