package View;
import javax.swing.*;
import java.awt.*;

public class AddPanel {
    //this panel will be added just once to the mainScrollPanel
    //it will *only* include an add button *without* remove button
    private static JPanel addPanel;

    //labels
    private static JLabel courseName;
    private static JLabel expectedGrade;

    //text fields for entering the course name and its expected grade
    private static JTextField Course;
    private static JTextField Grade;

    //"+" button that is responsible for adding new courses
    private static JButton addButton;

    public JPanel AddPanel(){
        //addPanel
        addPanel = new JPanel();
        addPanel.setLayout(new GridLayout(2,3));

        //customising the courseName label
        courseName = new JLabel("Course Name");
        courseName.setFont(new Font("Arial", Font.BOLD, 12));
        courseName.setHorizontalAlignment(SwingConstants.LEFT);
        courseName.setVerticalAlignment(SwingConstants.CENTER);
        courseName.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        //customising the expectedGrade label
        expectedGrade = new JLabel("Expected Grade");
        expectedGrade.setFont(new Font("Arial", Font.BOLD, 12));
        expectedGrade.setHorizontalAlignment(SwingConstants.LEFT);
        expectedGrade.setVerticalAlignment(SwingConstants.CENTER);
        expectedGrade.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        //creating the text fields of course name and its grade
        Course = new JTextField();
        Grade = new JTextField();

        //creating the add button
        addButton = new JButton("+");
        addButton.setPreferredSize(new JCheckBox().getPreferredSize());

        //add components for the add panel
        addPanel.add(courseName);
        addPanel.add(expectedGrade);
        addPanel.add(new JLabel(""));
        addPanel.add(Course);
        addPanel.add(Grade);
        addPanel.add(addButton);

        return addPanel;
    }
}
