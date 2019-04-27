package hs.exception;
/**
 * 自定义异常
 * @author 侯四海
 */
public class MyException extends Exception { 
	public MyException() {
		super();
	}
	public MyException(String message) {
		super(message);
	}
}

