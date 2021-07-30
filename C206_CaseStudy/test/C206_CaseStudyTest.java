import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class C206_CaseStudyTest {
	//stall
	private Stall stall1= new Stall("Froot", "Jack", "22/05/2021");
	private Stall stall2= new Stall("Helperoo", "Ruth", "29/03/2019");
	
	private Food f1 = new Food(1,"Fries",3 );
	private Food f2 = new Food(2,"Fries",3 );
	private Food f3 = new Food(3,"Fries",3 );
	
	
	private ArrayList<Stall> stallList = new ArrayList<Stall>(10);
	private ArrayList<Food> foodList = new ArrayList<Food>(10);
	//=============================================
	@Before
	public void setUp() throws Exception {

		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}
	//STALL TESTS=====================================================================================================
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
		String testOutput = String.format("%-25s %-25s %-25s %-25s\n", "Store Number", "Store Name", "Owner Name", "Operation Date");
		assertEquals("Check that list is stall list is empty", testOutput, allStalls);
		
		C206_CaseStudy.addStall(stallList, stall1);
		C206_CaseStudy.addStall(stallList, stall2);
		assertEquals("Test if that stall arraylist size is 2?", 2, stallList.size());
		//
		allStalls = C206_CaseStudy.retrieveAllStalls(stallList);
		//update after adding in more stalls
		
		testOutput += String.format("%-25s %-25s %-25s %-25s\n", 1, "Froot", "Jack", "22/05/2021");
		testOutput += String.format("%-25s %-25s %-25s %-25s\n", 2, "Helperoo", "Ruth", "29/03/2019");
		
		assertEquals("Check that the display outputs are as expected", testOutput, allStalls);


		


	}
	@Test
	public void testDeleteStall() {
		boolean outOfBounds = false;
		C206_CaseStudy.addStall(stallList, stall1);
		assertNotNull("Test if stall is not empty", stallList);
		assertEquals("Test if stall size is 1, so that an element can be deleted using the function", 1, stallList.size());
		
		C206_CaseStudy.deleteStall(stallList,1);
		assertEquals("Test if list is empty.", 0 , stallList.size());
		
		if (stallList.size() < 0) {
			outOfBounds = true;
		}
		else if (stallList.size() > 10) {
			outOfBounds = true;
		}
		assertFalse("Test if size of stall is more than 10", outOfBounds);


	}
	//END OF STALL TESTS==============================================================================================
	// fOOD TESTS ======================================================================================================
	public void testAddFood() {
		
	}
	// END OF FOOD =======================================================================================================
}
