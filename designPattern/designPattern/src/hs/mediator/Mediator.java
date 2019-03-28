package hs.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * 中介者抽象类
 * @author Administrator
 */
public interface Mediator {
	void register(String dname,Department d);
	void command(String dname);
}


/**
 * 真实中介者          总经理
 * @author Administrator
 */
class President implements Mediator{
	private Map<String,Department> map=new HashMap<String, Department>();
	@Override
	public void register(String dname, Department d) {
		map.put(dname, d);
	}
	@Override
	public void command(String dname) {
		map.get(dname).selfAction();
	}	 
}