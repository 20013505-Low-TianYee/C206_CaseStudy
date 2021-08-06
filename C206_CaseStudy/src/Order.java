import java.util.ArrayList;

/**
 * I declare that this code was written by Goh Sean Adam.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20024783, 31 Jul 2021 10:00:26 pm
 */
public class Order extends Food { 
	 
//

//Adam

	private int quantity;
	private int totalPrice;
	
	
	
	public Order(int id, String name, int price, String stall, int quantity, int totalPrice) {
		super(id, name, price, stall);
		this.quantity = quantity;
		this.totalPrice = quantity*super.getPrice();
		
		
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalPrice() {
		this.totalPrice = quantity * super.getPrice();
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	

	public void display() {

		System.out.printf("%-20s %-20s %-20s $%-20s $%-10s\n", super.getId(), super.getName(), super.getStall(), super.getPrice(), totalPrice);

	}
}
