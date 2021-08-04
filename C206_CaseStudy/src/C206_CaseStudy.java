import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		ArrayList<Stall> stallList = new ArrayList<Stall>(10);
		ArrayList<Food> foodList = new ArrayList<Food>();
		ArrayList<purchaseOrder> poList = new ArrayList<purchaseOrder>(8);
		ArrayList<Promo> promoList = new ArrayList<Promo>();
		ArrayList<Order> orderList = new ArrayList<Order>(5);


		int option = -1;

		while (option != 16) {
			menu();
			option = Helper.readInt("Enter choice > ");
			Helper.line(80, "=");

			if (option == 1) {
				addStallInputMethodMenu(stallList);
			} else if (option == 2) {
				viewStallIfElse(stallList);
			} else if (option == 3) {
				deleteStallIfElse(stallList);
			} else if (option == 4) { // add food
				Food f = inputFood();
				addFood(foodList, f);
			} else if (option == 5) { // view food
				viewFood(foodList);
			} else if (option == 6) { // delete food
				int id = Helper.readInt("Enter id of food to delete > ");
				foodToDelete(foodList, id);

			} else if (option == 7) {
				purchaseOrder po = inputPO(poList);
				addPurchaseOrder(poList, po);
			} else if (option == 8) {
				viewPurchaseOrder(poList);
			} else if (option == 9) {
				String ingredientDel = Helper.readString("Enter ingredient name to delete > ");
				deletePurchaseOrder(poList, ingredientDel);
			} else if (option == 10) {
				//
				// addPromo(promoList);
				Promo f = inputPromo();
				addPromo(promoList, f);
			} else if (option == 11) {
				//
				// viewPromo(promoList);
				viewPromo(promoList);
			} else if (option == 12) {
				//
				// deletePromo(promoList);
				String PromoName = Helper.readString("Enter Promotion name of the promotion to delete > ");

				PromoToDelete(promoList, PromoName);

			} else if (option == 13) {
				// Add Order
				Order o = inputOrder(foodList, orderList);
				addOrder(orderList, o);
			} else if (option == 14) {
				// View Order
				viewOrder(orderList);
			} else if (option == 15) {
				// Delete Order
				int id = Helper.readInt("Enter Food Item ID to remove for OrderList > ");
				deleteOrder(orderList, id);
			} else if (option == 16) {
				System.out.println("We are sad to see you go =("); // added a goodbye message when application quit - TY
			} else {
				System.out.println("Invalid option entered.");
			}
		}
	}

	// ==========================================================================================================================
	public static void menu() {
		C206_CaseStudy.setHeader("OPTIONS MENU");
		C206_CaseStudy.setHeader("STALLS");
//		menuHeader();
//		stallHeader();
		manageStalls();// Umar code review

		C206_CaseStudy.setHeader("FOOD");
		manageFood(); // TY code review

		C206_CaseStudy.setHeader("PURCHASE ORDER");
		managePurchaseOrders();// WH code review

		C206_CaseStudy.setHeader("PROMOTION OFFERS");
		managePromotion(); // YY code review

		C206_CaseStudy.setHeader("CUSTOMER");
		manageOrders(); // Adam code review

		C206_CaseStudy.setHeader("EXIT");
		System.out.println("16. Exit");

	}

	public static void setHeader(String header) { // Ty - code review
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	// =========================================STALL
	// METHODS=========================================================

	private static void manageStalls() {
		System.out.println(" 1. Add stall"); // Umar
		System.out.println(" 2. View stalls"); // Umar
		System.out.println(" 3. Delete stall"); // Umar
	}

	public static String retrieveAllStalls(ArrayList<Stall> stallList) {
		Helper.line(80, "=");
		System.out.println("STALL LIST");
		String output = String.format("%-25s %-25s %-25s %-25s\n", "Store Number", "Store Name", "Owner Name",
				"Operation Date");

		for (int i = 0; i < stallList.size(); i++) {
			if (stallList.get(i) != null) {
				output += String.format("%-25s %-25s\n", i + 1, stallList.get(i).toStringStall());
			}
		}
		return output;
	}

	public static void viewStall(ArrayList<Stall> stallList) {
		String output = retrieveAllStalls(stallList);
		System.out.println(output);
	}

	private static void viewStallIfElse(ArrayList<Stall> stallList) {
		if (stallList.isEmpty() == true) {
			System.out.println("List is empty!");
		} else {
			viewStall(stallList);

		}
	}

	private static void deleteStallIfElse(ArrayList<Stall> stallList) {
		if (stallList.isEmpty() == true) {
			System.out.println("No stalls available!");
		} else {
			int stallNo = inputStallNoRemove();
			deleteStall(stallList, stallNo);
		}
	}

	public static void deleteStall(ArrayList<Stall> stallList, int stallNo) {

		for (int i = 0; i < stallList.size(); i++) {
			if (stallList.get(i) != null) {
				stallList.remove(stallNo - 1);
				System.out.println("Stall deleted!");
				break;
			} else {
				System.out.println("No stall found!");
			}
		}
	}

	public static int inputStallNoRemove() {

		int deleteStallNo = Helper.readInt("Enter store number to delete > ");
		return deleteStallNo;
	}

	private static void addStallInputMethodMenu(ArrayList<Stall> stallList) {
		Stall stall = inputStall();
		addStall(stallList, stall);
	}

	public static void addStall(ArrayList<Stall> stallList, Stall stall) {
		stallList.add(stall);
		System.out.println("Stall added!");
	}

	public static Stall inputStall() {
		Stall stall = null;

		String storeName = Helper.readString("Please enter the name of the store > ");
		String ownerName = Helper.readString("Enter the name of the stall owner > ");
		String operationDate = Helper.readString("Please enter operation date of the store (DD/MM/YYYY) > ");

		stall = new Stall(storeName, ownerName, operationDate);
		return stall;
	}

	// ==============================================END OF
	// STALL==========================================================================
	// METHODS============================================================================================================================
	// =================================== FOOD METHODS by TY
	// ============================================================================
	private static void manageFood() { // options
		System.out.println(" 4. Add Food");
		System.out.println(" 5. View Food");
		System.out.println(" 6. Delete Food");
	}

	public static void viewFood(ArrayList<Food> foodList) {
		C206_CaseStudy.setHeader("FOOD LIST");
		String output = String.format("%-10s %-20s %-20s %-10s\n", "ID", "FOOD NAME", "SELLING PRICE", "STALL");
		if (retrieveFood(foodList).isEmpty()) {
			System.out.println("Food List is empty!");
		} else {
			output += retrieveFood(foodList);
			System.out.println(output);
		}
	}

	public static String retrieveFood(ArrayList<Food> foodList) {
		String output = "";

		for (Food f : foodList) {
			output += String.format("%-10s %-20s $%-20s %-10s\n", f.getId(), f.getName(), f.getPrice(), f.getStall());
		}
		return output;
	}

	public static Food inputFood() { // input details of new food
		int idFood = Helper.readInt("Enter id for food > ");
		String nameFood = Helper.readString("Enter name of food > ");
		int priceFood = Helper.readInt("Enter selling price of food ($3 - $15)> ");
		if (priceFood >= 3 && priceFood <= 15) {
			String stallFood = Helper.readString("Enter stall > ");
			Food f = new Food(idFood, nameFood, priceFood, stallFood);
			return f;
		} else {
			System.out.println("Selling price must be between $3 to $15!");
			return null;
		}

	}

	public static void addFood(ArrayList<Food> foodList, Food f) { // add the new food into list
		foodList.add(f);
		System.out.println("Food added!");
	}

	public static void foodToDelete(ArrayList<Food> foodList, int id) {
		boolean isValid = false;
		if (foodList.isEmpty()) {
			System.out.println("Food List is empty");
		} else {
			for (int i = 0; i < foodList.size(); i++) {
				if (foodList.get(i).getId() == id) {

					isValid = true;
					System.out.printf("%-10s %-20s %-20s %-10s\n", "ID", "FOOD NAME", "SELLING PRICE", "STALL");
					foodList.get(i).display();
					String confirm = Helper.readString("Are you sure you want to delete? (Y/N) > ");
					if (confirm.equalsIgnoreCase("y")) {
						foodList.remove(foodList.get(i));
						System.out.println("Delete success!");
					}
				}
			}
			if (isValid == false) {

				System.out.println("Food does not exist!");

			}
		}
	}

//==============================================END OF FOOD===========================================================================
// ==========================================START OF PURCHASE ORDERS METHODS BY WH===================================================
	private static void managePurchaseOrders() {
		System.out.println(" 7. Add purchase order"); // WH
		System.out.println(" 8. View purchase order"); // WH
		System.out.println(" 9. Delete purchase orders"); // WH
	}

	public static void viewPurchaseOrder(ArrayList<purchaseOrder> poList) {
		C206_CaseStudy.setHeader("ORDER LIST");
		String output = String.format("%-30s %-5s\n", "INGREDIENTS", "QUANTITY");
		if (poList.isEmpty()) {
			System.out.println("Purchase Order List is empty!");
		} else {
			output += retrievePO(poList);
			System.out.println(output);
		}
	}

	public static String retrievePO(ArrayList<purchaseOrder> poList) {
		String output = "";

		for (purchaseOrder po : poList) {
			output += String.format("%-30s %-5s\n", po.getIngredient(), po.getQuantity());
		}
		return output;
	}

	public static purchaseOrder inputPO(ArrayList<purchaseOrder> poList) {
		purchaseOrder po = null;
		String poIngredient = Helper.readString("Please enter the Ingredient name > ");
		int poQuantity = Helper.readInt("Please enter the Ingredient quantity > ");

		po = new purchaseOrder(poIngredient, poQuantity);

		return po;
	}

	public static void addPurchaseOrder(ArrayList<purchaseOrder> poList, purchaseOrder po) {
		if (poList.size() != 8) {
			poList.add(po);
			System.out.println("Purchase order added!");
		} else {
			System.out.println("Adding failed! Purchase Order list is full for the day!");
		}
	}

	public static void deletePurchaseOrder(ArrayList<purchaseOrder> poList, String Ingredient) {
		boolean isValid = false;
		if (poList.isEmpty()) {
			System.out.println("Purchase Order List is empty");
		} else {
			for (int i = 0; i < poList.size(); i++) {
				if (poList.get(i).getIngredient().equalsIgnoreCase(Ingredient)) {

					isValid = true;
					System.out.printf("%-30s %-5s\n", "INGREDIENTS", "QUANTITY");
					poList.get(i).display();
					String confirm = Helper.readString("Are you sure you want to delete? (Y/N) > ");
					if (confirm.equalsIgnoreCase("y")) {
						poList.remove(poList.get(i));
						System.out.println("Delete success!");
					}
				}
			}
			if (isValid == false) {
				System.out.println("Purchase Order does not exist!");
			}
		}
	}

// ============================================END OF PURCHASE ORDERS METHODS=========================================================
// ================================================START OF PROMOTION METHODS BY YY===================================================
	private static void managePromotion() {
		System.out.println("10. Add promotion offer"); // YY
		System.out.println("11. View promotion offers"); // YY
		System.out.println("12. Delete promotion offer"); // YY
	}

	public static void viewPromo(ArrayList<Promo> promoList) {
		C206_CaseStudy.setHeader("PROMOTION LIST");
		String output = String.format("%-30s %-20s\n", "PROMOTION OFFERS NAME", "DESCRIPTION");
		if (retrievePromo(promoList).isEmpty()) {
			System.out.println("Promotion List is empty!");
		} else {
			output += retrievePromo(promoList);
			System.out.println(output);
		}
	}

	public static String retrievePromo(ArrayList<Promo> promoList) {
		String output = "";

		for (Promo f : promoList) {
			output += String.format("%-30s %-20s\n", f.getPromoName(), f.gerDescription());
		}
		return output;
	}

	public static Promo inputPromo() {
		String PromoName = Helper.readString("Please enter the name of the Promotion > ");
		String Description = Helper.readString("Please enter the description of the promotion > ");

		Promo f = new Promo(PromoName, Description);
		return f;

	}

	public static void addPromo(ArrayList<Promo> promoList, Promo f) {
		promoList.add(f);
		System.out.println("Promotion offer added!");
	}

	public static void PromoToDelete(ArrayList<Promo> promoList, String PromoName) {
		boolean isValid = false;
		if (promoList.isEmpty()) {
			System.out.println("Promotion List is empty");
		} else {
			for (int i = 0; i < promoList.size(); i++) {
				if (promoList.get(i).getPromoName().equalsIgnoreCase(PromoName)) {

					isValid = true;
					System.out.printf("%-30s %-20s\n", "PROMOTION OFFERS NAME", "DESCRIPTION");
					promoList.get(i).display();
					;
					String confirm = Helper.readString("Are you sure you want to delete? (Y/N) > ");
					if (confirm.equalsIgnoreCase("y")) {
						promoList.remove(promoList.get(i));
						System.out.println("Delete success!");
					}
				}
			}
			if (isValid == false) {

				System.out.println("Promotion does not exist!");

			}
		}
	}

// =============================================== END OF PROMOTION METHODS =======================================================
// =======================================START OF ORDERS BY CUSTOMERS METHODS BY ADAM=============================================
	private static void manageOrders() {
		System.out.println("13. Add food item to order"); // Adam
		System.out.println("14. View food order"); // Adam
		System.out.println("15. Delete food item from order"); // Adam
	}

	public static void viewOrder(ArrayList<Order> orderList) {
		C206_CaseStudy.setHeader("ORDER LIST");
		String output = String.format("%-20s %-20s %-20s %-20s %-10s\n", "FOOD ITEM ID", "FOOD NAME", "STALL", "PRICE",
				"QUANTITY");
		if (orderList.isEmpty()) {
			System.out.println("Order List is empty!");
		} else {
			output += retrieveOrder(orderList);
			System.out.println(output);
		}
	}

	public static String retrieveOrder(ArrayList<Order> orderList) {
		String output = "";
		int total = 0;

		for (Order o : orderList) {
			output += String.format("%-20s %-20s %-20s $%-20s %-10s\n", o.getId(), o.getName(), o.getStall(),
					o.getPrice(), o.getQuantity());
			total += o.getTotalPrice();

		}
		output += "Total Price: $" + total;
		return output;
	}

	public static Order inputOrder(ArrayList<Food> foodList, ArrayList<Order> orderList) { // input details of new Order
		Order o = null;
		int total = 0;
		for (Order o1 : orderList) {
			total += o1.getQuantity();
		}
		if (total < 5) {
			int foodItemID = Helper.readInt("Enter Food Item ID > ");
			int quantity = Helper.readInt("Enter Quantity > ");

			for (Order i : orderList) {
				total += quantity;
				i.setTotalQuantity(total);
			}
			if (total <= 5) {
			for (Food f : foodList) {
				if (foodItemID == f.getId()) {

					int totalPrice = quantity * f.getPrice();
					o = new Order(foodItemID, f.getName(), f.getPrice(), f.getStall(), quantity, totalPrice);

				}
			}
//
		}
		}if (total>5) {
			System.out.println("Only a maximum of 5 items are allowed!");
		}

		return o;
	}

	public static void addOrder(ArrayList<Order> orderList, Order o) { // add the new Order into list
		if (o != null) {
			orderList.add(o);
			System.out.println("Food Item added!");
		} else {
			System.out.println("");
		}
	}

	public static void deleteOrder(ArrayList<Order> orderList, int id) {
		boolean isValid = false;
		if (orderList.isEmpty()) {
			System.out.println("Order List is empty");
		} else {
			for (int i = 0; i < orderList.size(); i++) {
				if (orderList.get(i).getId() == id) {

					isValid = true;
					System.out.printf("%-20s %-20s %-20s $%-20s %-10s\n", "ID", "FOOD NAME", "STALL", "SELLING PRICE",
							"TOTAL PRICE");
					orderList.get(i).display();
					String confirm = Helper.readString("Are you sure you want to delete? (Y/N) > ");
					if (confirm.equalsIgnoreCase("y")) {
						orderList.remove(orderList.get(i));
						System.out.println("Delete successfully!");
					}
				}
			}
			if (isValid == false) {

				System.out.println("Food does not exist!");

			}
		}
	}
	
	// ===========================================END OF ORDERS BY CUSTOMERS METHODS
	// ======================================================
}
