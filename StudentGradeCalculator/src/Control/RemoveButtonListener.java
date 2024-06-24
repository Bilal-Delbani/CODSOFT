package Control;

import Model.Calculate;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class RemoveButtonListener implements ActionListener {
    private int index;
    private HashMap<Integer, JTextField> courseHash = new HashMap<>();
    private HashMap<Integer, JTextField> gradeHash = new HashMap<>();
    private HashMap<Integer, JButton> addHash = new HashMap<>();
    private HashMap<Integer, JButton> removeHash = new HashMap<>();
    private JPanel addPanel;

    public RemoveButtonListener(HashMap<Integer, JTextField> courseHash, HashMap<Integer, JTextField> gradeHash, HashMap<Integer, JButton> addHash, HashMap<Integer, JButton> removeHash, int GridY, JPanel addPanel){
        index = GridY;
        this.courseHash = courseHash;
        this.gradeHash = gradeHash;
        this.addHash = addHash;
        this.removeHash = removeHash;
        this.addPanel = addPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField course = courseHash.remove(index);
        JTextField grade = gradeHash.remove(index);
        JButton add = addHash.remove(index);
        JButton remove = removeHash.remove(index);

        addPanel.remove(course);
        addPanel.remove(grade);
        addPanel.remove(add);
        addPanel.remove(remove);

        new Calculate(grade);
        addPanel.revalidate();
        addPanel.repaint();
    }
}
