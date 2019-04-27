package hs.othersData07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 * ��������(��������+String)������-----	�������ļ�����
 *   1,����� DataOutputStream  writeXxx()
 *   		������������ļ�
 *   2,������ DataInputStream   readXxx()
 *   		���ļ���ȡ����	
 *  ������������ʹ�ö�̬
 *  java.io.EOFException:û�ж�ȡ����ص�����
 * @author Administrator
 *
 */
public class OthersData01 {
	//����  ����������ļ�
	public static void write(String destpath) throws IOException{
		//��������  ����
		double piont=2.1;
		int a=3;
		String str="���ĺ�";		
		//����Դ
		File src=new File(destpath);
		//ѡ����
		DataOutputStream dos=new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(src)
						)
				);		
		//����           д����˳��  Ϊ��ȡ��׼��
		dos.writeDouble(piont);
		dos.writeInt(a);
		dos.writeUTF(str);
		dos.flush();		
		dos.close();
	}
	//���ļ���ȡ����+����
	public static void read(String srcpath) throws IOException{
		//����Դ
		File src=new File(srcpath);
		//ѡ����
		DataInputStream dis=new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(src)
						)
				);
		//����  ��ȡ��˳����д��˳��һ��    ������ڲ��ܶ�ȡ   
		//��һ��  ���ݴ�������
		double num =dis.readDouble();
		int num2=dis.readInt();
		String str=dis.readUTF();
		System.out.println(str+"-->"+num+"-->"+num2);
	}
	public static void main(String[] args) throws IOException {
		String str="E:/test/04.txt";
		write(str);
		read(str);
	}
}
