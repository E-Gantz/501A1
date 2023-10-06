import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Graphicsbased implements MouseListener, ActionListener {
	private String answer;
	private GameGUI gui = new GameGUI();
	private StatsGUI statsGui = new StatsGUI();
    private int counter = 1;
	private int uiCounter = 1;
	private int uiCounter2 = 1;
    private puzzleGame game;
    

    /**
	 * Constructor, creates the player instance, adds the listeners, and sets the first message on the label.
	 */
	public Graphicsbased(puzzleGame aGame){
        this.game = aGame;
		gui.getGuessBtn().addActionListener(this);
		gui.setMessage("There are 3 difficulty levels: 1: easy 2: medium 3: hard choose one.");
		gui.getContentPane().addMouseListener(this);
	}

    public void play(){
        this.gui.pack();
        this.gui.setVisible(true);
        this.gui.setResizable( false );
        this.gui.setLocationRelativeTo( null );
        this.statsGui.pack();
        this.statsGui.setVisible(true);
        this.statsGui.setResizable( false );
        this.statsGui.setLocationRelativeTo(this.gui);
    }

    /**
	 * entryMessage is used to display an entry message when the player enters a new room.
	 * the purpose of the counter is to keep track of which room they are in.
	 * @param counter  the number indicating which room the player is in.
	 * @return numberOfDoors  the number of doors in the next room.
	 */
	public int entryMessage(int counter) {
        int numberOfDoors = 1;
		if(counter == 1){
			numberOfDoors = 2;
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

    public void pickCharacter(){
        if (uiCounter == 1) {
		    game.setDifficulty((Integer.parseInt(gui.getEntry().getText())));
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
        else if (uiCounter == 2) {
            int chosenCharacter = (Integer.parseInt(gui.getEntry().getText()));
            game.setPlayer(chosenCharacter);
            statsGui.setStatHealth(Integer.toString(game.getPlayer().getHealth()));
            String itemNames = "";
            for (int index2 = 0; index2 < game.getPlayer().getItems().size();index2 ++) {
                itemNames = itemNames + game.getPlayer().getItems().get(index2).getName() + " ";
            }
            if (game.getPlayer().getItems().size() == 5) {
                statsGui.setStatItem("All Keys");
            }
            else {
                statsGui.setStatItem(itemNames);
            }
            statsGui.setStatNem("");
        }
    }

    /**
	 * button listener, does things with their input dependent on what stage of the game the user is at.
	 * uicounter is used to determine what "stage" the game is in, i.e. choosing the difficulty stage, choosing the character stage,etc.
	 */
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("Answer")) {
			if (uiCounter == 1) {
				if (Integer.parseInt(gui.getEntry().getText()) > 0 && Integer.parseInt(gui.getEntry().getText()) < 4) {
					pickCharacter();
				}
				else {
					statsGui.setStatNem("please enter a valid input");
				}
			}
			else if (uiCounter == 2) {
				if (Integer.parseInt(gui.getEntry().getText()) > 0 && Integer.parseInt(gui.getEntry().getText()) < 7) {
					pickCharacter();
					game.setNumDoors(entryMessage(counter));
					game.createRoom();
					gui.setBackground("Background1.jpg");
					gui.clearField();
					uiCounter++;
				}
				else {
					gui.setMessage("please enter a valid input");
				}
			}
			else if (uiCounter2 == 90) {
				tryPuzzle();
				gui.clearField();
			}
		}
	}

    public void tryPuzzle(){
        answer = (gui.getEntry().getText());
        if (!answer.contains(" ")){
        
            boolean correctAnswer = game.tryPuzzle(answer);
            if (correctAnswer) {
                gui.setMessage("Correct answer! you may go through the door.");
                gui.clearField();
                uiCounter = 4;
            }
            else if (!correctAnswer) {
                gui.setMessage("Incorrect answer! you lost some health.");
                loseHealth();
            }
        }
        else {
            statsGui.setStatNem("please enter a valid one word answer, with no spaces.");
        }
    }

    public void loseHealth(){
        boolean alive = game.loseHealth(1);
        statsGui.setStatHealth(Integer.toString(game.getPlayer().getHealth()));
        if(!alive){
            gui.setMessage("Game Over");
            gui.setBackground("death.jpg");
            uiCounter = 30;
            uiCounter2 = 2;
        }
    }

    public void nextRoom(int aroomChoice) {
        counter ++;
        game.setNumDoors(entryMessage(counter));
		game.pickaRoom(aroomChoice);
        if (game.isNemesis()) {
            statsGui.setStatNem("A NEMESIS APPEARS.");
        }
        uiCounter = 3;
	}

    public Boolean doorClicked(int x, int y){
        if ((counter == 1 || counter == 5) && (x >= 270 && x <= 430 && y >= 185 && y <= 570)) {
            return true;
        }
        else if ((counter == 1 || counter == 5) && (x >= 730 && x <= 900 && y >= 185 && y <= 570)) {
            return true;
        }
        else if ((counter == 2 || counter == 4) && (x >= 110 && x <= 290 && y >= 185 && y <= 570)) {
            return true;
        }
        
        else if((counter == 2 || counter == 4) && (x >= 490 && x <= 660 && y >= 185 && y <= 570)) {
            return true;
        }
        else if ((counter == 2 || counter == 4) && (x >= 820 && x <= 990 && y >= 185 && y <= 570)) {
            return true;
        }
        
        else if ((counter == 3 || counter == 6) && (x >= 450 && x <= 620 && y >= 185 && y <= 570)) {
            return true;
        }
        else {return false;}
    }

    public boolean puzzleClicked(int x, int y){
        if (x >= 1040 && x <= 1100 && y >= 45 && y <= 110) {
            return true;
        }
        else {return false;}
    }

    public void tryTheDoor(int x, int y){
        if(doorClicked(x, y)){
            boolean success = game.tryTheDoor(1);
            if (success) {
                statsGui.setStatNem("");
                gui.setMessage("you may go through the door");
                uiCounter = 4;
            } else {
                gui.setMessage("You need a " + game.getKeyName() + " to unlock the door.");
            }
        }
        else if (puzzleClicked(x, y)){
            if (game.isNemesis()) {
                statsGui.setStatNem("The nemesis asks you a question.");
            }
            gui.setMessage(game.getQuestion() + " Enter your answer.");
            //get string from text field
            uiCounter2 = 90;
        }
    }

    public void pickaRoom(int x, int y){
        int roomChoice;
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

    @Override
    public void mouseClicked(MouseEvent click) {
        int x = click.getX();
        int y = click.getY();
        if (uiCounter == 3) {
            tryTheDoor(x, y);
		}
		else if (uiCounter == 4) {
			pickaRoom(x, y);
		}
    }

    public void mousePressed(MouseEvent click){}
    public void mouseEntered(MouseEvent click){}
	public void mouseExited(MouseEvent click){}
	public void mouseReleased(MouseEvent click){}
}
