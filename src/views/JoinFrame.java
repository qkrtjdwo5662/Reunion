package views;

import databases.UserDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinFrame extends JFrame {
    private JPanel panel;
    private JTextField idText, pwText,nameText;
    private JButton registerBtn;
    UserDAO dao = new UserDAO();

    public JoinFrame() {
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
        passwordLabel.setBounds(40, 130, 80, 40);
        panel.add(passwordLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(40, 210, 80, 40);
        panel.add(nameLabel);

        idText = new JTextField();
        idText.setBounds(160, 50, 200, 40);
        panel.add(idText);
        idText.setColumns(10);

        pwText = new JTextField();
        pwText.setColumns(10);
        pwText.setBounds(160, 130, 200, 40);
        panel.add(pwText);

        nameText = new JTextField();
        nameText.setColumns(10);
        nameText.setBounds(160, 210, 200, 40);
        panel.add(nameText);

        registerBtn = new JButton("회원등록");
        registerBtn.setBounds(200, 370, 100, 30);
        panel.add(registerBtn);


        setSize(500, 500);
        setVisible(true);
        //회원가입 액션
        registerBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                register();
            }
        });
    }
    public void register(){

    }
    public static void main(String[] args) {
        JoinFrame join = new JoinFrame();
    }


}