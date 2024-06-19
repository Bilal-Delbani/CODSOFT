package Control;
import Model.GuessTheNumber;
import View.NewGame;
import javax.swing.*;
import static Model.GuessTheNumber.getAttempts;
import static Model.GuessTheNumber.getTriesNumber;
import static View.ViewGame.*;

//class
public class Guess {
    //instances
    private static int guessedNumber;
    private static JFrame frame;
    private static JPanel mainPanel;

    //constructor
    public Guess(JFrame frame){
        //get the number guessed by the user from ViewGame and send it to the Model
        guessedNumber = Integer.parseInt(getGuess());
        //Model object
        GuessTheNumber g = new GuessTheNumber(guessedNumber);

        this.frame = frame;
        this.mainPanel =  getPanel();
    }

    //get status from the model and set it in the ViewGame as the message label
    public static void setStatus(String status){
        setLabel(status);
    }

    //get the number of tries that the user has made in the game and print it
    // in the ViewGame
    public static int getNumberOfTries(){
        return getTriesNumber();
    }

    //get the number of attempts that the user has in each game
    public static int getNumberOfAttempts(){
        return getAttempts();
    }

    //remove the content inside the guess Field (input of the user)
    public static void setGuessField(String guessField){
        setGuess(guessField);
    }

    //set the message of how much tries the user has made in the game
    //from model to ViewGame;
    public static void setLabelOfTries(String triesLabel){
        setTriesLabel(triesLabel);
    }

    // option of replay
    public static void newGame(String text){
        frame.remove(mainPanel);
        new NewGame(frame,text);
    }

}
