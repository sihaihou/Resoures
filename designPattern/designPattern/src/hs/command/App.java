package hs.command;

public class App {
	public static void main(String[] args) {
		Command c=new ConcreteCommand(new Receiver());
		Invoke i=new Invoke(c);
		i.call();
	}
}
