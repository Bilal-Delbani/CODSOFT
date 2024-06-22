package View;
import javax.swing.*;
import java.awt.*;

public class AddPanel {
    //this panel will be added just once to the mainScrollPanel
    //it will *only* include an add button *without* remove button
    private static JPanel addPanel;

    private static GridBagConstraints gbc;

    //labels
    private static JLabel courseName;
    private static JLabel expectedGrade;

    //text fields for entering the course name and its expected grade
    private static JTextField Course;
    private static JTextField Grade;

    //"+" button that is responsible for adding new courses
    private static JButton addButton;

    public AddPanel(){
        //addPanel
        addPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 0, 5); // Add padding around components


        //customising the courseName label
        courseName = new JLabel("Course Name                    ");
        courseName.setFont(new Font("Monospace", Font.PLAIN, 12));
        courseName.setHorizontalAlignment(SwingConstants.LEFT);
        courseName.setVerticalAlignment(SwingConstants.CENTER);
        courseName.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));

        //adding the course name label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        addPanel.add(courseName, gbc);

        //customising the expectedGrade label
        expectedGrade = new JLabel("Expected Grade                 ");
        expectedGrade.setFont(new Font("Monospace", Font.PLAIN, 12));
        expectedGrade.setHorizontalAlignment(SwingConstants.LEFT);
        expectedGrade.setVerticalAlignment(SwingConstants.CENTER);
        expectedGrade.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));

        //adding the expected grade label
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        addPanel.add(expectedGrade, gbc);


        //creating and adding the course name text field
        Course = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(Course, gbc);

        //creating and adding the grade text field
        Grade = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(Grade, gbc);


        //creating the add button
        addButton = new JButton("+");
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        addButton.setPreferredSize(new Dimension(40,15));
        addPanel.add(addButton, gbc);


    }

    public JPanel getAddPanel(){
        return addPanel;
    }
}
