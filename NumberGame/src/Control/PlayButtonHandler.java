package Control;
import View.ViewGame;
import View.View_GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayButtonHandler implements ActionListener {
    private JFrame frame;
    private JPanel mainPanel;

    public PlayButtonHandler(View_GUI viewGui) {
        this.frame = viewGui.getFrame();
        this.mainPanel = viewGui.getPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.remove(mainPanel);
        new ViewGame(frame);
        frame.revalidate();
        frame.repaint();
    }
}
