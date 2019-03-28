package hs.builder;
/**
 * ���� �ɴ������ ����
 * @author Administrator
 */
public class HisAirShipBuilder implements AirShipBuilder {
	@Override
	public OrbitalModule builderOrbitalModule() {
		System.out.println("���������ƹ���ա�������");
		return new OrbitalModule("�����ƹ����");
	}
	@Override
	public EscpeTower builderEscpeTower() {
		System.out.println("������������������������");
		return new EscpeTower("������������");
	}
	@Override
	public Engine builderEngine() {
		System.out.println("�������������档������");
		return new Engine("����������");
	}
}
