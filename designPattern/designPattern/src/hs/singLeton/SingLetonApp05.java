package hs.singLeton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
/**
 * 反射如何破解単例(除了枚举)
 * @author 侯四海
 *
 */
public class SingLetonApp05 {
	public static void main(String[] args) throws Exception {

		SingLeton05 s1=SingLeton05.getInstance();
		SingLeton05 s2=SingLeton05.getInstance();
		System.out.println(s1==s2);
		
		/**
		 * 反射如何破解単例(通过直接调用私有空构造器)
		 */
		/*Class<SingLeton05> clazz=(Class<SingLeton05>) Class.forName("hs.singLeton.SingLeton05");
		Constructor<SingLeton05> c=clazz.getDeclaredConstructor(null);
		c.setAccessible(true);
		SingLeton05 s3=c.newInstance();
		SingLeton05 s4=c.newInstance();
		System.out.println(s3==s4);*/
			
		/**
		 * 反序列化如何破解単例
		 */
		//序列化
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("E:/test/09.txt"));
		oos.writeObject(s1);
		oos.flush();
		oos.close();
		//反序列化
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("E:/test/09.txt"));
		SingLeton05 s5=(SingLeton05) ois.readObject();
		System.out.println(s1==s5);
	}
}
