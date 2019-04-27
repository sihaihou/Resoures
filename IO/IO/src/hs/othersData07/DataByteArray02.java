package hs.othersData07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/**
 * ��������(��������+String)������-----�������ֽ����齻��
 *   1,����� DataOutputStream  writeXxx()
 *   2,������ DataInputStream   readXxx()
 *  ������������ʹ�ö�̬
 *  
 *  java.io.EOFException:û�ж�ȡ����ص�����
 * @author Administrator
 *
 */
public class DataByteArray02 {
	//����  ����������ֽ�����
	public static byte[] write() throws IOException {
		//��������  ����
		double piont=2.1;
		int a=3;
		//Ŀ������
		byte[] dest=null;
		String str="���ĺ�";		
		//ѡ����
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(
				new BufferedOutputStream(bos));	
		//����           д����˳��  Ϊ��ȡ��׼��
		dos.writeDouble(piont);
		dos.writeInt(a);
		dos.writeUTF(str);
		dos.flush();	
		//��ȡ����
		dest=bos.toByteArray();
		dos.close();
		return dest;
	}
	//���ֽ������ȡ ����+����
	public static void read(byte[] src) throws IOException{	
		DataInputStream dis=new DataInputStream(
				new BufferedInputStream(
						new ByteArrayInputStream(src)
						)
				);
		//����  ��ȡ��˳����д��˳��һ��    ������ڲ��ܶ�ȡ   
		//��һ��  ���ݴ�������
		double num =dis.readDouble();
		int num2=dis.readInt();
		String str=dis.readUTF();
		dis.close();
		System.out.println(str+"-->"+num+"-->"+num2);
	}
	public static void main(String[] args) throws IOException {
		byte[] data=write();
		read(data);
	}
}
