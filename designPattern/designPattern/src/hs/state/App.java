package hs.state;
/**
 * ״̬ģʽ
 * @author Administrator
 */
public class App {
	public static void main(String[] args) {
		HomeContext hc=new HomeContext();
		hc.setState(new FreeState());
		hc.setState(new CheckedInState());
	}
}
