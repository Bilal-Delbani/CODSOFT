package View;
import Customising.CustomButton;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


public class LoginPanel {
    private static JPanel panel;
    private static GridBagConstraints gbc;
    private static JLabel Username;
    private static JLabel Password;
    private static JTextField username;
    private static JPasswordField password;
    private static JLabel forgetPass;
    private static JButton Login;

    public LoginPanel(){
        panel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(0, 5, 20, 5); // Add padding around components

        //customising the Username label
        Username = CustomiseLabel(Username,"Username       ");
        //adding the Username label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(Username, gbc);

        //customising the Password label
        Password = CustomiseLabel(Password,"Password       ");
        //adding the average label
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(Password, gbc);

        //creating and adding the username text field
        username = new JTextField("");
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.ipady = 10;
        gbc.ipadx = 15;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(username, gbc);

        //creating and adding the password text field
        password = new JPasswordField(25);
        password.setText("");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.ipady = 10;
        gbc.ipadx = 15;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(password, gbc);


        //creating and adding the Login button
        Login = new CustomButton("Log In",Color.WHITE, new Color(220,220,220));
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.ipady = 17;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(17,8,0,150);
        panel.add(Login, gbc);

        //creating and adding the forgetPass label
        forgetPass = CustomiseLabel(forgetPass,"<html><a href='https://www.google.com/'>Forgot?</a></html>");
        forgetPass.setForeground(Color.MAGENTA);
        forgetPass.setFont(new Font("Monospace",Font.PLAIN,16));
        forgetPass.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor to hand
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0,15,25,0);
        panel.add(forgetPass, gbc);

        // Adding a mouse listener to the forgetPass label to make it clickable
        forgetPass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.google.com/"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }
    public static JLabel CustomiseLabel(JLabel label, String text){
        label = new JLabel(text);
        label.setFont(new Font("Monospace", Font.BOLD, 18));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.DARK_GRAY);

        return label;
    }

    public JPanel getPanel(){
        return panel;
    }

}
