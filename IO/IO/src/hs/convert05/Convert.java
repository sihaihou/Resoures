package hs.convert05;

import java.io.UnsupportedEncodingException;
/**
 * 编码与解码字符集必须相同   否则乱码
 * 字节缺少，长度丢失！————乱码！
 * @author Administrator
 */
public class Convert {
		private static int utf;
		public static void main(String[] args) throws UnsupportedEncodingException {
			//解码：byte-->char   eclipse默认 GBK
			String str="中国";
			byte[] date=str.getBytes();
			//编码 、解码字符集统一——没乱码
			System.out.println(new String(date));
			
			//编码  char-->byte
			//设定编码字符集
			date = str.getBytes("utf-8");
			//编码 、解码字符集不统一——乱码
			System.out.println("设置编码集utf-8:"+new String(date));	
			
			//编码：
			 date="中国".getBytes("utf-8");
	        //解码  ——二选一
//			str=new String(src1,"utf-8");//设定解码字符集
			str=new String(date);
			System.out.println(new String(str));	
			
			System.out.println("=======字节缺少，长度丢失！————乱码！=========");
			String str1="中国";
			date=str1.getBytes();
			//字节缺少，长度丢失！————乱码！	
			System.out.println(new String(date,0,3));		
		}
}
