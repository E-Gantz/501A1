package Logic;
import UI.Graphicsbased;
import Game.puzzleGame;
public class GraphicsGame extends puzzleGame{

    public void play(){
        Graphicsbased graphx = new Graphicsbased(this);
        graphx.play();
    }

    public boolean tryTheDoor(){
        return player.hasItem(currentRoom.getDoorVariable());
    }

    public void pickaRoom(int roomChoice){
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
    }

    public boolean tryPuzzle(String answer){
        return currentRoom.getChallenge().verifyAnswer(answer);
    }

    public boolean loseHealth(){
        if (currentRoom.isNemesisRoom()) {
            player.updateHealth(2);
        }
        else {
            player.updateHealth(1);
        }
        return player.isAlive();
    }

    public void setDifficulty(int newDifficulty){
        this.difficulty = newDifficulty;
    }

    public void setPlayer(int chosenCharacter){
        this.player = new Player(chosenCharacter);
    }

    public Player getPlayer(){
        return player;
    }

    public void setNumDoors(int many){
        this.numberOfDoors = many;
    }

    public void createRoom(){
        currentRoom = new Room(difficulty, nemesisAppears);
        counter ++;
    }

    public String getKeyName(){
        return currentRoom.getDoorVariable().getName();
    }

    public boolean isNemesis(){
        return currentRoom.isNemesisRoom();
    }

    public String getQuestion(){
        return currentRoom.getChallenge().getQuestion();
    }
}
