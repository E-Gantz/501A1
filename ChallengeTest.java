import static org.junit.Assert.*;
import org.junit.Test;


public class ChallengeTest {
	//test level 1
	private boolean lessThanTwenty() {
		boolean rightQuestionNum = false;
		Challenge c = new Challenge(1);
		if (c.getQuestionNum() < 20 && c.getQuestionNum() >= 0){
			rightQuestionNum = true; 
			}
		return rightQuestionNum;
	}
	
	@Test 
	public void test_pickQuestionNumLevel1 (){
		assertTrue("Level one should have questioNum less than 19", lessThanTwenty());
		}
	
	//test level 2	
	private boolean betweenTwentyandForty() {
		boolean rightQuestionNum = false;
		Challenge c = new Challenge(2);
		if (c.getQuestionNum() < 40 && c.getQuestionNum() >= 20){
			rightQuestionNum = true; 
			}
		return rightQuestionNum;
	}
	
	@Test 
	public void test_pickQuestionNumLevel2 (){
		assertTrue("Level 2 should have questionNum between 20 and 39", betweenTwentyandForty());
		}
	
	//test level 3
	private boolean betweenFortyandSixty() {
		boolean rightQuestionNum = false;
		Challenge c = new Challenge(3);
		if (c.getQuestionNum() < 60 && c.getQuestionNum() >= 40){
			rightQuestionNum = true; 
			}
		return rightQuestionNum;
	}
	
	@Test 
	public void test_pickQuestionNumLevel3 (){
		assertTrue("Level 3 should have questionNum between 40 and 59", betweenFortyandSixty());
		}
	
	@Test
	public void correctQuestionNum(){
		Challenge c = new Challenge(1, 11);
		assertTrue(c.getQuestionNum() == 11);
	}

	/*@Test
	public void correctQuestion(){
		Challenge c = new Challenge(1, false, 2);
		assertEquals(c.getQuestion(), "What has to be broken before you can use it?");
	}*/
}