package hs.pojo;

import java.util.HashMap;
import java.util.Map;
/**
 * 购物车对象
 * @author Administrator
 *
 */
public class Cart {
	//存放cartItem 的Map：键：书名；值：CartItem对象
	private Map<String,CartItem> items = new HashMap<String,CartItem>();
	private String bookName;
	
	/**
	 * 加入购物车
	 * @param bookName
	 * @param price
	 */
	public void addCart(String bookName,int price) {
		this.bookName = bookName;
		
		if(items.containsKey(bookName)) {
			CartItem item = items.get(bookName);
			item.setNumber(item.getNumber() + 1);
		}else {
			CartItem item = new CartItem();
			item.setBookName(bookName);
			item.setPrice(price);
			item.setNumber(1);
	
			items.put(bookName, item);
		}
	}
	
	/**
	 * getter方法供 JackSon 定位对象的属性
	 * @return
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * 获取购物车大小
	 * @return
	 */
	public int getTotalBookNumber() {
		int total = 0;
		for(CartItem item:items.values()) {
			total += item.getNumber();
		}
		return total;
	}
	
	/**
	 * 获取购物车总价
	 * @return
	 */
	public int getTotalBookPrice() {
		int money = 0;
		for(CartItem item:items.values()) {
			money += item.getNumber()*item.getPrice();
		}
		return money;
	}
}
