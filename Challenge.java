import java.util.*;

public class Challenge {

	static ChallengeList singleton;
	String question;
	String solution;
	int questionNum;
	int cdifficulty;
	
	/**
	 * constructor
	 * @param difficulty   difficulty of the game
	 */
	public Challenge (int difficulty) {
		singleton = getInstance();
		this.cdifficulty = difficulty;
		questionNum = pickQuestionNum(difficulty);
		question = getChallenge(questionNum);
		solution = getSolution(questionNum);

	}	

	public Challenge (int difficulty, int specificQuesiton) {
		singleton = getInstance();
		questionNum = specificQuesiton;
		question = getChallenge(questionNum);
		solution = getSolution(questionNum);
	}	
	
	/**
	 * looks like there might be a privacy leak here, however being that this is supposed to be 
	 * using the singleton design, and its string based, there shouldn't actually be a privacy leak.
	 * @return singleton    the list of challenges.
	 */
	public static ChallengeList getInstance() {
		if (singleton == null) {
			singleton = new ChallengeList();
		}
		return singleton;
	}

	public int getDifficulty(){
		return cdifficulty;
	}

	/**
	 * returns just the string and nothing else.
	 * possible privacy leak since we're directly returning a reference, but it's to a primitive
	 * so that shouldn't be an issue.
	 * @return question
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * returns just the string and does nothing else.
	 * possible privacy leak since we're directly returning a reference, but it's to a primitive
	 * so that shouldn't be an issue.
	 * @return solution
	 */
	public String getSolution() {
		return solution;
	}
	
	/**
	 * 
	 * @return questionNum
	 */
	public int getQuestionNum() {
		return questionNum;
	}

	/**
	 * gets a question from the list, used in the constructor
	 * @param questionNum
	 * @return
	 */
	private String getChallenge (int questionNum){
		question = singleton.getChallenge(questionNum);
		return question;
	
	}
	
	/**
	 * gets a solution from the list, used in the constructor
	 * @param questionNum
	 * @return
	 */
	private String getSolution (int questionNum){
		solution = singleton.getSolution(questionNum);
		return solution;
	}

	/**
	 * compares the user input to the solution of the challenge
	 * @param userInput
	 * @return correctAnswer  boolean thats true if they answered correctly
	 */
	public boolean verifyAnswer(String userInput){
		boolean correctAnswer = false;
		if (userInput.equalsIgnoreCase(solution)) {
			correctAnswer = true;
			}
		return correctAnswer;	
	}
	
	/**
	 * picks a random number based on difficulty that will be used as the index to get a random question
	 * and solution.
	 * @param difficulty   game difficulty setting
	 * @param nemesisAppears    boolean that's true if the current room is a nemesis room.
	 */
	public int pickQuestionNum(int difficulty) {
		if (difficulty <= 1) {
			questionNum = new Random().nextInt(20);
		}
		else if (difficulty == 2) {
			questionNum = new Random().nextInt(20) + 20;
		}
		else if (difficulty >= 3) {
			questionNum = new Random().nextInt(20) + 40;
		}
		return questionNum;
		
	}

}





