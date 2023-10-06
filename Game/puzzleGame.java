package Game;
import Logic.*;
import UI.*;

public class puzzleGame{
    protected boolean nemesisAppears = false;
	protected Player player;
	protected int difficulty;
	protected int counter;
	protected int numberOfDoors;
    protected Room currentRoom;
	protected boolean keepPlaying;
    protected Textbased tex;

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
            TextGame tGame = new TextGame(tex);
            tGame.play();
        }
        else if (gameMode == 2){
            System.out.println("GUI chosen");
            GraphicsGame gGame = new GraphicsGame();
            gGame.play();
        }
    }
}