import static org.junit.Assert.*;
import org.junit.Test;

public class RoomTest {

	// Testing constructor
		@Test
		public void test_Constructor_1AndTrue() {
			Room r = new Room(1, true, 0);
			assertEquals("Created room with difficulty 1 and nemesis appearance true - testing difficulty", 1, r.getDifficulty());
			assertEquals("Created room with difficulty 1 and nemesis appearance true - testing nemesis appearance true", true, r.isNemesisRoom());
            assertEquals("Created room with difficulty 1 and nemesis appearance true - testing nemesis changed question difficulty", 2, r.getChallenge().getDifficulty());
		}
		
		@Test
		public void test_Constructor_1AndFalse() {
			Room r = new Room(3, false, 0);
			assertEquals("Created room with difficulty 3 and nemesis appearance true - testing difficulty", 3, r.getDifficulty());
			assertEquals("Created room with difficulty 3 and nemesis appearance false - testing nemesis appearance false", false, r.isNemesisRoom());
            assertEquals("Created room with difficulty 3 and nemesis appearance false - testing nemesis didn't change question difficulty", 3, r.getChallenge().getDifficulty());
		}
		
		// team ask
		@Test
		public void test_Constructor_0AndFalse() {
			Room r = new Room(0, false, 0);
			assertEquals("Created room with difficulty 0 and nemesis appearance true - testing difficulty", 0, r.getDifficulty());
			assertEquals("Created room with difficulty 0 and nemesis appearance false - testing nemesis appearance false", false, r.isNemesisRoom());
		}
		
		@Test
		public void test_Constructor_NegativeAndFalse() {
			Room r = new Room(-4, true, 0);
			assertEquals("Created room with difficulty -4 and nemesis appearance true - testing difficulty", -4, r.getDifficulty());
			assertEquals("Created room with difficulty -4 and nemesis appearance false - testing nemesis appearance true", true, r.isNemesisRoom());
		}
		
		@Test
		public void test_Constructor_10AndFalse() {
			Room r = new Room(10, true, 0);
			assertEquals("Created room with difficulty 10 and nemesis appearance true - testing difficulty", 10, r.getDifficulty());
			assertEquals("Created room with difficulty 10 and nemesis appearance true - testing nemesis appearance true", true, r.isNemesisRoom());
		}
}