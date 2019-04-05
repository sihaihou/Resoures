package hs.staticproxy;

/**
 * 真实角色
 * @author Administrator
 *
 */
public class Host implements Rent{
	@Override
	public void rent() {
		System.out.println("房屋出租");
	}
}
