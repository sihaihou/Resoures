package hs.char03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
/**
 * �ַ���д���ļ�
 * @author ���ĺ�
 */
public class FileChar2 {
	public static void main(String[] args) {
		File dest=new File("E:/test/05.java");
		Writer w=null;
		try {
			w=new FileWriter(dest,false);
			String str="��ǰ���¹�,\r\n���ǵ���˪.\r\n��ͷ�����£�\r\n��ͷ˼���磡\r\n";
//			wt.append("��ס�������");
			w.write(str);
			w.flush();
		} catch (IOException e) {
			System.out.println("�ļ�������");
			e.printStackTrace();
		}finally{
			if(w!=null){
				try {
					w.close();
					System.out.println("����д���ɹ���");
				} catch (IOException e) {
					System.out.println("�ͷ�ʧ��");
					e.printStackTrace();
				}
			}
		}
	}
}
