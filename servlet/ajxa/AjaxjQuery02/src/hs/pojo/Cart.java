package hs.pojo;

import java.util.HashMap;
import java.util.Map;
/**
 * ���ﳵ����
 * @author Administrator
 *
 */
public class Cart {
	//���cartItem ��Map������������ֵ��CartItem����
	private Map<String,CartItem> items = new HashMap<String,CartItem>();
	private String bookName;
	
	/**
	 * ���빺�ﳵ
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
	 * getter������ JackSon ��λ���������
	 * @return
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * ��ȡ���ﳵ��С
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
	 * ��ȡ���ﳵ�ܼ�
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
