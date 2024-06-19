package View;
import Control.Guess;
import Customising.CustomButton;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Control.Guess.*;

public class ViewGame {

    //preparing the View of the Guess Number Game
    private static JPanel mainPanel;
    private static JPanel panel;
    private static JTextField guessField;
    private static JButton guessButton;
    private static JLabel messageLabel;
    private static JLabel triesLabel;
    private static Color lightGreen;

    public ViewGame(JFrame frame){
        try {
            // Set the Look and Feel to the system's default
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set up the panel
        mainPanel = new JPanel();
        panel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(40,40,20,40));
        mainPanel.setLayout(new GridLayout(3,1,0,40));
        panel.setLayout(new GridLayout(1,2,30,0));

        // Create components
        messageLabel = new JLabel("I have randomly chosen a number between 1 and 100. Try to guess it!!!");
        guessField = new JTextField();
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 18));
        lightGreen = new Color(144, 238, 144); // Light green color
        guessButton = new CustomButton("Guess",Color.GREEN,lightGreen);
        triesLabel = new JLabel("Number of tries: " + getNumberOfTries() + "/"+getNumberOfAttempts());

        // Add components to the frame
        panel.add(guessField);
        panel.add(guessButton);
        mainPanel.add(messageLabel);
        mainPanel.add(panel);
        mainPanel.add(triesLabel);

        frame.add(this.mainPanel);
        frame.setVisible(true);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Guess(frame);
            }
        });


    }

    public static String getGuess(){
        return guessField.getText();
    }
    public static void setGuess(String value){
        guessField.setText(value);
    }
    public static void setTriesLabel(String string){
        triesLabel.setText(string);
    }
    public static void setLabel(String string){
        messageLabel.setText(string);
    }
    public static JPanel getPanel(){
        return mainPanel;
    }

}
