package View;
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
    private JLabel label;
    private CustomButton win;
    private CustomButton lose;
    private Color lightGreen;
    private Color pink;

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
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));
        mainPanel.setLayout(new GridLayout(2,1,0,10));
        panel.setBorder(new EmptyBorder(50,20,50,20));
        panel.setLayout(new GridLayout(1,2,30,30));

        //customising the label
        label = new JLabel("<html>Your Statistics throughout<br>the Number Guessing Game!</html>");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        
        // customising the buttons
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 18));
        lightGreen = new Color(144, 238, 144); // Light green color
        pink = new Color(255, 182, 193); // pink color
        win = new CustomButton("Win: " + getWinGames(),Color.GREEN,lightGreen);
        lose = new CustomButton("Lose: " + getLoseGames(), Color.RED,pink);
        win.setPreferredSize(new Dimension(150, 30));
        lose.setPreferredSize(new Dimension(150, 30));

        //add the panels to the frame
        panel.add(win);
        panel.add(lose);
        mainPanel.add(label);
        mainPanel.add(panel);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
