package hs.state;
/**
 * 房间对象
 * 		持有状态的引用
 * @author Administrator
 */
public class HomeContext {
	private State state;
	/**
	 * 设置状态。。
	 * @param state
	 */
	public void setState(State state){
		System.out.println("修改状态。。");
		this.state=state;
		state.handle();		
	}
}
