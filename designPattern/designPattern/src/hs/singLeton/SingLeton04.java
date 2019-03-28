package hs.singLeton;
/**
 *  测试単例设计模式，   ---->确保一个类只有一个对象
 * 		枚举式实现単例模式！(没有延时加载)
 * 		可以天然防止反射和反序列化漏洞
 * @author 侯四海
 */
public enum SingLeton04 {
	/**
	 * 这个枚举元素，本身就是単例对象
	 */
	Instance;	
	/**
	 * 可以添加自己需要的操作
	 */
	public void Test04SingLeton(){
		
	}
}
