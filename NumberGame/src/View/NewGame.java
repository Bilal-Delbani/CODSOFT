package View;

import Control.ExitButtonHandler;
import Control.PlayButtonHandler;
import Control.ReplayButtonHandler;
import Control.ScoreButtonHnadler;
import Customising.CustomButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class NewGame {
    private static JFrame frame;
    private static JPanel mainPanel;
    private static JPanel panel;
    private static JLabel label;
    private CustomButton replayButton;
    private CustomButton exitButton;
    private CustomButton scoreButton;
    private Color lightGreen;
    private Color pink;
    private Color shadeBlue;
    private Color lightShadeBlue;

    public NewGame(JFrame frame, String text){
        try {
            // Set the Look and Feel to the system's default
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.frame = frame;
        // Set up the panel
        mainPanel = new JPanel();
        panel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));
        mainPanel.setLayout(new GridLayout(2,1,0,10));
        panel.setBorder(new EmptyBorder(50,20,50,20));
        panel.setLayout(new GridLayout(1,3,30,30));

        //customising the label
        label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        // customising the buttons
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 18));
        lightGreen = new Color(144, 238, 144); // Light green color
        pink = new Color(255, 182, 193); // pink color
        shadeBlue = new Color(0,123,255);
        lightShadeBlue = new Color(0, 86, 179);

        replayButton = new CustomButton("Replay",Color.GREEN,lightGreen);
        exitButton = new CustomButton("Exit", Color.RED,pink);
        scoreButton = new CustomButton("Score",shadeBlue,lightShadeBlue);

        replayButton.setPreferredSize(new Dimension(150, 30));
        exitButton.setPreferredSize(new Dimension(150, 30));
        scoreButton.setPreferredSize(new Dimension(150,30));

        //add the panels to the frame
        panel.add(replayButton);
        panel.add(scoreButton);
        panel.add(exitButton);
        mainPanel.add(label);
        mainPanel.add(panel);
        frame.add(mainPanel);
        frame.setVisible(true);

        replayButton.addActionListener(new ReplayButtonHandler(this));
        exitButton.addActionListener(new ExitButtonHandler());
        scoreButton.addActionListener(new ScoreButtonHnadler(this));
    }

    public static JFrame getFrame(){
        return frame;
    }
    public static JPanel getPanel(){
        return mainPanel;
    }
}
