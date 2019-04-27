package PrintStream09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 * 封装输入
 * @author 侯四海
 */
public class MyScanner03 {
	public static void main(String[] args) throws IOException {
		InputStream is=System.in;
		BufferedReader br=new  BufferedReader(new InputStreamReader(is));
		System.out.println("请输入:。。。。。");
		String str=br.readLine();
		System.out.println(str);
		
		/*Scanner scanner = new Scanner(is);		
		System.out.println("请输入:。。。。。");
		scanner.hasNext();
		System.out.println(scanner.nextLine());*/
	}
}
