package views;

import databases.UserVO;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JPanel welcomePanel;
    private JPanel menuPanel;

    public MainFrame(UserVO vo){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);// window center

        welcomePanel = new JPanel();
        add(welcomePanel);
        welcomePanel.setLayout(null);

        JLabel welcomeLabel = new JLabel( vo.getName()+"님 환영합니다");
        welcomeLabel.setBounds(100, 100, 300, 100);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomePanel.add(welcomeLabel);

        JLabel userIdLabel = new JLabel( "ID : " + vo.getUser_Id());
        userIdLabel.setBounds(100, 200, 300, 100);
        userIdLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomePanel.add(userIdLabel);

        JLabel passwordLabel = new JLabel( "PASSWORD : " + vo.getPassword());
        passwordLabel.setBounds(100, 300, 300, 100);
        passwordLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomePanel.add(passwordLabel);

        JLabel menuLabel= new JLabel("Menu");
        menuLabel.setBounds(0,0,80,500);
        menuLabel.setHorizontalAlignment(JLabel.CENTER);
        menuLabel.setOpaque(true);
        menuLabel.setBackground(Color.white);
        welcomePanel.add(menuLabel);


        setSize(500, 500);
        setVisible(true);

    }

    public static void main(String[] args) {
        UserVO vo = new UserVO();
        MainFrame mainFrame = new MainFrame(vo);
    }
}
