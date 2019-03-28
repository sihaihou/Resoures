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
 * 数据类型(基本类型+String)处理流-----	数据与文件交流
 *   1,输出流 DataOutputStream  writeXxx()
 *   		把数据输出到文件
 *   2,输入流 DataInputStream   readXxx()
 *   		从文件读取数据	
 *  新增方法不能使用多态
 *  java.io.EOFException:没有读取到相关的内容
 * @author Administrator
 *
 */
public class OthersData01 {
	//类型  数据输出到文件
	public static void write(String destpath) throws IOException{
		//创建类型  数据
		double piont=2.1;
		int a=3;
		String str="侯四海";		
		//创建源
		File src=new File(destpath);
		//选择流
		DataOutputStream dos=new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(src)
						)
				);		
		//操作           写出的顺序  为读取作准备
		dos.writeDouble(piont);
		dos.writeInt(a);
		dos.writeUTF(str);
		dos.flush();		
		dos.close();
	}
	//从文件读取数据+类型
	public static void read(String srcpath) throws IOException{
		//创建源
		File src=new File(srcpath);
		//选择流
		DataInputStream dis=new DataInputStream(
				new BufferedInputStream(
						new FileInputStream(src)
						)
				);
		//操作  读取的顺序与写出顺序一致    必须存在才能读取   
		//不一致  数据存在问题
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
