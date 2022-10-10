package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame {
    private JPanel panel;
    private JTextField username, password;
    private JButton loginBtn, joinBtn;


    public LoginFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);// window center

        panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel loginLabel = new JLabel("UserId");
        loginLabel.setBounds(40, 50, 80, 40);
        panel.add(loginLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40, 100, 80, 40);
        panel.add(passwordLabel);

        username = new JTextField();
        username.setBounds(160, 50, 200, 40);
        panel.add(username);
        username.setColumns(10);

        password = new JTextField();
        password.setColumns(10);
        password.setBounds(160, 100, 200, 40);
        panel.add(password);

        joinBtn = new JButton("회원가입");
        joinBtn.setBounds(260, 160, 100, 30);
        panel.add(joinBtn);

        loginBtn = new JButton("로그인");
        loginBtn.setBounds(150, 160, 100, 30);
        panel.add(loginBtn);



        setSize(500, 500);
        setVisible(true);
        //회원가입 액션
        joinBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
//                JoinFrame frame = new JoinFrame();
            }
        });
    }
    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
    }


}
