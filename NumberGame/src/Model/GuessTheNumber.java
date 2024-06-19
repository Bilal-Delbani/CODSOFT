package Model;
import javax.swing.*;
import java.util.Random;
import static Control.Guess.*;

//class
public class GuessTheNumber {
    //instances
    private static int triesNumber = 1;
    private static final int ATTEMPTS = 7;
    //get the random number between 0 and 100
    private static Random random = new Random();
    private static int numberToGuess = random.nextInt(100) + 1;
    //record the number of wins and looses
    private static int wins=0;
    private static int lose=0;
    //the guessed number sent by the control to compare it with the chosen random number
    private static int guessedNumber;

    //constructor
    public GuessTheNumber(int guessedNumber) {
        this.guessedNumber = guessedNumber;
        triesNumber++;
        //during the game until win
        if(triesNumber<=ATTEMPTS){
            setLabelOfTries("Number of tries: " + triesNumber + "/"+ATTEMPTS);
            if(guessedNumber<1 || guessedNumber>100){
                setStatus("Please enter a valid number between 1 and 100.");
                setGuessField("");
            }
            else if (guessedNumber < numberToGuess) {
                setStatus("Your guess is too low.");
                setGuessField("");
            }
            else if (guessedNumber > numberToGuess) {
                setStatus("Your guess is too high.");
                setGuessField("");
            }
            else {
                setStatus("Congratulations! You've guessed the correct number.");
                setGuessField("");
                triesNumber=0;
                wins++;
                setLabelOfTries("Number of tries: " + triesNumber + "/"+ATTEMPTS);
                newGame("Congratulations! You've won!!!");
            }
        }
        //if user looses (out of attempts)
        else{
            setGuessField("");
            triesNumber=0;
            lose++;
            newGame("Unfortunately, You're out of attempts!!!");

        }
    }


    //return the number of attempts to the control
    //then it will be sent to the ViewGame to be displayed
    public static int getAttempts(){
        return ATTEMPTS;
    }

    //return the number of tries made by the user to the control
    //then it will be sent to the ViewGame to be displayed
    public static int getTriesNumber(){
        return triesNumber;
    }
    
    public static int getWinGames(){
        return wins;
    }

    public static int getLoseGames(){
        return lose;
    }
}
