/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 19020947, Aug 1, 2021 2:13:55 PM
 */
import java.util.ArrayList;
/**
 * @author 19020947
 *
 *///
public class purchaseOrder {
	private String ingredient;
	private int quantity;
	private int poNum;
	private String stallName;
	
	public purchaseOrder(String ingredient, int quantity, String stallName) {
		this.stallName = stallName;
		this.ingredient = ingredient;
		this.quantity = quantity;
	}
	
	public String getIngredient() {
		return ingredient;
	}
	
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getPoNum() {
		return poNum;
	}
	
	public void setPoNum(int poNum) {
		this.poNum = poNum;
	}
	
	public String getStallName() {
		return stallName;
	}
	
	public void setStallName(String stallName) {
		this.stallName = stallName;
	}

	public void display() {
		System.out.printf("%-30s %-5s %10s\n",ingredient, quantity, stallName);
	}
	
}
