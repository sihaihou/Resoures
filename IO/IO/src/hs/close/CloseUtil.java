package hs.close;

import java.io.Closeable;
import java.io.IOException;
/**
 * ������ر���
 * �ɱ���� : ...   ֻ�����β����һλ�ã�����ʽ������һ�£�
 * @author Administrator
 */
public class CloseUtil {
	/**
	 * һ��Ĺر���
	 * @param io
	 * @throws IOException
	 */
	public static void close(Closeable ...io) throws IOException{
		for(Closeable temp:io){
			if(null!=temp){
				temp.close();
			}
		}
	}
	/**
	 * ����
	 * @param io
	 * @throws IOException
	 */
	public static<T extends Closeable > void closeall(T ...io) throws IOException {
		for(T temp:io){
			if(null!=temp){
				temp.close();
			}
		}
	}
}
