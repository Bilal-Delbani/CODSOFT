package View;

import javax.swing.*;
import java.awt.*;

import static Control.Calculator.*;

public class CalculationPanel {
    private static JPanel gradesPanel;
    private static JLabel marks;
    private static JLabel average;
    private static JLabel Grade;
    private static JTextField totalMarks;
    private static JTextField averagePercentage;
    private static JTextField letterGrade;
    private static GridBagConstraints gbc;

    public CalculationPanel(){
        gradesPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 0, 5); // Add padding around components

        //customising the marks label
        marks = CustomiseLabel(marks,"Total Marks:     ");
        //adding the marks label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gradesPanel.add(marks, gbc);


        //customising the average label
        average = CustomiseLabel(average,"Average Percentage:     ");
        //adding the average label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gradesPanel.add(average, gbc);


        //customising the Grade label
        Grade = CustomiseLabel(Grade,"Expected Letter Grade:     ");
        //adding the grade label
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gradesPanel.add(Grade, gbc);


        //creating and adding the totalMarks text field
        totalMarks = new JTextField(String.valueOf(getTotalMarks()));
        totalMarks.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gradesPanel.add(totalMarks, gbc);


        //creating and adding the averagePercentage text field
        averagePercentage = new JTextField(6);
        averagePercentage.setText(String.valueOf(getAveragePercentage()));
        averagePercentage.setEditable(false);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gradesPanel.add(averagePercentage, gbc);


        //creating and adding the letterGrade text field
        letterGrade = new JTextField(getLetterGrade());
        letterGrade.setEditable(false);
        gbc.gridx =1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gradesPanel.add(letterGrade, gbc);
    }

    public static void setMarks(float grades, float average, String letter){
        totalMarks.setText(String.format("%.2f",grades));
        averagePercentage.setText(String.format("%.2f",average));
        letterGrade.setText(letter);
    }
    public JPanel getGradesPanel(){
        return gradesPanel;
    }
    public static JLabel CustomiseLabel(JLabel label, String text){
        label = new JLabel(text);
        label.setFont(new Font("Monospace", Font.PLAIN, 12));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setVerticalAlignment(SwingConstants.CENTER);
        return label;
    }
}
