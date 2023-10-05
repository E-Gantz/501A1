import static org.junit.Assert.*;
import org.junit.Test;
public class ItemTest {
	@Test
	public void correctID() {
		Item i1 = new Item(1,"Fire Key");
		assertTrue(i1.getId() == 1);
	}
	
	@Test
	public void correctName() {
		Item i1 = new Item(1,"Fire Key");
		assertTrue(i1.getName() == "Fire Key");
	}
	
	@Test
	public void correctCopiedID() {
		Item i1 = new Item(1,"Fire Key");
		Item i2 = new Item(i1);
		assertTrue(i2.getId() == 1);
	}
	
	@Test
	public void correctCopiedName() {
		Item i1 = new Item(1,"Fire Key");
		Item i2 = new Item(i1);
		assertTrue(i2.getName() == "Fire Key");
	}
	
	@Test
	public void correctIdNameMatching() {
		Item i1 = new Item();
		if (i1.getId() == 1 && i1.getName() == "Fire Key") {
			assertTrue(true);
		}
		else if (i1.getId() == 2 && i1.getName() == "Earth Key") {
			assertTrue(true);
		}
		else if (i1.getId() == 3 && i1.getName() == "Metal Key") {
			assertTrue(true);
		}
		else if (i1.getId() == 4 && i1.getName() == "Water Key") {
			assertTrue(true);
		}
		else if (i1.getId() == 5 && i1.getName() == "Wood Key") {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
	}
	
}