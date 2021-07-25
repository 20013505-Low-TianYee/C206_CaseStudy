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
	@Test
	public void testAddStall() {		
		C206_CaseStudy.addStall(stallList, stall1);
		assertNotNull("Test if stall is empty and can be added to the list.", stallList);
		
		assertEquals("Test that the size of the list is 1 after adding.", 1, stallList.size());
		
		C206_CaseStudy.addStall(stallList, stall2);
		assertEquals("Test that size of list is updated to 2", 2, stallList.size());
	}
	@Test
	public void testViewStall() {
		
	}
	@Test
	public void testDeleteStall() {
		
	}
	@Test
	public void testUpdateStall() {
		
	}

}
