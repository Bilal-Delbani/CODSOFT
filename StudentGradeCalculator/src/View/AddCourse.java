package View;
import Control.Calculator;
import Control.RemoveButtonListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class AddCourse {
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
    //"-" button that is responsible for removing its corresponding panel
    private static JButton removeButton;

    private static int GridY=0;
    private boolean remove=false;

    private HashMap<Integer, JTextField> courseHash = new HashMap<>();
    private HashMap<Integer, JTextField> gradeHash = new HashMap<>();
    private HashMap<Integer, JButton> addHash = new HashMap<>();
    private HashMap<Integer, JButton> removeHash = new HashMap<>();

    public AddCourse(){
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

        addCourse();
        remove=true;
    }


    public JPanel getAddPanel(){
        return addPanel;
    }

    public void addCourse(){
        GridY++;

        //creating and adding the course name text field
        Course = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = GridY;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(Course, gbc);
        courseHash.put(GridY,Course);

        //creating and adding the grade text field
        Grade = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = GridY;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        addPanel.add(Grade, gbc);
        gradeHash.put(GridY,Grade);

        //creating the add button
        addButton = new JButton("+");
        addButton.setFocusPainted(false);
        gbc.gridx = 3;
        gbc.gridy = GridY;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        addButton.setPreferredSize(new Dimension(40,15));
        addPanel.add(addButton, gbc);
        addHash.put(GridY,addButton);



        if(remove==true){
            //creating the remove button
            removeButton = new JButton("-");
            removeButton.setFocusPainted(false);
            gbc.gridx = 4;
            gbc.gridy = GridY;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.CENTER;
            removeButton.setPreferredSize(new Dimension(40,15));
            addPanel.add(removeButton, gbc);
            removeHash.put(GridY,removeButton);
            removeButton.addActionListener(new RemoveButtonListener(courseHash,gradeHash,addHash,removeHash,GridY,addPanel));
        }

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Calculator(Grade,GridY);
                addCourse();
            }
        });
        addPanel.revalidate();
        addPanel.repaint();
    }


}
