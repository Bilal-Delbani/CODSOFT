package View;
import Control.ExitButtonHandler;
import Control.PlayButtonHandler;
import Customising.CustomButton;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class View_GUI {

    private static JFrame frame = new JFrame("Guess The Number");
    private static JPanel mainPanel = new JPanel();
    private static JPanel panel = new JPanel();
    private CustomButton playButton;
    private CustomButton exitButton;
    private Color lightGreen;
    private Color pink;
    private JLabel label;


    public  View_GUI(){
        try {
            // Set the Look and Feel to the system's default
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set up the frame and panels
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));
        mainPanel.setLayout(new GridLayout(2,1,0,10));
        panel.setBorder(new EmptyBorder(50,20,50,20));
        panel.setLayout(new GridLayout(1,2,30,30));

        //customising the label
        label = new JLabel("Welcome to the Number Guessing Game!");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        // customising the buttons
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 18));
        lightGreen = new Color(144, 238, 144); // Light green color
        pink = new Color(255, 182, 193); // pink color
        playButton = new CustomButton("Play",Color.GREEN,lightGreen);
        exitButton = new CustomButton("Exit", Color.RED,pink);
        playButton.setPreferredSize(new Dimension(150, 30));
        exitButton.setPreferredSize(new Dimension(150, 30));

        //add the panels to the frame
        panel.add(playButton);
        panel.add(exitButton);
        mainPanel.add(label);
        mainPanel.add(panel);
        frame.add(mainPanel);
        frame.setVisible(true);

        // add actions to buttons
        playButton.addActionListener(new PlayButtonHandler(this));
        exitButton.addActionListener(new ExitButtonHandler());
    }

    public static JFrame getFrame(){
        return frame;
    }
    public static JPanel getPanel(){
        return mainPanel;
    }



}
