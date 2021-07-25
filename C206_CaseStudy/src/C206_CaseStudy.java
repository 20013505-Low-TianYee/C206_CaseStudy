import java.util.ArrayList;

public class C206_CaseStudy {

	public static void main(String[] args) {
		ArrayList<Stall> stallList = new ArrayList<Stall>(10);
		
		int option = -1;
		
		while (option != 16) {
			menu();
			option = Helper.readInt("Enter choice > ");
			Helper.line(80, "=");
		
			if (option == 1) {
				Stall stall = inputStall();
				addStall(stallList, stall);
			}
			else if (option == 2) {
				viewStall(stallList);
			}
			else if (option == 3) {
				deleteStall(stallList);
			}
			else if (option == 4) {
				updateStall(stallList);
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
		System.out.println("4. Update owner of stall");


	}
	public static void viewStall(ArrayList<Stall> stallList) {
		Helper.line(80, "=");
		String output = "";
		output = String.format("%-25s %-25s %-25s %-25s\n", "Store Number", "Store Name", "Owner Name", "Operation Date");
		
		for (int i = 0; i < stallList.size(); i++) {
			if (stallList.get(i) != null) {
				output += String.format("%-25s %-25s %-25s %-25s\n", i+1, stallList.get(i).getStoreName(), stallList.get(i).getOwnerName(), stallList.get(i).getOperationDate());
			}
		}
		System.out.println(output);
	}
	public static void deleteStall(ArrayList<Stall> stallList) {
		int deleteStallNo = Helper.readInt("Enter store number to delete > ");
		
		for (int i = 0; i < stallList.size(); i++) {
			if (stallList.get(i) != null) {
				stallList.remove(deleteStallNo-1);
				System.out.println("Stall deleted!");
				break;
			}
			else {
				System.out.println("No stall found!");
			}
		}
	}
	public static void addStall(ArrayList<Stall> stallList, Stall stall) {
		stallList.add(stall);
		System.out.println("Stall added!");
	}
	public static Stall inputStall() {
		Stall stall = null;
		
		String storeName = Helper.readString("Please enter the name of the store > ");
		String ownerName= Helper.readString("Enter the name of the stall owner > ");
		String operationDate = Helper.readString("Please enter operation date of the store (DD/MM/YYYY) > ");
		
		stall = new Stall(storeName, ownerName, operationDate);
		return stall;
	}
	public static void updateStall(ArrayList<Stall> stallList) {
		int storeNoRequest = Helper.readInt("Enter store number to update owner of the stall > ");
		
		if (stallList.get(storeNoRequest-1) != null) {
			String newOwner = Helper.readString("Enter new owner name > ");
			stallList.get(storeNoRequest-1).setOwnerName(newOwner);
			System.out.println("Owner name changed successfully!");
		}
		else {
			System.out.println("Stall not found!");
		}
		
	}
}
