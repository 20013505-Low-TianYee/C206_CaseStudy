import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class C206_CaseStudyTest { 
	private Stall stall1;
	private Stall stall2;
	private Food f1;
	private Food f2;
	private purchaseOrder po1;
	private purchaseOrder po2;
	private Promo p1;//
	private Promo p2;
	private Order o1;
	private Order o2;

	private ArrayList<Stall> stallList = new ArrayList<Stall>(10);

	private ArrayList<Food> foodList = new ArrayList<Food>();

	private ArrayList<purchaseOrder> poList = new ArrayList<purchaseOrder>(8);

	private ArrayList<Promo> promoList = new ArrayList<Promo>();
	private ArrayList<Order> orderList = new ArrayList<Order>();

	// ==============================================
	@Before
	public void setUp() throws Exception {

		// stall
		stall1 = new Stall("Froot", "Jack", "22/05/2021");
		stall2 = new Stall("Helperoo", "Ruth", "29/03/2019");
		// food
		f1 = new Food(1, "Fries", 3, "Froot");
		f2 = new Food(2, "Rice", 15, "Helperoo");
		// purchaseOrder
		po1 = new purchaseOrder("Potato", 1, "Froot");
		po2 = new purchaseOrder("Apple", 2, "Froot");
		// promotions
		p1 = new Promo("Froot", "Jack", "22/05/2021", "Free delivery", "$0 Delivery Fee(min.$20 spend)");
		p2 = new Promo("Froot", "Jack", "22/05/2021", "20% off Rice", "Available at selected outlets");
		// order
		o1 = new Order(1, "Fries", 3, "Froot", 2, 6);
		o2 = new Order(2, "Rice", 15, "Helperoo", 2, 30);

	}

	@After
	public void tearDown() throws Exception {
		stall1 = null;
		stall2 = null;
		f1 = null;

		f2 = null;
		p1 = null;
		p2 = null;

		f2 = null;
		po1 = null;
		po2 = null;
		p1 = null;
		p2 = null;

		stallList = null;
		foodList = null;
		promoList = null;
	}

	@Test
	public void c206_test() {
		// fail("Not yet implemented");
		assertTrue("C206_CaseStudy_SampleTest ", true);
	}

	// STALL
	// TESTS=====================================================================================================
	// Done by: Umar
	@Test
	public void testAddStall() {
		C206_CaseStudy.addStall(stallList, stall1);
		assertNotNull("Test if stall is not empty after adding to the list.", stallList);

		assertEquals("Test that the size of the list is 1 after adding.", 1, stallList.size());

		C206_CaseStudy.addStall(stallList, stall2);
		assertEquals("Test that size of list is updated to 2", 2, stallList.size());
	}

	@Test
	public void testViewStall() {
		assertNotNull("Test if stall is not empty and can be displayed to the output.", stallList);

		String allStalls = C206_CaseStudy.retrieveAllStalls(stallList);
		String testOutput = String.format("%-25s %-25s %-25s %-25s\n", "Store Number", "Store Name", "Owner Name",
				"Operation Date");
		assertEquals("Check that list is stall list is empty", testOutput, allStalls);

		C206_CaseStudy.addStall(stallList, stall1);
		C206_CaseStudy.addStall(stallList, stall2);
		assertEquals("Test if that stall arraylist size is 2?", 2, stallList.size());
		//
		allStalls = C206_CaseStudy.retrieveAllStalls(stallList);
		// update after adding in more stalls

		testOutput += String.format("%-25s %-25s %-25s %-25s\n", 1, "Froot", "Jack", "22/05/2021");
		testOutput += String.format("%-25s %-25s %-25s %-25s\n", 2, "Helperoo", "Ruth", "29/03/2019");

		assertEquals("Check that the display outputs are as expected", testOutput, allStalls);

	}

	@Test
	public void testDeleteStall() {
		boolean outOfBounds = false;
		C206_CaseStudy.addStall(stallList, stall1);
		assertNotNull("Test if stall list is not empty", stallList);
		assertEquals("Test if stall list size is 1, so that an element can be deleted using the function", 1,
				stallList.size());

		C206_CaseStudy.deleteStall(stallList, 1);
		assertEquals("Test if list is empty.", 0, stallList.size());

		if (stallList.size() < 0) {
			outOfBounds = true;
		} else if (stallList.size() > 10) {
			outOfBounds = true;
		}
		assertFalse("Test if size of stall is more than 10", outOfBounds);

	}
	
	@Test
	public void testUpdateStall() {
		C206_CaseStudy.addStall(stallList, stall1);
		assertNotNull("Test if list is not empty", stallList);
		assertEquals("Test if the stall list size is 1 so that there is an element that can be updated.", 1, stallList.size());
		
		String testOutput = String.format("%-25s %-25s %-25s %-25s\n", "Store Number", "Store Name", "Owner Name",
				"Operation Date");
		testOutput += String.format("%-25s %-25s %-25s %-25s\n", 1, "Froot", "Jack", "22/05/2021");
		String allStalls = C206_CaseStudy.retrieveAllStalls(stallList);
		assertEquals("Check that stall output is same before update", testOutput, allStalls);
		
		C206_CaseStudy.updateStallMethod(stallList, "Freta", "23/04/2021", "Froot");
		allStalls = C206_CaseStudy.retrieveAllStalls(stallList);
		String testOutput2 = String.format("%-25s %-25s %-25s %-25s\n", "Store Number", "Store Name", "Owner Name",
				"Operation Date");
		testOutput2 += String.format("%-25s %-25s %-25s %-25s\n", 1, "Freta", "Jack", "23/04/2021");
		assertEquals("Test that stall output is same as expected output after update", testOutput2, allStalls);

		}

	// END OF STALL
	// TESTS==============================================================================================
	// fOOD TESTS
	// ======================================================================================================
	//done by TY
		@Test
		public void testAddFood() {

			assertNotNull("Test that there is a Food arrayList to add to", foodList);

			C206_CaseStudy.addFood(foodList, f1);
			assertEquals("Test if foodList size is 1 after adding one object.", 1, foodList.size());
			assertTrue("Test that price is more than or equals $3", f1.getPrice() >= 3);
			assertTrue("Test that price is less than or equals $15", f1.getPrice() <= 15);

			C206_CaseStudy.addFood(foodList, f2);
			assertEquals("Test if foodList size is 2 after 2 objects are added.", 2, foodList.size());
			assertTrue("Test that price is more than or equals $3", f2.getPrice() >= 3);
			assertTrue("Test that price is less than or equals $15", f2.getPrice() <= 15);

		}

		@Test
		public void testViewFood() {
			assertNotNull("Test if there is valid Food arraylist to be displayed from", foodList);
			String food = C206_CaseStudy.retrieveFood(foodList);
			String testOutput = String.format("%-10s %-20s %-20s %-10s\n", "ID", "FOOD NAME", "SELLING PRICE", "STALL");
			assertEquals("Test that list is empty in the beginning", testOutput, food);

			C206_CaseStudy.addFood(foodList, f1);
			C206_CaseStudy.addFood(foodList, f2);
			assertEquals("Test if foodList size is 2 after 2 objects are added.", 2, foodList.size());

			food = C206_CaseStudy.retrieveFood(foodList);
			testOutput += String.format("%-10s %-20s $%-20s %-10s\n", 1, "Fries", 3, "Froot");
			testOutput += String.format("%-10s %-20s $%-20s %-10s\n", 2, "Rice", 15, "Helperoo");
			assertEquals("Test that output is in the correct format", testOutput, food);
		}

		@Test
		public void testDeleteFood() {
			assertNotNull("Test if there is valid Food arraylist to delete objects", foodList);
			C206_CaseStudy.addFood(foodList, f1);
			C206_CaseStudy.addFood(foodList, f2);
			C206_CaseStudy.foodToDelete(foodList, f1.getId());
			assertEquals("Test if foodList size is 1 after deleting one object", 1, foodList.size());
			C206_CaseStudy.foodToDelete(foodList, f2.getId()); 
			assertEquals("Test if that Food arraylist is empty", 0, foodList.size());
		}
		
		@Test
		public void testUpdateFood() {
			assertNotNull("Test if there is valid Food arraylist to update objects", foodList);
			C206_CaseStudy.addFood(foodList, f1);
			C206_CaseStudy.addFood(foodList, f2);
			C206_CaseStudy.priceToUpdate(foodList, f1.getId());
			double newPriceD = f1.getPrice() * 1.3;
			int newPrice = (int) Math.round(newPriceD);
			f1.setPrice(newPrice);
			assertEquals("Test if price is increased by 30%",newPrice,f1.getPrice() );
			
		}
		
		

		// END OF FOOD
		// =======================================================================================================
		// PROMO
		// TEST==========================================================================================================
		@Test
		public void testAddPromo() {

			assertNotNull("Test that there is a Promo arrayList to add to", promoList);

			C206_CaseStudy.addPromo(promoList, p1);
			assertEquals("Test if promoList size is 1 ?", 1, promoList.size());

			C206_CaseStudy.addPromo(promoList, p2);
			assertEquals("Test if promoList size is 2 ?", 2, promoList.size());

		}

		@Test
		public void testRetrievePromo() {
			assertNotNull("Test if there is valid Promo arraylist to retrieve from", promoList);
			String pro = C206_CaseStudy.retrievePromo(promoList);
			String testOutput = "";
			assertEquals("Test that list is empty in the beginning", testOutput, pro);

			C206_CaseStudy.addPromo(promoList, p1);
			C206_CaseStudy.addPromo(promoList, p2);
			assertEquals("Test if that Promo arraylist size is 2?", 2, promoList.size());

			pro = C206_CaseStudy.retrievePromo(promoList);
			testOutput = String.format("%-30s %-30s %-20s\n",p1.getPromoName(), p1.gerDescription(), p1.getStoreName());
			testOutput += String.format("%-30s %-30s %-20s\n", p2.getPromoName(), p2.gerDescription(), p2.getStoreName());
			assertEquals("Test that output is in the correct format", testOutput, pro);
		}

		@Test
		public void testDeletePromo() {
			assertNotNull("Test if there is valid Promo arraylist to delete objects", promoList);
			C206_CaseStudy.addPromo(promoList, p1);
			C206_CaseStudy.addPromo(promoList, p2);
			C206_CaseStudy.PromoToDelete(promoList, p1.getPromoName());
			assertEquals("Test if that Promo arraylist size is 1?", 1, promoList.size());
			C206_CaseStudy.PromoToDelete(promoList, p2.getPromoName());
			assertEquals("Test if that Promo arraylist is empty", 0, promoList.size());
		}
		// END OF PROMO
		// =======================================================================================================
	// START OF PURCHASE ORDER ========================================================================================================

	//By WH	
		@Test
		public void testAddPurchaseOrder() {
			assertNotNull("Test that there is a purchaseOrder arrayList to add to", poList);
			C206_CaseStudy.viewPurchaseOrder(poList);
			C206_CaseStudy.addPurchaseOrder(poList, po1);
			assertEquals("Test if purchaseOrder arraylist size is 1?", 1, poList.size());
			C206_CaseStudy.addPurchaseOrder(poList, po1);
			assertEquals("Test if purchaseOrder arraylist size is 2?", 2, poList.size());
		}

		@Test
		public void testviewPurchaseOrder() {
			assertNotNull("Test that there is a list of ingredients", poList);
			C206_CaseStudy.viewPurchaseOrder(poList);
			assertNotNull("Check if there is valid purchaseOrder arraylist to view", poList);
		}

		@Test
		public void testDeletePurchaseOrder() {
			assertNotNull("Test if there is valid Food arraylist to delete objects", poList);
			C206_CaseStudy.addPurchaseOrder(poList, po1);
			C206_CaseStudy.addPurchaseOrder(poList, po2);
			C206_CaseStudy.deletePurchaseOrder(poList, po1.getIngredient());
			assertEquals("Test if that Food arraylist size is 1?", 1, poList.size());
			C206_CaseStudy.deletePurchaseOrder(poList, po2.getIngredient());
			assertEquals("Test if that Food arraylist is empty", 0, poList.size());
		}

	//END OF PURCHASE ORDER =========================================================================================================
	//START OF ORDERS BY CUSTOMER======================================================================================================
	// By Adam
		@Test
		public void testAddOrder() {

			assertNotNull("Test that there is a Order arrayList to add to", orderList);

			C206_CaseStudy.addOrder(orderList, o1);
			assertEquals("Test if orderlist size is 1 ?", 1, orderList.size());

			C206_CaseStudy.addOrder(orderList, o2);
			assertEquals("Test if orderlist size is 2 ?", 2, orderList.size());
		}

		@Test
		public void testRetrieveOrder() {
			assertNotNull("Test if there is valid Order arraylist to retrieve from", orderList);
			String order = C206_CaseStudy.retrieveOrder(orderList);
			String testOutput = "";
			int total = 0;

			C206_CaseStudy.addOrder(orderList, o1);
			C206_CaseStudy.addOrder(orderList, o2);
			assertEquals("Test if that Order arraylist size is 2?", 2, orderList.size());

			order = C206_CaseStudy.retrieveOrder(orderList);
			testOutput = String.format("%-20s %-20s %-20s $%-20s %-10s\n", 1, "Fries", "Froot", 3, 2);

			testOutput += String.format("%-20s %-20s %-20s $%-20s %-10s\n", 2, "Rice", "Helperoo", 15, 2);
			total = o1.getTotalPrice() + o2.getTotalPrice();
			testOutput += "Total Price: $" + total;
			assertEquals("Test that output is in the correct format", testOutput, order);
		}

		@Test
		public void testDeleteOrder() {
			assertNotNull("Test if there is valid Food arraylist to delete objects", orderList);
			C206_CaseStudy.addOrder(orderList, o1);
			C206_CaseStudy.addOrder(orderList, o2);
			C206_CaseStudy.deleteOrder(orderList, o1.getId());
			assertEquals("Test if that Food arraylist size is 1?", 1, orderList.size());
			C206_CaseStudy.deleteOrder(orderList, o2.getId());
			assertEquals("Test if that Food arraylist is empty", 0, orderList.size());
		}
		
		@Test
		//INCOMPLETE
		public void testUpdateOrder() {
			assertNotNull("Test if there is valid Food arraylist to update objects", orderList);
			C206_CaseStudy.addOrder(orderList, o1);
			C206_CaseStudy.updateOrder(orderList, o1.getId());
			assertEquals("Test if that Food Item Quantity increased by 3?", 3, o1.getQuantity());
			
			
		}

	// END OF ORDERS BY CUSTOMERS =========================================================================================================

	}