package views;

import databases.UserDAO;
import databases.UserDTO;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame {
    private JPanel panel;
    private JTextField idText, pwText;
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

        idText = new JTextField();
        idText.setBounds(160, 50, 200, 40);
        panel.add(idText);
        idText.setColumns(10);

        pwText = new JTextField();
        pwText.setColumns(10);
        pwText.setBounds(160, 100, 200, 40);
        panel.add(pwText);

        joinBtn = new JButton("회원가입");
        joinBtn.setBounds(260, 160, 100, 30);
        panel.add(joinBtn);

        loginBtn = new JButton("로그인");
        loginBtn.setBounds(150, 160, 100, 30);
        panel.add(loginBtn);



        setSize(500, 500);
        setVisible(true);
        //회원가입 액션
        loginBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                login();
                MainFrame mainFrame = new MainFrame();
            }
        });
        joinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JoinFrame join = new JoinFrame();
            }
        });
    }
    public void login(){
        String id = idText.getText();
        String password = pwText.getText();

        if(id.length()==0){
            JOptionPane.showMessageDialog(this, "아이디를 입력하시오");
            idText.requestFocus();
        }
        else if(password.length()==0){
            JOptionPane.showMessageDialog(this, "패스워드를 입력하시오");
            pwText.requestFocus();
        }

        UserDAO dao = new UserDAO();
        if(dao.read(id,password)){
            JOptionPane.showMessageDialog(null, "로그인 성공");
        }
        UserDTO dto = new UserDTO();
        dto.setId(id);
        dto.setPassword(password);


    }



}
