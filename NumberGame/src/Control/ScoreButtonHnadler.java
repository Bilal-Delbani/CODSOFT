package Control;
import View.NewGame;
import View.Score;
import View.ViewGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreButtonHnadler implements ActionListener {
    private JFrame frame;
    private JPanel mainPanel;

    public ScoreButtonHnadler(NewGame newGame) {
        this.frame = newGame.getFrame();
        this.mainPanel = newGame.getPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.remove(mainPanel);
        new Score(frame);
        frame.revalidate();
        frame.repaint();
    }
}
