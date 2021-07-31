
/**
 * I declare that this code was written by me. I will not copy or allow others
 * to copy my code. I understand that copying code is considered as plagiarism.
 *
 * 20013505, 30 Jul 2021 1:34:41 pm
 */
public class Food {
	private int id;
	private String name;
	private double price;
	private String stall;

	public Food(int id, String name, double price, String stall) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stall=stall;
	}


	public String getStall() {
		return stall;
	}

	
	public void setStall(String stall) {
		this.stall = stall;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void display() {

		System.out.printf("%-10s %-20s $%-20s %-10s\n", id, name, price, stall);

	}
}
