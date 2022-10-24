package views;

import databases.UserVO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
    private JPanel panel;

    public MainFrame(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);// window center

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);


        JLabel welcomeLabel = new JLabel( "환영합니다");
        welcomeLabel.setBounds(100, 175, 300, 150);
        panel.add(welcomeLabel);

        setSize(500, 500);
        setVisible(true);

    }
}
