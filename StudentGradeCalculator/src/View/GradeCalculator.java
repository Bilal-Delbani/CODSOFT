package View;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class GradeCalculator {

    private static JFrame frame;
    private static JPanel mainPanel;

    //this will be used to be scrollable
    private static JPanel mainScrollPanel;

    private static JScrollPane scroll;

    //scroll
    private static JScrollPane scrollPane;

    //labels
    private static JLabel welcomingMessage;
    private static JLabel message;
    private static JLabel errorMessage;

    public GradeCalculator(){
        try {
            // Set the Look and Feel to the system's default
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set up the frame
        frame = new JFrame("Student Grade Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //Set up the panels
        //mainPanel
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(20,20,20,20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        //mainScrollPanel
        mainScrollPanel = new JPanel();
        //get the add panel from the AddPanel class
        mainScrollPanel.add(new AddCourse().getAddPanel());

        scrollPane = new JScrollPane(mainScrollPanel);
        scrollPane.setPreferredSize(new Dimension(180,220));

        //customising the welcoming message label
        welcomingMessage = new JLabel("Welcome to the Student Grade Calculator!");
        welcomingMessage.setFont(new Font("Times New Roman", Font.BOLD, 30));
        welcomingMessage.setHorizontalAlignment(SwingConstants.CENTER);
        welcomingMessage.setVerticalAlignment(SwingConstants.CENTER);
        welcomingMessage.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        //customising the message label
        message = new JLabel("Enter your courses' name you are currently taking and the expected grades.");
        message.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        message.setHorizontalAlignment(SwingConstants.LEFT);
        message.setVerticalAlignment(SwingConstants.CENTER);
        message.setBorder(BorderFactory.createEmptyBorder(20, 0, 7, 0));

        //customising the error label
        errorMessage = new JLabel("Enter your courses' name you are currently taking and the expected grades.");
        errorMessage.setFont(new Font("Arial", Font.BOLD, 11));
        errorMessage.setHorizontalAlignment(SwingConstants.LEFT);
        errorMessage.setVerticalAlignment(SwingConstants.CENTER);
        errorMessage.setBorder(BorderFactory.createEmptyBorder(7, 0, 7, 0));
        errorMessage.setForeground(Color.RED);

        mainPanel.add(welcomingMessage);
        mainPanel.add(message);
        mainPanel.add(scrollPane);
        mainPanel.add(errorMessage);


        scroll = new JScrollPane(mainPanel);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frame.add(scroll);
        frame.setVisible(true);
    }
}
