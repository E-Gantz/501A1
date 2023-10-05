import static org.junit.Assert.*;
import org.junit.Test;


public class ChallengeTest {
	//test level 1
	private boolean lessThanTwenty() {
		boolean rightQuestionNum = false;
		Challenge c = new Challenge(1,false);
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
		Challenge c = new Challenge(2,false);
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
		Challenge c = new Challenge(3,false);
		if (c.getQuestionNum() < 60 && c.getQuestionNum() >= 40){
			rightQuestionNum = true; 
			}
		return rightQuestionNum;
	}
	
	@Test 
	public void test_pickQuestionNumLevel3 (){
		assertTrue("Level 3 should have questionNum between 40 and 59", betweenFortyandSixty());
		}
		
	//test Nemesis questionNum and level 2
	private boolean nemesisLevelTwo() {
		boolean rightQuestionNum = false;
		Challenge c = new Challenge(2,true);
		if (c.getQuestionNum() < 60 && c.getQuestionNum() >= 40){
			rightQuestionNum = true; 
			}
		return rightQuestionNum;
	}
	
	@Test 
	public void test_pickQuestionNumLevel2andNemesis (){
		assertTrue("Level 2 with Nemesis should have questionNum between 40 and 59", nemesisLevelTwo());
		}
		
	//test Nemesis questionNum and level 1
	private boolean nemesisLevelOne() {
		boolean rightQuestionNum = false;
		Challenge c = new Challenge(1,true);
		if (c.getQuestionNum() < 40 && c.getQuestionNum() >= 20){
			rightQuestionNum = true; 
			}
		return rightQuestionNum;
	}
	
	@Test 
	public void test_pickQuestionNumLevel1andNemesis (){
		assertTrue("Level 1 with Nemesis should have questionNum between 20 and 39", nemesisLevelOne());
		}
	
	
	//test nemesis appears 
	@Test
	public void test_NemesisAppearsTrue(){
		Challenge c = new Challenge(1,true);
		assertEquals("Difficulty should go up if nemesis appears",2,c.getDifficulty());
	}
	
	
		@Test
	public void test_NemesisAppears1False(){
		Challenge c = new Challenge(1,false);
		assertEquals("Difficulty should not go up without nemesis appears",1,c.getDifficulty());
	
	}
	
			@Test
	public void test_NemesisAppears2False(){
		Challenge c = new Challenge(2,false);
		assertEquals("Difficulty should not go up without nemesis appears",2,c.getDifficulty());
	
	}
	
	//test checkValidInput with space
	private boolean testCheckValidInput() {
		boolean valid = false;
		Challenge c = new Challenge(1,true);
		if (!(c.checkValidInput("try this"))){
			valid = true; 
			}
		return valid;
	}
	
	@Test 
	public void test_checkValidInputWithSpace (){
		assertTrue("Should have invalid answer if there is a space in the answer", testCheckValidInput());
		}
	
	//test checkValidInput without space
	private boolean testCheckValidInputWithoutSpace() {
		boolean valid = false;
		Challenge c = new Challenge(1,true);
		if ((c.checkValidInput("tryThis"))){
			valid = true; 
			}
		return valid;
	}
	
	@Test 
	public void test_checkValidInputWithoutSpace (){
		assertTrue("Should have valid answer if there is no space in the answer", testCheckValidInputWithoutSpace());
		}
	
	@Test
	public void correctQuestionNum(){
		Challenge c = new Challenge(1, false, 11);
		assertTrue(c.getQuestionNum() == 11);
	}

	/*@Test
	public void correctQuestion(){
		Challenge c = new Challenge(1, false, 2);
		assertEquals(c.getQuestion(), "What has to be broken before you can use it?");
	}*/
}