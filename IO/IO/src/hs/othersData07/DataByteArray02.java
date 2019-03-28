package hs.othersData07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
/**
 * 数据类型(基本类型+String)处理流-----数据与字节数组交流
 *   1,输出流 DataOutputStream  writeXxx()
 *   2,输入流 DataInputStream   readXxx()
 *  新增方法不能使用多态
 *  
 *  java.io.EOFException:没有读取到相关的内容
 * @author Administrator
 *
 */
public class DataByteArray02 {
	//类型  数据输出到字节数组
	public static byte[] write() throws IOException {
		//创建类型  数据
		double piont=2.1;
		int a=3;
		//目标数字
		byte[] dest=null;
		String str="侯四海";		
		//选择流
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		DataOutputStream dos=new DataOutputStream(
				new BufferedOutputStream(bos));	
		//操作           写出的顺序  为读取作准备
		dos.writeDouble(piont);
		dos.writeInt(a);
		dos.writeUTF(str);
		dos.flush();	
		//获取数据
		dest=bos.toByteArray();
		dos.close();
		return dest;
	}
	//从字节数组读取 数据+类型
	public static void read(byte[] src) throws IOException{	
		DataInputStream dis=new DataInputStream(
				new BufferedInputStream(
						new ByteArrayInputStream(src)
						)
				);
		//操作  读取的顺序与写出顺序一致    必须存在才能读取   
		//不一致  数据存在问题
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
