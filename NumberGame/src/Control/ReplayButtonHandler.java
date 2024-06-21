package Control;
import View.NewGame;
import View.Score;
import View.ViewGame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReplayButtonHandler implements ActionListener {
    private JFrame frame;
    private JPanel mainPanel;

    public ReplayButtonHandler(NewGame newGame) {
        this.frame = newGame.getFrame();
        this.mainPanel = newGame.getPanel();
    }
    public ReplayButtonHandler(Score score) {
        this.frame = score.getFrame();
        this.mainPanel = score.getPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.remove(mainPanel);
        new ViewGame(frame);
        frame.revalidate();
        frame.repaint();
    }


}
