package PrintStream09;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
/**
 * PrintStream ��ӡ�� ������>������
 * ����������ļ�
 * @author Administrator
 *
 */
public class PrintStream01 {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("��ӡ������̨��so easy!");
		PrintStream ps=System.out;
		ps.println("��ӡ������̨��io is so easy!");
		
		File file=new File("E:/test/02.txt");
		ps =new PrintStream(new BufferedOutputStream(new FileOutputStream(file)));
		ps.println("Io is so easy!");
		ps.flush();
		ps.close();
		System.out.println("��ӡ���ļ��ɹ���");
	}
}
