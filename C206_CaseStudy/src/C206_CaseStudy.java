import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		ArrayList<Stall> stallList = new ArrayList<Stall>(10);
		ArrayList<Food> foodList = new ArrayList<Food>();
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
			} else if (option == 4) { //add food
				Food f = inputFood();
				addFood(foodList, f);
			} else if (option == 5) { // view food
				viewFoodMenu(foodList);
			} else if (option == 6) { // delete food
				int id = Helper.readInt("Enter id of food to delete > ");
				deleteFood(foodList,id);
			} else if (option == 7) {
				//
			} else if (option == 8) {
				//
			} else if (option == 9) {
				//
			} else if (option == 10) {
				//
			} else if (option == 11) {
				//
			} else if (option == 12) {
				//
			} else if (option == 13) {
				//
			} else if (option == 14) {
				//
			} else if (option == 15) {
				//
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
		manageStalls();// Umar
		
		C206_CaseStudy.setHeader("FOOD");
		manageFood(); //TY
		
		C206_CaseStudy.setHeader("PURCHASE ORDER");
		System.out.println(" 7. Add purchase order"); // WH
		System.out.println(" 8. Delete purchase order"); // WH
		System.out.println(" 9. View purchase orders"); // WH
		
		C206_CaseStudy.setHeader("PROMOTION OFFERS");
		System.out.println("10. Add promotion offer"); // YY
		System.out.println("11. View promotion offers"); // YY
		System.out.println("12. Delete promotion offer"); // YY
		
		C206_CaseStudy.setHeader("CUSTOMER");
		System.out.println("13. Add food item to order"); // Adam
		System.out.println("14. View food order"); // Adam
		System.out.println("15. Delete food item from order"); // Adam
		
		
		C206_CaseStudy.setHeader("EXIT");
		System.out.println("16. Exit");

	}

public static void setHeader(String header) { // Ty - i think we can just use this to set the header, to make our codes simpler
	Helper.line(80, "-");
	System.out.println(header);
	Helper.line(80, "-");
}
//	private static void menuHeader() {
//		Helper.line(80, "=");
//		System.out.println("MENU");
//		Helper.line(80, "=");
//	}

	// START OF STALL METHODS===========================================================================================
//	private static void stallHeader() {
//		System.out.println("Stalls");
//		Helper.line(80, "=");
//	}

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

	// END OF STALL METHODS===========================================================================================

	// =================================== FOOD METHODS by TY =============================================================================
	private static void manageFood() {
		System.out.println(" 1. Add Food"); 
		System.out.println(" 2. View Food"); 
		System.out.println(" 3. Delete Food"); 
	}

	public static void viewFoodMenu(ArrayList<Food> foodList) { // print food menu
		C206_CaseStudy.setHeader("FOOD MENU");
		System.out.printf("%-10s %-20s %-20s %-10s\n", "ID", "FOOD NAME", "SELLING PRICE", "STALL");
		for (Food f : foodList) {
			f.display();
		}
	}

	public static Food inputFood() {
		int idFood = Helper.readInt("Enter id for food > ");
		String nameFood = Helper.readString("Enter name of food > ");
		int priceFood = Helper.readInt("Enter selling price of food ($3 - $15)> ");
		if(priceFood >= 3 && priceFood <=15) {
		String stallFood = Helper.readString("Enter stall > ");
		Food f = new Food(idFood, nameFood, priceFood, stallFood);
		return f;
		}else {
			System.out.println("Selling price must be between $3 to $15!");
			return null;
		}
		
	}
	public static void addFood(ArrayList<Food> foodList, Food f) { 
	foodList.add(f);
	System.out.println("Food added!");
	}

	public static void deleteFood(ArrayList<Food> foodList, int id) { //delete 
		
		boolean isValid = false;

		for (Food f : foodList) {
			if (f.getId() == id) {
				System.out.printf("%-10s %-20s %-20s %-10s\n", "ID", "FOOD NAME", "SELLING PRICE", "STALL");
				f.display();
				isValid = true;
				String confirm = Helper.readString("Are you sure you want to delete this? (Y/N)> ");
				if (confirm.equalsIgnoreCase("y")) {
					foodList.remove(f);
					System.out.println("Delete success!");
					break;
				}
			}
			
		
		}	if (isValid == false) {
			System.out.println("Food Id does not exist!");
		}

	}
//==============================================END OF FOOD===============================================================================
}
