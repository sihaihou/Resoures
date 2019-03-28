package hs.pojo;
/**
 * ¶©µ¥
 * @author Administrator
 *
 */
public class Order {
	private int id;
	private int deskId;
	private double totalPrice;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeskId() {
		return deskId;
	}
	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String toString() {
		return "Order [id=" + id + ", deskId=" + deskId + ", totalPrice=" + totalPrice + "]";
	}
}
