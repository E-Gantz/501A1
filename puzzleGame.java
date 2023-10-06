
public class puzzleGame{
    private boolean nemesisAppears = false;
	private Player player;
	private int difficulty;
	private int counter;
	private int numberOfDoors;
    private Room currentRoom;
	private boolean keepPlaying;
    private Textbased tex;

    public static void main (String args[]) {
        puzzleGame game = new puzzleGame();
        game.tex = new Textbased();
        game.play();
    }  
    
    public void play(){
        System.out.println("Choose your UI mode");
        System.out.println("1: Text-based, 2: GUI");
        int gameMode = tex.chooseIntOption(1, 2);

        if (gameMode == 1){
            System.out.println("Text-based chosen");
            playText();
        }
        else if (gameMode == 2){
            System.out.println("GUI chosen");
            playGraphx();
        }
    }

    public void playText(){
        difficulty = tex.pickDifficulty();
        int chosenCharacter = tex.pickCharacter();
        player = new Player(chosenCharacter);
        currentRoom = new Room(difficulty, nemesisAppears);
        keepPlaying = true;
        counter = 1;
        numberOfDoors = tex.entryMessage(counter);
        while (counter <= 6) {
            while (keepPlaying) {
                int pickedOption = tex.chooseAction();
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

    public void playGraphx(){
        Graphicsbased graphx = new Graphicsbased();
        graphx.play();
    }

    public void tryTheDoor(){
        if (player.hasItem(currentRoom.getDoorVariable())) {
            tex.tryTheDoor(true);
            pickaRoom();
        } else {
            tex.tryTheDoor(false);
        }
    }

    public void pickaRoom(){
        tex.exitMessage(counter);
        int roomChoice = tex.chooseIntOption(1, numberOfDoors);
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
        numberOfDoors = tex.entryMessage(counter);
    }

    public void tryPuzzle(){
        tex.tryPuzzle(currentRoom.isNemesisRoom(), currentRoom.getChallenge().getQuestion());
        String answer = tex.chooseStringOption();
        boolean correctAnswer = currentRoom.getChallenge().verifyAnswer(answer);
        tex.tryPuzzle(correctAnswer);
        if (correctAnswer) {
            pickaRoom();
        }
        else {
            loseHealth();
        }
    }

    public void loseHealth(){
        if (currentRoom.isNemesisRoom()) {
            player.updateHealth(2);
        }
        else {
            player.updateHealth(1);
        }
        tex.loseHealth(player.getHealth(), player.isAlive());
        if (!player.isAlive()) {
            System.exit(0);
        }
    }
}