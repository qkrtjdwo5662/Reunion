package views;

import databases.UserDAO;
import databases.UserVO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginFrame extends JFrame {
    public JPanel loginPanel;
    private JTextField id_LoginText, pw_LoginText;
    private JButton loginBtn, joinBtn;

    public JPanel joinPanel;
    private JTextField id_JoinText, pw_JoinText, name_JoinText;
    private JButton backBtn,registerBtn;

    UserVO vo;
    public LoginFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);// window center

        //login 패널
        loginPanel = new JPanel();
        add(loginPanel);
        loginPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        loginPanel.setLayout(null);

        JLabel id_LoginLabel = new JLabel("UserId");
        id_LoginLabel.setBounds(40, 50, 80, 40);
        loginPanel.add(id_LoginLabel);

        JLabel pw_LoginLabel = new JLabel("Password");
        pw_LoginLabel.setBounds(40, 100, 80, 40);
        loginPanel.add(pw_LoginLabel);

        id_LoginText = new JTextField();
        id_LoginText.setBounds(160, 50, 200, 40);
        loginPanel.add(id_LoginText);
        id_LoginText.setColumns(10);

        pw_LoginText = new JTextField();
        pw_LoginText.setColumns(10);
        pw_LoginText.setBounds(160, 100, 200, 40);
        loginPanel.add(pw_LoginText);


        joinBtn = new JButton("회원가입");
        joinBtn.setBounds(260, 160, 100, 30);
        loginPanel.add(joinBtn);

        loginBtn = new JButton("로그인");
        loginBtn.setBounds(150, 160, 100, 30);
        loginPanel.add(loginBtn);


        //join 패널
        joinPanel = new JPanel();
        add(joinPanel);
        joinPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        joinPanel.setLayout(null);

        JLabel id_JoinLabel = new JLabel("UserId");
        id_JoinLabel.setBounds(40, 50, 80, 40);
        joinPanel.add(id_JoinLabel);

        JLabel pw_JoinLabel = new JLabel("Password");
        pw_JoinLabel.setBounds(40, 130, 80, 40);
        joinPanel.add(pw_JoinLabel);

        JLabel name_JoinLabel = new JLabel("Name");
        name_JoinLabel.setBounds(40, 210, 80, 40);
        joinPanel.add(name_JoinLabel);

        id_JoinText = new JTextField();
        id_JoinText.setBounds(160, 50, 200, 40);
        joinPanel.add(id_JoinText);
        id_JoinText.setColumns(10);

        pw_JoinText = new JTextField();
        pw_JoinText.setColumns(10);
        pw_JoinText.setBounds(160, 130, 200, 40);
        joinPanel.add(pw_JoinText);

        name_JoinText = new JTextField();
        name_JoinText.setColumns(10);
        name_JoinText.setBounds(160, 210, 200, 40);
        joinPanel.add(name_JoinText);

        backBtn = new JButton("뒤로가기");
        backBtn.setBounds(145, 370, 100, 30);
        joinPanel.add(backBtn);

        registerBtn = new JButton("회원등록");
        registerBtn.setBounds(255, 370, 100, 30);
        joinPanel.add(registerBtn);

        setSize(500, 500);
        setVisible(true);

        add(loginPanel);
        joinPanel.setVisible(false);

        loginBtn.addActionListener(e-> {
                login();
        });
        joinBtn.addActionListener(e -> {
                loginPanel.setVisible(false);
                joinPanel.setVisible(true);
        });
        //회원가입 액션
        backBtn.addActionListener(e ->{
            loginPanel.setVisible(true);
            joinPanel.setVisible(false);
        });
        registerBtn.addActionListener(e -> register());


    }
    public void register(){
        vo = new UserVO();
        vo.setId(id_JoinText.getText());
        vo.setPassword(pw_JoinText.getText());
        vo.setName(name_JoinText.getText());

        UserDAO dao = new UserDAO();
        if(dao.create(vo)){
            JOptionPane.showMessageDialog(null, "회원가입 성공");
        }else{
            JOptionPane.showMessageDialog(null, "회원가입 실패");
        }
    }



    public void login(){
        String id = id_LoginText.getText();
        String password = pw_LoginText.getText();

        if(id.length()==0){
            JOptionPane.showMessageDialog(this, "아이디를 입력하시오");
            id_LoginText.requestFocus();
        }
        else if(password.length()==0){
            JOptionPane.showMessageDialog(this, "패스워드를 입력하시오");
            pw_LoginText.requestFocus();
        }

        UserDAO dao = new UserDAO();
        if(dao.login(id,password)){
            vo = dao.userData(id,password);
            JOptionPane.showMessageDialog(null, "로그인 성공");
            setVisible(false);

            MainFrame mainFrame = new MainFrame(vo);
        }else{
            JOptionPane.showMessageDialog(null, "로그인 정보를 확인하세요");
        }

    }
    public UserVO data(){
        UserDAO dao = new UserDAO();
        UserVO vo = dao.userData(id_LoginText.getText(), pw_LoginText.getText());
        return vo;
    }

    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
    }


}
