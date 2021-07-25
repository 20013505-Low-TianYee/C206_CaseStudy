import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		Stall[] stallList = new Stall[10];
		
		stallList[1] = new Stall("Froot", "15/05/2021");
		stallList[4] = new Stall("Helperoo", "20/04/2020");
		
		int option = -1;
		
		while (option != 16) {
			menu();
			option = Helper.readInt("Enter choice > ");
			Helper.line(80, "=");
		
			if (option == 1) {
				addStall(stallList);
			}
			else if (option == 2) {
				viewStall(stallList);
			}
			else if (option == 3) {
				deleteStall(stallList);
			}
			else if (option == 4) {
				
			}
			else if (option == 5) {
	
			}
			else if (option == 6) {
	
			}
			else if (option == 7) {
	
			}
			else if (option == 8) {
	
			}
			else if (option == 9) {
	
			}
			else if (option == 10) {
	
			}
			else if (option == 11) {
	
			}
			else if (option == 12) {
	
			}
			else if (option == 13) {
	
			}
			else if (option == 14) {
	
			}
			else if (option == 15) {
	
			}
			else {
				System.out.println("Invalid option entered.");
			}
		}
	}
	public static void menu() {
		Helper.line(80, "=");
		System.out.println("MENU");
		Helper.line(80, "=");
		System.out.println("Stalls");
		Helper.line(80, "=");
		System.out.println("1. Add stall");
		System.out.println("2. View stalls");
		System.out.println("3. Delete stall");


	}
	public static void addStall(Stall[] stallList) {
		String storeName = Helper.readString("Please enter the name of the store > ");
		String operationDate = Helper.readString("Please enter operation date of the store (DD/MM/YYYY) > ");
		boolean isAdded = false;
		for (int i = 0; i < stallList.length; i++) {
			if (stallList[i] == null) {
				stallList[i] = new Stall(storeName,operationDate);
				isAdded = true;
				System.out.println("Stall added!");
				break;
			}
		}
		if (isAdded == false) {
			System.out.println("Stall list is full!");
		}
	}
	public static void viewStall(Stall[] stallList) {
		Helper.line(80, "=");
		String output = "";
		output = String.format("%-25s %-25s %-25s\n", "Store Number", "Store Name", "Operation Date");
		
		for (int i = 0; i < stallList.length; i++) {
			if (stallList[i] != null) {
				output += String.format("%-25s %-25s %-25s\n", i+1, stallList[i].getStoreName(), stallList[i].getOperationDate());
			}
		}
		System.out.println(output);
	}
	public static void deleteStall(Stall[] stallList) {
		int deleteStallNo = Helper.readInt("Enter store number to delete > ");
		
		for (int i = 0; i < stallList.length; i++) {
			if (stallList[deleteStallNo-1] != null) {
				stallList[deleteStallNo-1] = null;
				System.out.println("Stall deleted!");
				break;
			}
			else {
				System.out.println("No stall found!");
			}
		}
	}
}
