package View;

import javax.swing.*;
import java.awt.*;

public class RemovePanel {
    //this panel will include add and *remove* buttons
    //it will be dynamically added to the mainScrollPanel
    private static JPanel removePanel;

    //text fields for entering the course name and its expected grade
    private static JTextField Course;
    private static JTextField Grade;

    //"+" button that is responsible for adding new courses
    private static JButton addButton;

    //"-" button that is responsible for removing its corresponding panel;
    private static JButton removeButton;

    public JPanel RemovePanel(){
        //removePanel
        removePanel = new JPanel();
        removePanel.setLayout(new GridLayout(1,4,15,20));

        //creating the text fields of course name and its grade
        Course = new JTextField();
        Grade = new JTextField();

        //creating the add button
        addButton = new JButton("+");
        addButton.setPreferredSize(new JCheckBox().getPreferredSize());

        //creating the remove button
        removeButton = new JButton("-");
        removeButton.setPreferredSize(new JCheckBox().getPreferredSize());

        //add components for the remove panel
        removePanel.add(Course);
        removePanel.add(Grade);
        removePanel.add(addButton);
        removePanel.add(removeButton);

        return removePanel;
    }
}
