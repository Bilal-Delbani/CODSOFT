package Model;

import javax.swing.*;

import static Control.Calculator.setGrades;

public class Calculate {
    private static float grade=0;
    private static float average=0;
    private static String letter="F";
    private static int sub;
    private static int track=0;
    private static float dummy;

    public Calculate(JTextField grade, int subjects){
        try{
            dummy = Float.parseFloat(grade.getText()) ;
            if(dummy>=0 && dummy<=100){
                this.grade += dummy;
                sub = subjects - track;
                average = this.grade/sub;
                checkLetterGrade(average);
                setGrades(this.grade,average,letter);
            }
            else{
                this.grade += 0;
                track++;
                sub = subjects - track;
                if(sub==0){
                    sub=1;
                }
                average = this.grade/sub;
                checkLetterGrade(average);
                setGrades(this.grade,average,letter);
            }

        }
        catch(NumberFormatException e){
            this.grade += 0;
            track++;
            sub = subjects - track;
            if(sub==0){
                sub=1;
            }
            average = this.grade/sub;
            checkLetterGrade(average);
            setGrades(this.grade,average,letter);
        }
    }

    public Calculate(JTextField removedGrade){
        try{
            dummy = Float.parseFloat(removedGrade.getText());
            if(dummy>=0 && dummy<=100){
                this.grade -= dummy;
                track++;
                sub--;
                average = this.grade/sub;
                checkLetterGrade(average);
                setGrades(this.grade,average,letter);
            }
        }
        catch (NumberFormatException e){

        }

    }

    private void checkLetterGrade(float average) {
        if(average>=90){
            letter="A";
        } else if (average>=87) {
            letter="A-";
        }
        else if(average>=84){
            letter="B+";
        }
        else if(average>=80){
            letter="B";
        }
        else if (average>=77) {
            letter="B-";
        }
        else if (average>=74) {
            letter="C+";
        }
        else if (average>=70) {
            letter="C";
        }
        else if (average>=67) {
            letter="C-";
        }
        else if (average>=64) {
            letter="D+";
        }
        else if (average>=60) {
            letter="D";
        }
        else{
            letter="F";
        }

    }

    public static float getGrade(){
        return grade;
    }
    public static float getAverage(){
        return average;
    }
    public static String getLetter(){
        return letter;
    }
}
