package View;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GradeCalculator {

    private static JFrame frame;

    //this panel will include both the below panel
    //also the messages and the grades
    private static JPanel mainPanel;

    //this panel will include the textfields
    //it will be inside the scrollPane
    private static JPanel panel;

    //this will be used for the whole frame
    private static JScrollPane mainScroll;
    //this will be used to be panel that includes the text fields within the frame
    private static JScrollPane scroll;


    //labels
    private static JLabel welcomingMessage;
    private static JLabel message;
    private static JLabel warningMessage;

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
        frame.setSize(740, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        //Set up the panels
        //mainPanel
        mainPanel = new JPanel();
        mainPanel.setBorder(new EmptyBorder(20,20,0,20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));


        //customising the welcoming message label
        welcomingMessage = new JLabel("Welcome to the Student Grade Calculator!");
        welcomingMessage.setFont(new Font("Times New Roman", Font.BOLD, 30));
        welcomingMessage.setHorizontalAlignment(SwingConstants.LEFT);
        welcomingMessage.setVerticalAlignment(SwingConstants.CENTER);
        welcomingMessage.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        //customising the message label
        message = new JLabel("Enter your courses' name you are currently taking and the expected grades (0-100).");
        message.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setVerticalAlignment(SwingConstants.CENTER);
        message.setBorder(BorderFactory.createEmptyBorder(20, 0, 7, 0));

        //customising the warning label
        warningMessage = new JLabel("Note: Any input other than integers/decimals between 0 and 100 is ignored.");
        warningMessage.setFont(new Font("Times New Roman", Font.BOLD, 13));
        warningMessage.setHorizontalAlignment(SwingConstants.LEFT);
        warningMessage.setVerticalAlignment(SwingConstants.CENTER);
        warningMessage.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
        warningMessage.setForeground(Color.RED);

        //panel
        panel = new JPanel();
        //get the add panel from the AddPanel class
        panel.add(new AddCourse().getAddPanel());
        //add the panel to the inner scroll
        scroll = new JScrollPane(panel);
        scroll.setPreferredSize(new Dimension(130,200));


        //add the welcoming message and the guide messages
        //add the pane where the courses and grades text fields are found
        mainPanel.add(welcomingMessage);
        mainPanel.add(message);
        mainPanel.add(scroll);
        mainPanel.add(warningMessage);
        mainPanel.add(new CalculationPanel().getGradesPanel());

        //this scroll will be for the whole frame that includes the main panel
        mainScroll = new JScrollPane(mainPanel);
        //mainScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frame.add(mainScroll);
        frame.setVisible(true);
    }


}
