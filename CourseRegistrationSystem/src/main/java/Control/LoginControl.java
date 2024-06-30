package Control;
import Services.LoginService;
import javax.swing.*;
import java.util.concurrent.CompletableFuture;

public class LoginControl {
    private static LoginService login = new LoginService();
    private static String username;
    private static String password;

    public CompletableFuture<Boolean> Login(JTextField Username , JPasswordField Password){
        setUsername(Username);
        setPassword(Password);
        return login.Authenticate(username,password);

    }
    public static void setUsername(JTextField Username){
        username = Username.getText();
    }
    public static void setPassword(JPasswordField Password){
        password = new String(Password.getPassword());
    }
}
