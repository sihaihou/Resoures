package hs.builder;
/**
 * 
 *	����   XX�Ʒɴ�
 * @author Administrator
 */
public class AirShip {
	private OrbitalModule orbitalModule;//�����
	private EscpeTower escpeTower;//������
	private Engine engine;  //����	
	/**
	 * ���Թ����Լ��ķ���
	 */
	public void lunch(){
		System.out.println("���䡣������������");
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
 * �ɴ��Ĺ���� ����
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
 * �ɴ��������� ����
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
 *  �ɴ������� ����
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