package hs.factory.abstractFactory;
/**
 * µÍ¶ËÆû³µ
 * @author Administrator
 */
public class LowCarFactory implements CarFactory {
	@Override
	public Engine createEngine() {
		return new LowyEngine();
	}
	@Override
	public Seat createSeat() {
		return new LowySeat();
	}
	@Override
	public Tyre createTyre() {
		return new LowTyre();
	}
}
