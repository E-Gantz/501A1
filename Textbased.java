import java.util.Scanner;

public class Textbased {
    private boolean nemesisAppears = false;
	private Player player;
	private int difficulty;
	private int counter;
	private int numberOfDoors;
	private boolean keepPlaying;
    private Room currentRoom;

    public Textbased() {
        difficulty = pickDifficulty();
        int chosenCharacter = pickCharacter();
        player = new Player(chosenCharacter);
        currentRoom = new Room(difficulty, nemesisAppears);
    }

    /**
	 * pickDifficulty lets the user choose what difficulty they would like to play on.
	 * this is fine.
	 * @return
	 */
    public int pickDifficulty() {
        System.out.println("There are 3 difficulty levels: ");
        System.out.println("1: easy");
        System.out.println("2: medium");
        System.out.println("3: hard");
        System.out.println("Choice: ");
        return chooseIntOption(1,3);
    }

    /**
	 * pickCharacter lets the user choose which character they would like to play the game as.
	 * this is fine.
	 * @return
	 */
    public int pickCharacter(){
        System.out.println ("1: Jeff, starting health: 5,  Starting Item: Fire Key");
        System.out.println ("2: Dan, starting health: 10,  Starting Item: All Keys");
        System.out.println ("3: Suzy, starting health: 7,  Starting Item: Earth Key");
        System.out.println ("4: Tej, starting health: 8,  Starting Item: Metal Key");
        System.out.println ("5: Suki, starting health: 4,  Starting Item: Water Key, Wood Key");
        System.out.println ("6: Deprived, starting health: 1,  Starting Item: None");
        System.out.print ("Pick your character: ");
        return chooseIntOption(1,6);
    }

    /**
	 * chooseIntOption is used when we need the player to enter an integer as input.
	 * @return
	 */
	public int chooseIntOption(int x, int y) {
		Scanner keyboard = new Scanner(System.in);
        int pickedOption = -99;
        while (!keyboard.hasNextInt()){
            keyboard.next();
            System.out.println("Please enter a number: ");
        }
        pickedOption = keyboard.nextInt();

		while (!(pickedOption >= x && pickedOption <= y)){
            System.out.println("please enter a valid choice.");
            while (!keyboard.hasNextInt()){
				keyboard.next();
				System.out.println("Please enter a number: ");
			}
		    pickedOption = keyboard.nextInt();
        }
		
		return pickedOption;
	}

    /**
	 * chooseStringOption is used when we need the player to enter a string as input.
	 * @return
	 */
	public String chooseStringOption() {
		Scanner keyboard = new Scanner(System.in);
		while (!keyboard.hasNextLine()){
            keyboard.next();
            System.out.println("Please enter a string: ");
		}
		String pickedOption = keyboard.nextLine();
        while (pickedOption.contains(" ")){
            System.out.println("please enter a valid one word answer, with no spaces.");
            while (!keyboard.hasNextLine()){
                keyboard.next();
                System.out.println("Please enter a string: ");
            }
            pickedOption = keyboard.nextLine();
        }
		return pickedOption;
	}

    
    /**
	 * entryMessage is used to display an entry message when the player enters a new room.
	 * the purpose of the counter is to keep track of which room they are in.
	 * @param counter
	 * @return
	 */
	public static int entryMessage(int counter) {
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
	 * exitMessage is used to display a message whenever the user completes the challenge in a
	 * room and we need them to pick which door they would like to go through. the purpose
	 * of the counter is to keep track of which of the 6 rooms they are in.
	 * @param counter
	 * @return
	 */
	public static void exitMessage(int counter) {
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

    public int chooseAction(){
        System.out.println("Choices: ");
        System.out.println("1: use an item");
        System.out.println("2: " + "try the puzzle");
        System.out.print("Enter your choice: ");
        return chooseIntOption(1,2);
    }

    public void tryTheDoor(){
        if (player.hasItem(currentRoom.getDoorVariable())) {
            System.out.println("you may go through the door");
            pickaRoom();
        } else {
            System.out.println("you don't have the correct item for that");
        }
    }

    public void pickaRoom(){
        exitMessage(counter);
        int roomChoice = chooseIntOption(1, numberOfDoors);
        if (counter == 6){
            keepPlaying = false;
        }
        if((counter == 4 || counter == 5) && roomChoice == 2) {
            nemesisAppears = true;
        } else {
            nemesisAppears = false;
        }
        currentRoom = new Room(difficulty, nemesisAppears);
        counter ++;
        numberOfDoors = entryMessage(counter);
    }

    public void loseHealth(){
        if (currentRoom.isNemesisRoom()) {
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

    public void tryPuzzle(){
        if (currentRoom.isNemesisRoom()) {
            System.out.println("A NEMESIS APPEARS");
            System.out.println("The nemesis asks you a question");
        }
        System.out.println(currentRoom.getChallenge().getQuestion());
        System.out.print("Enter your answer: ");
        String answer = chooseStringOption();
        boolean correctAnswer = currentRoom.getChallenge().verifyAnswer(answer);
        if (correctAnswer) {
            System.out.println("Correct answer! you may go through the door.");
            pickaRoom();
        }
        else if (!correctAnswer) {
            System.out.println("Incorrect answer! you lost some health.");
            loseHealth();
        }
    }

    public void play(){
        keepPlaying = true;
        counter = 1;
        numberOfDoors = entryMessage(counter);
        while (counter <= 6) {
            while (keepPlaying) {
                int pickedOption = chooseAction();
                if (pickedOption == 1) {
                    tryTheDoor();
                }
                else if (pickedOption == 2) {
                    tryPuzzle();
                }
            }
        }	
        System.out.println("Congratulations, you completed our game!.");
    }
}