package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Login {
    //this panel will include all the components in the frame : main panel
    private static JPanel mainPanel;
    //this panel will have the login panel, and it will be used to move the inner panel to the west
    private static JPanel westPanel;
    //this panel is used to move the west panel to the north
    private static JPanel northPanel;

    private static ImageIcon imageURL;
    private static JLabel image;
    private static JLabel SignIn;
    private static JLabel note;


    public Login(JFrame frame){

        try {
            // Set the Look and Feel to the system's default
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));


        //add the CODSOFT logo
        imageURL = new ImageIcon(getClass().getResource("../Images/logo.png"));
        image = new JLabel(imageURL);
        image.setHorizontalAlignment(SwingConstants.LEFT);
        image.setVerticalAlignment(SwingConstants.CENTER);
        image.setBorder(BorderFactory.createEmptyBorder(100, 140, 0, 0));
        image.setAlignmentX(Component.LEFT_ALIGNMENT);

        //customising the login label
        SignIn = new JLabel("Sign in");
        SignIn.setFont(new Font("Monospace", Font.BOLD, 35));
        SignIn.setHorizontalAlignment(SwingConstants.LEFT);
        SignIn.setVerticalAlignment(SwingConstants.CENTER);
        SignIn.setBorder(BorderFactory.createEmptyBorder(50, 150, 0, 0));
        SignIn.setForeground(Color.DARK_GRAY);
        SignIn.setAlignmentX(Component.LEFT_ALIGNMENT);

        //customising the note label
        note = new JLabel("Please use your CODSOFT e-mail username (only the part before @) and password.");
        note.setFont(new Font("Aptos", Font.PLAIN, 18));
        note.setHorizontalAlignment(SwingConstants.LEFT);
        note.setVerticalAlignment(SwingConstants.CENTER);
        note.setBorder(BorderFactory.createEmptyBorder(50, 150, 0, 0));
        note.setForeground(new Color(88,88,88));
        note.setAlignmentX(Component.LEFT_ALIGNMENT);

        //west panel
        westPanel = new JPanel();
        westPanel.setLayout(new BorderLayout());
        //get the login panel object => the text fields and labels required
        westPanel.add(new LoginPanel().getPanel(),BorderLayout.WEST);

        //north panel
        northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.add(westPanel,BorderLayout.NORTH);
        northPanel.setBorder(BorderFactory.createEmptyBorder(60,150,0,0));
        northPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        //add the components to the main panel
        mainPanel.add(image);
        mainPanel.add(SignIn);
        mainPanel.add(note);
        mainPanel.add(northPanel);
        mainPanel.add(Box.createVerticalGlue());

        //set up the frame
        frame.add(mainPanel,BorderLayout.WEST);
        frame.repaint();
        frame.revalidate();
        frame.setVisible(true);
    }
}
