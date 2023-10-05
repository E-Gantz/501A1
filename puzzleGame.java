import java.util.Scanner;

public class puzzleGame{

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
            Textbased tex = new Textbased();
            tex.play();
        }
        else if (gameMode == 2){
            System.out.println("GUI chosen");
            Graphicsbased graphx = new Graphicsbased();
            graphx.play();
        }
    }    
}