package hs.exception;

public class TestMyException extends MyException {
	public void Test()throws MyException{
		System.err.println("≤‚ ‘ ◊‘∂®“ÂException...");
	}	
	public static void main(String[] args) {
		try{
			new TestMyException().Test();
		}catch(MyException e){
				e.printStackTrace();
		}
	}
}