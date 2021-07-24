
public class C206_CaseStudy {

	public static void main(String[] args) {
		Stall[] stallList = new Stall[10];
		
		int option = 0;
		
		while (option != 16) {
			menu();
			option = Helper.readInt("Enter choice > ");
		}
			if (option == 1) {
				addStall();
			}
			else if (option == 2) {
				viewStall();
			}
			else if (option == 3) {
				deleteStall();
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
	public static void menu() {
		Helper.line(40, "=");
		System.out.println("MENU");
		Helper.line(40, "=");
		System.out.println("Stalls");
		Helper.line(40, "=");
		System.out.println("1. Add stall");
		System.out.println("2. View stalls");
		System.out.println("3. Delete stall");


	}
	public static void addStall() {
		
	}
	public static void viewStall() {
		
	}
	public static void deleteStall() {
		
	}
}
