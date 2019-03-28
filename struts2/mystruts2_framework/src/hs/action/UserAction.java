package hs.action;

import java.util.ArrayList;
import java.util.List;

public class UserAction {
	private String name;
	private String tel;
	private String emily;
	List<String> list;
	public String add(){
		System.out.println("执行了add方法。。。");
		System.out.println("name:"+name+"  tel:"+tel+"  emily:"+emily);
		list = new ArrayList();
		list.add("To be or not to be ...");
		list.add("MengXiangJiang must be happy!");
		list.add("He is funny! ");
		for(int i=0;i<list.size();i++){			
			System.out.println(list.get(i));
		}
		return "success";
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmily() {
		return emily;
	}
	public void setEmily(String emily) {
		this.emily = emily;
	}
}
