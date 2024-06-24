package Control;
import Model.Calculate;
import javax.swing.*;
import static Model.Calculate.*;
import static View.CalculationPanel.setMarks;

public class Calculator {

    public Calculator(JTextField grade, int subjects){
        new Calculate(grade,subjects);
    }

    //return the total number grade from the model to the view
    public static float getTotalMarks(){
        return getGrade();
    }
    //return the average number grade from the model to the view
    public static float getAveragePercentage(){
        return getAverage();
    }
    //return the letter grade from the model to the view
    public static String getLetterGrade(){
        return getLetter();
    }

    public static void setGrades(float grades, float average, String letter){
        setMarks(grades, average, letter);
    }

}
