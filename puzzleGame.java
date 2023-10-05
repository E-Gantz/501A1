import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class puzzleGame implements MouseListener, ActionListener {
    private boolean nemesisAppears = false;
    private boolean isNemesis;
	private Player player;
	private int difficulty;
	private int counter = 1;
	private int numberOfDoors;
	private String answer;
	private GameGUI gui = new GameGUI();
	private StatsGUI statsGui = new StatsGUI();
	private int roomChoice;
	private int uiCounter = 1;
	private int uiCounter2 = 1;
    private Item doorvariable;
    private Challenge roomChallenge;

    public puzzleGame(){
		player = new Player();
		gui.getGuessBtn().addActionListener(this);
		gui.setMessage("There are 3 difficulty levels: 1: easy 2: medium 3: hard choose one.");
		gui.getContentPane().addMouseListener(this);
	}

    public static void main (String args[]) {
        int gameMode = 0;
        System.out.println("Choose your UI mode");
        System.out.println("1: Text-based, 2: GUI");
        Scanner keyboard1 = new Scanner(System.in);
        while (true){
            while (!keyboard1.hasNextInt()){
                keyboard1.next();
                System.out.println("Please enter a number: ");
            }
            int pickedOption = keyboard1.nextInt();
            if (pickedOption == 1){
                gameMode = 1;
                break;
            }
            else if (pickedOption == 2){
                gameMode = 2;
                break;
            }
            else {
                System.out.println("please enter a valid choice.");
            }
        }

        if (gameMode == 1){
            System.out.println("text chosen");
            boolean nemesisAppears = false;
            Player player;
            int difficulty;
            int counter;
            int numberOfDoors;
            boolean keepPlaying;

            Item doorvariable;
            boolean isNemesis = false;
            Challenge roomChallenge;

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
        else if (gameMode == 2){
            System.out.println("GUI chosen");
            puzzleGame game = new puzzleGame();
            game.gui.pack();
            game.gui.setVisible(true);
            game.gui.setResizable( false );
            game.gui.setLocationRelativeTo( null );
            game.statsGui.pack();
            game.statsGui.setVisible(true);
            game.statsGui.setResizable( false );
            game.statsGui.setLocationRelativeTo(game.gui);
        }
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
    /**
	 * entryMessage is used to display an entry message when the player enters a new room.
	 * the purpose of the counter is to keep track of which room they are in.
	 * @param counter  the number indicating which room the player is in.
	 * @return numberOfDoors  the number of doors in the next room.
	 */
	public int entryMessage(int counter) {
		if(counter == 1){
			numberOfDoors = 2;
			/*statsGui.setStatNem("TUTORIAL: click on one of the doors to try and use an item to unlock it."
					+ " if you have the correct item you will be able to go through to the next room."
					+ " you can also click the puzzle icon in the top right, this will give you a puzzle"
					+ " to solve, and if you are correct you can continue to the next room, if you are incorrect you will lose some health."
					+ " if a nemesis appears, then it will ask you a tougher question, and you will lose a higher amount of health.");*/
			gui.setMessage("You step into the first room.");
		} else if(counter == 2) {
			numberOfDoors = 3;
			gui.setBackground("Background2.jpg");
			gui.setMessage("You step into the second room.");
		} else if(counter == 3) {
			numberOfDoors = 1;
			gui.setBackground("Background3.jpg");
			gui.setMessage("You step into the third room.");
		} else if(counter == 4) {
			numberOfDoors = 3;
			gui.setBackground("Background4.jpg");
			gui.setMessage("You step into the fourth room.");
		} else if(counter == 5) {
			numberOfDoors = 2;
			gui.setBackground("Background5.jpg");
			gui.setMessage("You step into the fifth room.");
		} else if(counter == 6) {
			numberOfDoors = 1;
			gui.setBackground("Background3.jpg");
			gui.setMessage("You step into the sixth room.");
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
	public void exitMessage(int counter) {
		gui.setMessage("click a door to go through");
	}

    /**
	 * button listener, does things with their input dependent on what stage of the game the user is at.
	 * uicounter is used to determine what "stage" the game is in, i.e. choosing the difficulty stage, choosing the character stage,etc.
	 */
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Answer")) {
			
			if (uiCounter == 1) {
				
				if (Integer.parseInt(gui.getEntry().getText()) > 0 && Integer.parseInt(gui.getEntry().getText()) < 4) {
					difficulty = (Integer.parseInt(gui.getEntry().getText()));
					statsGui.setStatNem(
                    "1: Jeff, starting health: 5,  Starting Item: Fire Key \n " +
                    "2: Dan, starting health: 10,  Starting Item: All Keys \n " +
                    "3: Suzy, starting health: 7,  Starting Item: Earth Key \n " +
                    "4: Tej, starting health: 8,  Starting Item: Metal Key \n " +
                    "5: Suki, starting health: 4,  Starting Item: Water Key, Wood Key \n " +
                    "6: Deprived, starting health: 1,  Starting Item: None  ");
                    gui.setMessage("Pick your character: ");
					gui.setBackground("Tutorial.jpg");
					gui.clearField();
					uiCounter++;
				}
				else {
					statsGui.setStatNem("please enter a valid input");
				}
			}
			
			else if (uiCounter == 2) {
				
				if (Integer.parseInt(gui.getEntry().getText()) > 0 && Integer.parseInt(gui.getEntry().getText()) < 7) {
					int chosenCharacter = (Integer.parseInt(gui.getEntry().getText()));
					int initialHealth = player.startHealth(chosenCharacter);
					statsGui.setStatHealth(Integer.toString(initialHealth));
					ArrayList<Item> items = new ArrayList<Item>(player.startItems(chosenCharacter));
					String itemNames = "";
					for (int index2 = 0; index2 < items.size();index2 ++) {
						itemNames = itemNames + items.get(index2).getName() + " ";
					}
					if (items.size() == 5) {
						statsGui.setStatItem("All Keys");
					}
					else {
						statsGui.setStatItem(itemNames);
					}
					statsGui.setStatNem("");
					player = new Player(initialHealth, items);
					numberOfDoors = entryMessage(counter);
					doorvariable = new Item();
                    int nemesisChance = new Random().nextInt(100) + 1;
                    if (nemesisAppears == true || nemesisChance <=33) {
                        isNemesis = true;
                    }
                    roomChallenge = new Challenge(difficulty,isNemesis);
					gui.setBackground("Background1.jpg");
					gui.clearField();
					uiCounter++;
				}
				else {
					gui.setMessage("please enter a valid input");
				}
			}
			
			else if (uiCounter2 == 90) {
				answer = (gui.getEntry().getText());
				if ((roomChallenge.checkValidInput(answer))){
				
					boolean correctAnswer = roomChallenge.verifyAnswer(answer);
					if (correctAnswer) {
						gui.setMessage("Correct answer! you may go through the door.");
						gui.clearField();
						uiCounter = 4;
					}
					else if (!correctAnswer) {
						gui.setMessage("Incorrect answer! you lost some health.");
						if (isNemesis) {
							if (player.getHealth() >= 2) {
								player.updateHealth(2);
							}
							else if (player.getHealth() < 2) {
								player.updateHealth(1);
							}
							statsGui.setStatHealth(Integer.toString(player.getHealth()));
							if (!player.isAlive()) {
								gui.setMessage("Game Over");
								gui.setBackground("death.jpg");
								uiCounter = 30;
								uiCounter2 = 2;
							}
						}
						else {
							player.updateHealth(1);
							statsGui.setStatHealth(Integer.toString(player.getHealth()));
							if (!player.isAlive()) {
								gui.setMessage("Game Over");
								gui.setBackground("death.jpg");
								uiCounter = 30;
								uiCounter2 = 2;
							}
						}
					}
				}
				else {
					statsGui.setStatNem("please enter a valid one word answer, with no spaces.");
				}
				gui.clearField();
			}
			
			
		}
	}
    public void nextRoom(int aroomChoice) {
		if((counter == 4 || counter == 5) && aroomChoice == 2) {
			nemesisAppears = true;
			} else {
			nemesisAppears = false;
			statsGui.setStatNem("");
			}
			doorvariable = new Item();
            int nemesisChance = new Random().nextInt(100) + 1;
            if (nemesisAppears == true || nemesisChance <=33) {
                isNemesis = true;
            }
            roomChallenge = new Challenge(difficulty,isNemesis);
			counter ++;
			numberOfDoors = entryMessage(counter);
			if (isNemesis) {
				statsGui.setStatNem("A NEMESIS APPEARS.");
                isNemesis = false;
			}
			uiCounter = 3;
	}

    @Override
    public void mouseClicked(MouseEvent click) {
        int x = click.getX();
        int y = click.getY();
        if (uiCounter == 3) {
			if ((counter == 1 || counter == 5) && (x >= 270 && x <= 430 && y >= 185 && y <= 570)) {
                if (player.hasItem(doorvariable)) {
                    gui.setMessage("you may go through the door");
                    uiCounter = 4;
                } else {
                    gui.setMessage("You need a " + doorvariable.getName() + " to unlock the door.");
                }
            }
            else if ((counter == 1 || counter == 5) && (x >= 730 && x <= 900 && y >= 185 && y <= 570)) {
                if (player.hasItem(doorvariable)) {
                    gui.setMessage("you may go through the door");
                    uiCounter = 4;
                } else {
                    gui.setMessage("You need a " + doorvariable.getName() + " to unlock the door.");
                }
            }
            else if ((counter == 2 || counter == 4) && (x >= 110 && x <= 290 && y >= 185 && y <= 570)) {
                if (player.hasItem(doorvariable)) {
                    gui.setMessage("you may go through the door");
                    uiCounter = 4;
                } else {
                    gui.setMessage("You need a " + doorvariable.getName() + " to unlock the door.");
                }
            }
            
            else if((counter == 2 || counter == 4) && (x >= 490 && x <= 660 && y >= 185 && y <= 570)) {
                if (player.hasItem(doorvariable)) {
                    gui.setMessage("you may go through the door");
                    uiCounter = 4;
                } else {
                    gui.setMessage("You need a " + doorvariable.getName() + " to unlock the door.");
                }
            }
            else if ((counter == 2 || counter == 4) && (x >= 820 && x <= 990 && y >= 185 && y <= 570)) {
                if (player.hasItem(doorvariable)) {
                    gui.setMessage("you may go through the door");
                    uiCounter = 4;
                } else {
                    gui.setMessage("You need a " + doorvariable.getName() + " to unlock the door.");
                }
            }
            
            else if ((counter == 3 || counter == 6) && (x >= 450 && x <= 620 && y >= 185 && y <= 570)) {
                if (player.hasItem(doorvariable)) {
                    gui.setMessage("you may go through the door");
                    uiCounter = 4;
                } else {
                    gui.setMessage("You need a " + doorvariable.getName() + " to unlock the door.");
                }
            }
            
            
            else if (x >= 1040 && x <= 1100 && y >= 45 && y <= 110) {
                if (isNemesis) {
                    statsGui.setStatNem("The nemesis asks you a question.");
                }
                gui.setMessage(roomChallenge.getQuestion() + " Enter your answer.");
                //get string from text field
                uiCounter2 = 90;
            }
		}
		else if (uiCounter == 4) {
			if ((counter == 1 || counter == 5) && (x >= 270 && x <= 430 && y >= 185 && y <= 570)) {
                roomChoice = 1;
                nextRoom(roomChoice);
            }
            else if ((counter == 1 || counter == 5) && (x >= 730 && x <= 900 && y >= 185 && y <= 570)) {
                roomChoice = 2;
                nextRoom(roomChoice);
            }
            else if ((counter == 2 || counter == 4) && (x >= 110 && x <= 290 && y >= 185 && y <= 570)) {
                roomChoice = 1;
                nextRoom(roomChoice);
            }
            
            else if((counter == 2 || counter == 4) && (x >= 490 && x <= 660 && y >= 185 && y <= 570)) {
                roomChoice = 2;
                nextRoom(roomChoice);
            }
            else if ((counter == 2 || counter == 4) && (x >= 820 && x <= 990 && y >= 185 && y <= 570)) {
                roomChoice = 3;
                nextRoom(roomChoice);
            }
            
            else if (counter == 3 && (x >= 450 && x <= 620 && y >= 185 && y <= 570)) {
                roomChoice = 1;
                nextRoom(roomChoice);
            }
            
            
            else if (counter == 6 && (x >= 450 && x <= 620 && y >= 185 && y <= 570)) {
                gui.setMessage("Congratulations! You completed our game!");
                gui.setBackground("win.jpg");
            }
		}
    }

    public void mousePressed(MouseEvent click){}
    public void mouseEntered(MouseEvent click){}
	public void mouseExited(MouseEvent click){}
	public void mouseReleased(MouseEvent click){}
}