package Logic;
import java.io.*;

public class ChallengeList {

	/**
	 * gets a question from the list
	 * @param questionNum   index of the question we want
	 * @return  the chosen question
	 */
	public String getChallenge(int questionNum){
    	String sentence = "";
		int lineNumber = 0;
        try {
            BufferedReader input = new BufferedReader(new FileReader("Resources/questions.txt"));
			String line = "";
			while(lineNumber <= questionNum) {
				line = input.readLine();
				lineNumber++;
			}
			String[] words = line.split(" ");
			for (int index = 0; index < words.length; index++) {
				String word = words[index];
				if(index == 0) {
					sentence = word;
				} else {
					sentence = sentence + " " + word;
				}
			}
			input.close();
			
        } catch (IOException ioe) {
			ioe.printStackTrace();
        }
		return(sentence);
    }
    	
	/**
	 * get a solution from the list
	 * @param questionNum   index of the question we want
	 * @return the chosen solution
	 */
	public String getSolution(int questionNum){
		String sentence = "";
		int lineNumber = 0;
        try {
            BufferedReader input = new BufferedReader(new FileReader("Resources/answers.txt"));
			String line = input.readLine();
			while(lineNumber < questionNum) {
				line = input.readLine();
				lineNumber++;
			}
			String[] words = line.split(" ");
			for (int index = 0; index < words.length; index++) {
				String word = words[index];
				if(index == 0) {
					sentence = word;
				} else {
					sentence = sentence + " " + word;
				}
			}
			//System.out.println(sentence);
			input.close();
        } catch (IOException ioe) {
			ioe.printStackTrace();
        }
		return sentence;
	}

}
	
