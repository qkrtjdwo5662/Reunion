package views;

import databases.UserVO;
import databases.UserDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JoinFrame extends JFrame {
    private JPanel joinPanel;
    private JTextField idText, pwText,nameText;
    private JButton backBtn,registerBtn;


    public JoinFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);// window center

        joinPanel = new JPanel();
        joinPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(joinPanel);
        joinPanel.setLayout(null);

        JLabel userIdLabel = new JLabel("UserId");
        userIdLabel.setBounds(40, 50, 80, 40);
        joinPanel.add(userIdLabel);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(40, 130, 80, 40);
        joinPanel.add(passwordLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(40, 210, 80, 40);
        joinPanel.add(nameLabel);

        idText = new JTextField();
        idText.setBounds(160, 50, 200, 40);
        joinPanel.add(idText);
        idText.setColumns(10);

        pwText = new JTextField();
        pwText.setColumns(10);
        pwText.setBounds(160, 130, 200, 40);
        joinPanel.add(pwText);

        nameText = new JTextField();
        nameText.setColumns(10);
        nameText.setBounds(160, 210, 200, 40);
        joinPanel.add(nameText);

        backBtn = new JButton("뒤로가기");
        backBtn.setBounds(145, 370, 100, 30);
        joinPanel.add(backBtn);

        registerBtn = new JButton("회원등록");
        registerBtn.setBounds(255, 370, 100, 30);
        joinPanel.add(registerBtn);


        setSize(500, 500);
        setVisible(true);
        //회원가입 액션
        backBtn.addActionListener(e ->{
            setVisible(false);
            LoginFrame loginFrame = new LoginFrame();
        });
        registerBtn.addActionListener(e -> register());
    }
    public void register(){
        UserDTO dto = new UserDTO();
        dto.setId(idText.getText());
        dto.setPassword(pwText.getText());
        dto.setName(nameText.getText());

        UserVO dao = new UserVO();
        if(dao.create(dto)){
            JOptionPane.showMessageDialog(null, "회원가입 성공");
        }else{
            JOptionPane.showMessageDialog(null, "회원가입 실패");
        }
    }


}