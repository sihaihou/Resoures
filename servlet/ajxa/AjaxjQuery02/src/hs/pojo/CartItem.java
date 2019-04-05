package hs.pojo;
/**
 * 订单(书)对象
 * @author Administrator
 *
 */
public class CartItem {
	/**
	 * 订单(书)名称
	 */
	private String bookName;
	/**
	 * 订单(书)数量
	 */
	private int number;
	/**
	 * 订单(书)价格
	 */
	private int price;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
