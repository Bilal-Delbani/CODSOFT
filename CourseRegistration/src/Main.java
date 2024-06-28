import View.Login;
import javax.swing.*;
import java.awt.*;

public class Main {

    private static JFrame frame;
    private static Dimension screenSize;

    public static void main(String[] args) {
        frame = new JFrame("CODSOFT International University - CIU");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width,screenSize.height);
        frame.setFocusable(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        new Login(frame);

    }
}