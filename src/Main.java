import databases.ConnectDB;
import views.LoginFrame;

import javax.swing.JFrame;

public class Main {
    ConnectDB connectDB;
    LoginFrame loginFrame;

    public static void main(String[] args){
        Main main = new Main();
        main.loginFrame = new LoginFrame();
        main.connectDB = new ConnectDB();
    }
}