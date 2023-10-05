import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Textbased {
    private boolean nemesisAppears = false;
	private Player player;
	private int difficulty;
	private int counter;
	private int numberOfDoors;
	private boolean keepPlaying;
    private Item doorvariable;
    private boolean isNemesis = false;
    private Challenge roomChallenge;
    private int nemesisChance = 0;

    public Textbased() {
        player = new Player();

        difficulty = 0;
        System.out.println("There are 3 difficulty levels: ");
        System.out.println("1: easy");
        System.out.println("2: medium");
        System.out.println("3: hard");
        System.out.println("Choice: ");
        Scanner keyboard2 = new Scanner(System.in);
        while (true){
            while (!keyboard2.hasNextInt()){
                keyboard2.next();
                System.out.println("Please enter a number: ");
            }
            int pickedOption2 = keyboard2.nextInt();
            if (pickedOption2 == 1){
                difficulty = 1;
                break;
            }
            else if (pickedOption2 == 2){
                difficulty = 2;
                break;
            }
            else if (pickedOption2 == 3){
                difficulty = 3;
                break;
            }
            else {
                System.out.println("please enter a valid choice.");
            }
        }

        int chosenCharacter = 0;
        System.out.println ("1: Jeff, starting health: 5,  Starting Item: Fire Key");
        System.out.println ("2: Dan, starting health: 10,  Starting Item: All Keys");
        System.out.println ("3: Suzy, starting health: 7,  Starting Item: Earth Key");
        System.out.println ("4: Tej, starting health: 8,  Starting Item: Metal Key");
        System.out.println ("5: Suki, starting health: 4,  Starting Item: Water Key, Wood Key");
        System.out.println ("6: Deprived, starting health: 1,  Starting Item: None");
        System.out.print ("Pick your character: ");
        Scanner keyboard3 = new Scanner(System.in);
        while (true) {
            
            while (!keyboard3.hasNextInt()){
                keyboard3.next();
                System.out.println("Please enter a number: ");
            }
            int pickedOption3 = keyboard3.nextInt();

            if (pickedOption3 == 1 || pickedOption3 == 2 || pickedOption3 == 3 || pickedOption3 == 4 || pickedOption3 == 5 || pickedOption3 == 6) {
                chosenCharacter = pickedOption3;
                break;
            }
            else {
                System.out.println("please enter a valid choice.");
            }
        
        }

        int initialHealth = player.startHealth(chosenCharacter);
        ArrayList<Item> items = new ArrayList<Item>(player.startItems(chosenCharacter));
        player = new Player(initialHealth, items);
        doorvariable = new Item();
        int nemesisChance = new Random().nextInt(100) + 1;
        if (nemesisAppears == true || nemesisChance <=33) {
            isNemesis = true;
        }
        roomChallenge = new Challenge(difficulty,false);
    }

    public void play(){
        keepPlaying = true;
        counter = 1;
        numberOfDoors = entryMessageText(counter);
        Scanner keyboard4 = new Scanner(System.in);
        while (counter <= 6) {
            while (keepPlaying) {
                if (counter == 6) {
                    keepPlaying = false;
                }
                System.out.println("Choices: ");
                System.out.println("1: use an item");
                System.out.println("2: " + "try the puzzle");
                System.out.print("Enter your choice: ");
                    
                while (!keyboard4.hasNextInt()){
                    keyboard4.next();
                    System.out.println("Please enter a number: ");
                }
                int pickedOption4 = keyboard4.nextInt();

                if (pickedOption4 == 1) {
                    if (player.hasItem(doorvariable)) {
                        System.out.println("you may go through the door");
                        exitMessageText(counter);
                        Scanner keyboard6 = new Scanner(System.in);
                        int roomChoice;
                        while (true) {
                            
                            while (!keyboard6.hasNextInt()){
                                keyboard6.next();
                                System.out.println("Please enter a number: ");
                            }
                            roomChoice = keyboard6.nextInt();

                            if (roomChoice <= 0 || roomChoice > numberOfDoors) {
                                System.out.println("please enter a valid choice.");
                            }
                            else {
                                break;
                            }
                        
                        }
                        if (counter == 6){
                            keepPlaying = false;
                        }
                        if((counter == 4 || counter == 5) && roomChoice == 2) {
                            nemesisAppears = true;
                        } else {
                            nemesisAppears = false;
                        }
                        nemesisChance = new Random().nextInt(100) + 1;
                        if (nemesisAppears == true || nemesisChance <=33) {
                            isNemesis = true;
                        }
                        roomChallenge = new Challenge(difficulty,isNemesis);
                        counter ++;
                        numberOfDoors = entryMessageText(counter);
                    } else {
                        System.out.println("you don't have the correct item for that");
                        if (counter == 6){
                            keepPlaying = true;
                        }
                    }
                }
                else if (pickedOption4 == 2) {
                    if (isNemesis) {
                        System.out.println("A NEMESIS APPEARS");
                        System.out.println("The nemesis asks you a question");
                        isNemesis = false;
                    }
                    System.out.println(roomChallenge.getQuestion());
                    System.out.print("Enter your answer: ");
                    Scanner keyboard5 = new Scanner(System.in);
                    while (!keyboard5.hasNextLine()){
                            keyboard5.next();
                            System.out.println("Please enter a string: ");
                        }
                    String answer = keyboard5.nextLine();

                    if (!(roomChallenge.checkValidInput(answer))){
                        System.out.println("please enter a valid one word answer, with no spaces.");
                        while (!keyboard5.hasNextLine()){
                                keyboard5.next();
                                System.out.println("Please enter a string: ");
                            }
                        answer = keyboard5.nextLine();
                    }
                    boolean correctAnswer = roomChallenge.verifyAnswer(answer);
                    if (correctAnswer) {
                        System.out.println("Correct answer! you may go through the door.");
                        System.out.println("you may go through the door");
                        exitMessageText(counter);
                        Scanner keyboard6 = new Scanner(System.in);
                        int roomChoice;
                        while (true) {
                            
                            while (!keyboard6.hasNextInt()){
                                keyboard6.next();
                                System.out.println("Please enter a number: ");
                            }
                            roomChoice = keyboard6.nextInt();

                            if (roomChoice <= 0 || roomChoice > numberOfDoors) {
                                System.out.println("please enter a valid choice.");
                            }
                            else {
                                break;
                            }
                        
                        }
                        if((counter == 4 || counter == 5) && roomChoice == 2) {
                        nemesisAppears = true;
                        } else {
                        nemesisAppears = false;
                        }
                        nemesisChance = new Random().nextInt(100) + 1;
                        if (nemesisAppears == true || nemesisChance <=33) {
                            isNemesis = true;
                        }
                        roomChallenge = new Challenge(difficulty,isNemesis);
                        counter ++;
                        numberOfDoors = entryMessageText(counter);
                    }
                    else if (!correctAnswer) {
                        System.out.println("Incorrect answer! you lost some health.");
                        if (counter == 6){
                            keepPlaying = true;
                        }
                        if (isNemesis) {
                            player.updateHealth(2);
                            System.out.println("your current health:" + player.getHealth());
                            if (!player.isAlive()) {
                                System.out.print("YOU DIED");
                                System.exit(0);
                            }
                        }
                        else {
                            player.updateHealth(1);
                            System.out.println("your current health:" + player.getHealth());
                            if (!player.isAlive()) {
                                System.out.print("YOU DIED");
                                System.exit(0);
                            }
                        }
                    }
                }
            }
        }	
        System.out.println("Congratulations, you completed our game!.");
    }

    /**
	 * entryMessageText is used to display an entry message when the player enters a new room.
	 * the purpose of the counter is to keep track of which room they are in.
	 * @param counter
	 * @return
	 */
	public static int entryMessageText(int counter) {
        int numberOfDoors = 1;
		if(counter == 1){
			numberOfDoors = 2;
			System.out.println("You step into the first room. You see two doors, which appear to have to same lock, in front of you, as well as a button that says 'puzzle' on it");
		} else if(counter == 2) {
			numberOfDoors = 3;
			System.out.println("You step into the second room. You see three doors, which appear to have to same lock, in front of you, as well as a button that says 'puzzle' on it ");
		} else if(counter == 3) {
			numberOfDoors = 1;
			System.out.println("You step into the third room. You see a door, as well as a button that says 'puzzle' on it ");
		} else if(counter == 4) {
			numberOfDoors = 3;
			System.out.println("You step into the fourth room. You see three doors, which appear to have to same lock, in front of you, as well as a button that says 'puzzle' on it  ");
		} else if(counter == 5) {
			numberOfDoors = 2;
			System.out.println("You step into the fifth room. You see two doors, which appear to have to same lock, in front of you, as well as a button that says 'puzzle' on it ");
		} else if(counter == 6) {
			numberOfDoors = 1;
			System.out.println("You step into the sixth room. You see one very nice looking door, as well as a button that says 'puzzle' on it   ");
		}
		return numberOfDoors;
	}
	
	/**
	 * exitMessageText is used to display a message whenever the user completes the challenge in a
	 * room and we need them to pick which door they would like to go through. the purpose
	 * of the counter is to keep track of which of the 6 rooms they are in.
	 * @param counter
	 * @return
	 */
	public static void exitMessageText(int counter) {
		if(counter == 1){
			System.out.println("Do you want to go through the first door or the second door?");
			System.out.println("Choice: ");
		} else if(counter == 2) {
			System.out.println("Do you want to go through the first, second, or third door?");
			System.out.println("Choice: ");
		} else if(counter == 3) {
			System.out.println("Do you want to go through the first door?");
			System.out.println("Choice: ");
		} else if(counter == 4) {
			System.out.println ("You see a red glow coming from the second door.");
			System.out.println("Do you want to go through the first, second, or third door?");
			System.out.println("Choice: ");
		} else if(counter == 5) {
			System.out.println ("You see a red glow coming from the second door.");
			System.out.println("Do you want to go through the first door or the second door?");
			System.out.println("Choice: ");
		} else if(counter == 6) {
			System.out.println("Do you want to go through the very nice looking door?");
			System.out.println("Choice: 1 for yes, 2 for no");
		}
	}
}
