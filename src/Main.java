import databases.ConnectDB;
import databases.UserDAO;
import views.LoginFrame;

import javax.swing.JFrame;

public class Main {
    LoginFrame loginFrame;
    UserDAO dao;
    public static void main(String[] args){
        Main main = new Main();
        main.loginFrame = new LoginFrame();
        main.dao = new UserDAO();



    }
}