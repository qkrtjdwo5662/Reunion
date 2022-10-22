package views;

import databases.UserDTO;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
    private JPanel panel;
    UserDTO dto = new UserDTO();
    public MainFrame(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);// window center

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel(dto.getId()+"님 환영합니다");
        welcomeLabel.setBounds(100, 175, 300, 150);
        panel.add(welcomeLabel);

        setSize(500, 500);
        setVisible(true);

    }
}
