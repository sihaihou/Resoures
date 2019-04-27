package hs.builder;
/**
 * 
 *	对象   XX牌飞船
 * @author Administrator
 */
public class AirShip {
	private OrbitalModule orbitalModule;//轨道舱
	private EscpeTower escpeTower;//逃逸塔
	private Engine engine;  //引擎	
	/**
	 * 可以构建自己的方法
	 */
	public void lunch(){
		System.out.println("发射。。。。。。。");
	}
	public OrbitalModule getOrbitalModule() {
		return orbitalModule;
	}
	public EscpeTower getEscpeTower() {
		return escpeTower;
	}
	public Engine getEngine() {
		return engine;
	}
	public void setOrbitalModule(OrbitalModule orbitalModule) {
		this.orbitalModule = orbitalModule;
	}
	public void setEscpeTower(EscpeTower escpeTower) {
		this.escpeTower = escpeTower;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}	
}


/**
 * 飞船的轨道舱 对象
 * @author Administrator
 */
class OrbitalModule{
	private String name;
	public OrbitalModule() {
		// TODO Auto-generated constructor stub
	}
	public OrbitalModule(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}

/**
 * 飞船的逃逸塔 对象
 * @author Administrator
 */
class EscpeTower{
	private String name;
	public EscpeTower() {
		// TODO Auto-generated constructor stub
	}
	public EscpeTower(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

/**
 *  飞船的引擎 对象
 * @author Administrator
 */
class Engine{
	private String name;
	public Engine() {
		// TODO Auto-generated constructor stub
	}
	public Engine(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}