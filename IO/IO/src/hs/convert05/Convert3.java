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
 * ת����   �ֽ�ת�ַ�
 *  1��InputStreamReader  ����
 *  2��OutputStreamWriter ����
 * @author ���ĺ�
 */
public class Convert3 {
	public static void main(String[] args) throws IOException, InterruptedException {
		//ָ�������ַ���
		BufferedReader br=new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								//�����ָ���ַ��������� �������ַ���ͳһ����������
								new File("E:/test/07.java")),"utf-8")
				);
		//ָ�������ַ���
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
