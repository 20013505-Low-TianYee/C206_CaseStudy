import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class C206_CaseStudyTest {
	//stall
	private Stall stall1= new Stall("Froot", "Jack", "22/05/2021");
	private Stall stall2= new Stall("Helperoo", "Ruth", "29/03/2019");
	
	private ArrayList<Stall> stallList = new ArrayList<Stall>(10);

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
		
//				test if the list of camcorders retrieved from the SourceCentre is empty
//						String allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
//						String testOutput = "";
//						assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
//						
//				Given an empty list, after adding 2 items, test if the size of the list is 2
//				ResourceCentre.addCamcorder(camcorderList, cc1);
//				ResourceCentre.addCamcorder(camcorderList, cc2);
//				assertEquals("Test if that Camcorder arraylist size is 2?", 2, camcorderList.size());
//				
//				test if the expected output string same as the list of camcorders retrieved from the SourceCentre
//				allCamcorder= ResourceCentre.retrieveAllCamcorder(camcorderList);
//
//				testOutput = String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0011", "Nikon HDSLR", "Yes", "", 40);
//				testOutput += String.format("%-10s %-30s %-10s %-10s %-20d\n","CC0012", "Sony DSC-RX100M7", "Yes", "", 20);
//			
//				assertEquals("Check that ViewAllCamcorderlist", testOutput, allCamcorder);
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
		assertNotNull("Test if stall is not empty so that stall can be deleted.", stallList);
		
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
}
