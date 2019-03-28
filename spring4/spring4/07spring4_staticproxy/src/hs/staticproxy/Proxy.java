package hs.staticproxy;
/**
 * 代理角色
 * @author Administrator
 *
 */
public class Proxy implements Rent{
	private Host host;	
	
	public Proxy(Host host) {
		super();
		this.host = host;
	}
	//租房
	@Override
	public void rent() {
		seeHouse();
		host.rent();
		fare();
	}
	//看房
	private void seeHouse(){
		System.out.println("带房客看房");
	}
	//收费
	private void fare(){
		System.out.println("收取中介费");
	}
}
