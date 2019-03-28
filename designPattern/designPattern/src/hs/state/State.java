package hs.state;
/**
 * 抽象房间状态 接口
 * @author Administrator
 *
 */
public interface State {
	void handle();
}

/**
 * 空闲状态
 * @author Administrator
 */
class FreeState implements State{
	@Override
	public void handle() {
		System.out.println("房间空闲中,可预订。。。。。");
	}	
}
/**
 * 预订状态
 * @author Administrator
 */
class BookedState implements State{
	@Override
	public void handle() {
		System.out.println("房间已预订。。。。。");

	}	
}
/**
 * 入住状态
 * @author Administrator
 */
class CheckedInState implements State{
	@Override
	public void handle() {
		System.out.println("房间已入住，请勿打扰。。。。。");
	}	
}