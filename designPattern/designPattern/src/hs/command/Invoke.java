package hs.command;
/**
 * 命令的调用者|发起者
 * @author Administrator
 */
public class Invoke {
	private Command command;
	public Invoke(Command command) {
		this.command = command;
	}
	/**
	 * 业务方法    用于调用命令类的方法
	 */
	public void call(){
		//真正的命令执行前或后，可以执行相应的处理
		//......
		command.excute();
	}
}
