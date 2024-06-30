package Services;

import Repositories.LoginRepository;

import java.util.concurrent.CompletableFuture;

public class LoginService {
    private static LoginRepository loginRepo;
    private static String username;
    private static String password;

    public CompletableFuture<Boolean> Authenticate(String Username , String Password){
        setUsername(Username);
        setPassword(Password);
        loginRepo = new LoginRepository();
        return loginRepo.checkUser(username, password);

    }
    public void setUsername(String Username){
        this.username = Username;
    }
    public void setPassword(String Password){
        this.password = Password;
    }

}
