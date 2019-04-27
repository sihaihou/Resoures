package PrintStream09;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
/**
 * ����������
 *	System.in  ������  ��������
 *  System.out �����  ����̨���
 *  System.err
 * �ض���
 *	 setIn()
 *	 setOut()
 *	 setErr()
 *	 FileDescriptor.in   ����
 *	 FileDescriptor.out  ���
 * System.in �ļ��������뵽����̨   ���� ��ӡ��
 * setOut ����̨����������ļ�  ������ӡ��
 * @author ���ĺ�
 */
public class System02 {
	public static void main(String[] args) throws FileNotFoundException {
		String srcpath="E:/test/02.txt";	
		//test(srcpath);	
		String str="�������� :����̨��������>�ļ�-----�ļ���������>����̨";
		test2(str);
	}
	/**
	 * ��ȡ�ļ����뵽����̨   ���� ��ӡ��
	 * @param srcpath
	 * @throws FileNotFoundException
	 */
	public static void test(String srcpath) throws FileNotFoundException{
		InputStream is=System.in;
	    is=new BufferedInputStream(new FileInputStream(srcpath));
	    //Scanner scanner=new Scanner(System.in);
		Scanner scanner=new Scanner(is);
		//�ļ�������������̨
		System.out.println(scanner.nextLine());
	}
	/**
	 * ����̨����������ļ� <����>��ӡ��
	 * @param str
	 * @throws FileNotFoundException
	 */
	public static void test2(String str) throws FileNotFoundException{
		//�ض���
		System.setOut(new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream("E:/test/03.txt")),true));
		//����̨��������>�ļ�
		System.out.println(str);	
		
		System.setOut(new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream( FileDescriptor.out)),true));
		//�ļ�������������̨
		System.out.println(str);    	
	}	
}
