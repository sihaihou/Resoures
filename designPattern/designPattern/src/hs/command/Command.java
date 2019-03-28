package hs.command;
/**
 * 抽象命令   接口
 * @author Administrator
 */
public interface Command {
	void excute();
}


/**
 * 具体命令
 * 		拥有真正命令执行者的引用
 * @author Administrator
 */
class ConcreteCommand implements Command{
	private Receiver receiver;	
	public ConcreteCommand(Receiver receiver) {
		this.receiver = receiver;
	}
	@Override
	public void excute() {
		//真正的命令执行前或后，可以执行相应的处理
		//......
		receiver.action();
	}	
}