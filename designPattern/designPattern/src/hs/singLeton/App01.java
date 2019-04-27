package hs.singLeton;

public class App01 {
	public static void main(String[] args) {		
		SingLeton01 s1=SingLeton01.getInstance();
		SingLeton01 s2=SingLeton01.getInstance();
		System.out.println(s1==s2);
	}
}
