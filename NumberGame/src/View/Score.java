package View;
import Control.ReplayButtonHandler;
import Customising.CustomButton;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import static Model.GuessTheNumber.getLoseGames;
import static Model.GuessTheNumber.getWinGames;

public class Score {
    private static JFrame frame;
    private static JPanel mainPanel;
    private static JPanel panel;
    private static JPanel panel2;
    private JLabel label;
    private JLabel emptyLabel;
    private JLabel emptyLabel2;
    private CustomButton win;
    private CustomButton lose;
    private CustomButton replayButton;
    private Color lightGreen;
    private Color pink;
    private Color shadeBlue;
    private Color lightShadeBlue;

    public Score(JFrame frame) {

        try {
            // Set the Look and Feel to the system's default
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.frame = frame;
        mainPanel = new JPanel();
        panel = new JPanel();
        panel2 = new JPanel();
        //the main panel will contain the label and panel of statistics and panel of replay
        mainPanel.setBorder(new EmptyBorder(0,20,0,20));
        mainPanel.setLayout(new GridLayout(3,1,0,10));
        //panel for win and lose statistics
        panel.setBorder(new EmptyBorder(0,20,0,20));
        panel.setLayout(new GridLayout(2,1,0,30));
        //panel for replay button
        panel2.setBorder(new EmptyBorder(25,20,25,20));
        panel2.setLayout(new GridLayout(1,3,20,0));

        //customising the label
        label = new JLabel("<html>Your Statistics throughout<br>the Number Guessing Game!</html>");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        //customise 1st empty label
        emptyLabel = new JLabel("");
        emptyLabel.setFont(new Font("Arial", Font.BOLD, 20));
        emptyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        emptyLabel.setVerticalAlignment(SwingConstants.CENTER);
        emptyLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        // customising the buttons
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 18));
        lightGreen = new Color(144, 238, 144); // Light green color
        pink = new Color(255, 182, 193); // pink color
        shadeBlue = new Color(0,123,255);
        lightShadeBlue = new Color(0, 86, 179);

        win = new CustomButton("Win: " + getWinGames(),shadeBlue,lightShadeBlue);
        lose = new CustomButton("Lose: " + getLoseGames(), Color.RED,pink);
        replayButton = new CustomButton("Replay",Color.GREEN,lightGreen);
        //win.setPreferredSize(new Dimension(150, 50));
        //lose.setPreferredSize(new Dimension(150, 50));
        //replayButton.setPreferredSize(new Dimension(150, 150));


        //add the panels to the frame
        panel.add(win);
        panel.add(lose);

        panel2.add(emptyLabel);
        panel2.add(replayButton);
        panel2.add(emptyLabel);

        mainPanel.add(label);
        mainPanel.add(panel);
        mainPanel.add(panel2);
        frame.add(mainPanel);
        frame.setVisible(true);


        replayButton.addActionListener(new ReplayButtonHandler(this));
    }
    public static JFrame getFrame(){
        return frame;
    }
    public static JPanel getPanel(){
        return mainPanel;
    }
}
