package views;

import databases.UserVO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
    private JPanel panel;

    public MainFrame(UserVO vo){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);// window center

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);


        JLabel welcomeLabel = new JLabel( vo.getName()+"님 환영합니다");
        welcomeLabel.setBounds(100, 100, 300, 100);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(welcomeLabel);

        JLabel userIdLabel = new JLabel( "ID : " + vo.getId());
        userIdLabel.setBounds(100, 200, 300, 100);
        userIdLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(userIdLabel);

        JLabel passwordLabel = new JLabel( "PASSWORD : " + vo.getPassword());
        passwordLabel.setBounds(100, 300, 300, 100);
        passwordLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(passwordLabel);

        setSize(500, 500);
        setVisible(true);

    }
}
