package hs.strategy;

/**
 * 抽象算法 接口  
 * @author Administrator
 */
public interface  Strategy {
	public double getPrice(double standardPrice);
}

/**
 * 新客户小批量
 * @author Administrator
 */
class NewCustomerFewStrategy implements Strategy{
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("不好意思，不打折，原件");
		return standardPrice;
	}	
}
/**
 * 新客户大批量
 * @author Administrator
 */
class newCustomermanyStrategy implements Strategy{
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("九折");
		return standardPrice*0.9;
	}	
}
/**
 * 老客户小批量
 * @author Administrator
 */
class OldCustomerFewStrategy implements Strategy{
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("八五折");
		return standardPrice*0.85;
	}	
}
/**
 * 老客户大批量
 * @author Administrator
 */
class OldCustomermanyStrategy implements Strategy{
	@Override
	public double getPrice(double standardPrice) {
		System.out.println("七折");		
		return standardPrice*0.7;	}	
}
