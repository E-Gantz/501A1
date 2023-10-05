import static org.junit.Assert.*;
import org.junit.Test;
public class PlayerTest {
	
	@Test
	public void test1() {
		Player p1 = new Player();
		Item i1 = new Item(1, "key");
		p1.addItem(i1);
		assertTrue(p1.hasItem(i1));
	}
	
	@Test
	public void test2() {
		Player p1 = new Player();
		p1.startHealth(1);
		assertTrue(p1.getHealth() == 5);
	}
	
	@Test
	public void test3() {
		Player p1 = new Player();
		p1.startItems(1);
		Item i1 = new Item(1, "Fire Key");
		assertTrue(p1.hasItem (i1));
	}
	
	@Test
	public void test4() {
		Player p1 = new Player();
		p1.startHealth(1);
		p1.updateHealth(2);
		assertTrue(p1.getHealth() == 3);
	}
	
	@Test
	public void test5() {
		Player p1 = new Player();
		p1.startHealth(1);
		p1.updateHealth(4);
		assertTrue(p1.isAlive());
	}
	
	@Test
	public void test6() {
		Player p1 = new Player();
		p1.startHealth(1);
		p1.updateHealth(5);
		assertTrue(!(p1.isAlive()));
	}
}