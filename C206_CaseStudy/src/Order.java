
/**
 * I declare that this code was written by Goh Sean Adam.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20024783, 31 Jul 2021 10:00:26 pm
 */
public class Order extends Food{ //Adam

	private int quantity;
	private double totalPrice;
	public Order(int id, String name, int price, String stall, int quantity, double totalPrice) {
		super(id, name, price, stall);
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		totalPrice = quantity * super.getPrice();
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
