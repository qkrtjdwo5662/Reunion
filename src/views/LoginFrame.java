package views;

import databases.UserDAO;
import databases.UserVO;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame {
	private Clip clip;
	private String song ="sound/MP_Tiny-Button-Push.wav";
    private JPanel loginPanel;
    private JTextField id_LoginText, pw_LoginText;
    private JButton loginBtn, joinBtn;

    private JPanel joinPanel;
    private JTextField id_JoinText, pw_JoinText, name_JoinText,phoneNum_JoinText,email_JoinText;
    private JButton backBtn,registerBtn;

    UserVO userVO;
    public LoginFrame() {
        setSize(500, 500);
        setLocationRelativeTo(null);// window center
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


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

        pw_LoginText = new JPasswordField();
        pw_LoginText.setColumns(10);
        pw_LoginText.setBounds(160, 100, 200, 40);
        //pw_LoginText.set('*');
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
        pw_JoinLabel.setBounds(40, 110, 80, 40);
        joinPanel.add(pw_JoinLabel);

        JLabel name_JoinLabel = new JLabel("Name");
        name_JoinLabel.setBounds(40, 170, 80, 40);
        joinPanel.add(name_JoinLabel);

        JLabel phoneNum_JoinLabel = new JLabel("PhoneNum");
        phoneNum_JoinLabel.setBounds(40, 230, 80, 40);
        joinPanel.add(phoneNum_JoinLabel);

        JLabel email_JoinLabel = new JLabel("Email");
        email_JoinLabel.setBounds(40, 290, 80, 40);
        joinPanel.add(email_JoinLabel);

        id_JoinText = new JTextField();
        id_JoinText.setBounds(160, 50, 200, 40);
        joinPanel.add(id_JoinText);
        id_JoinText.setColumns(10);

        pw_JoinText = new JPasswordField();
        pw_JoinText.setColumns(10);
        pw_JoinText.setBounds(160, 110, 200, 40);
        joinPanel.add(pw_JoinText);

        name_JoinText = new JTextField();
        name_JoinText.setColumns(10);
        name_JoinText.setBounds(160, 170, 200, 40);
        joinPanel.add(name_JoinText);

        phoneNum_JoinText = new JTextField();
        phoneNum_JoinText.setColumns(10);
        phoneNum_JoinText.setBounds(160,230,200,40);
        joinPanel.add(phoneNum_JoinText);

        email_JoinText = new JTextField();
        email_JoinText.setColumns(10);
        email_JoinText.setBounds(160,290,200,40);
        joinPanel.add(email_JoinText);

        backBtn = new JButton("뒤로가기");
        backBtn.setBounds(145, 370, 100, 30);
        joinPanel.add(backBtn);

        registerBtn = new JButton("회원등록");
        registerBtn.setBounds(255, 370, 100, 30);
        joinPanel.add(registerBtn);


        setVisible(true);
        loadAudio(song);
        setResizable(false);

        add(loginPanel);
        joinPanel.setVisible(false);

        loginBtn.addActionListener(e-> {
        	clip.setFramePosition(0);
            clip.start();
                login();
        });
        joinBtn.addActionListener(e -> {
        	clip.setFramePosition(0);
            clip.start();
            loginPanel.setVisible(false);
            joinPanel.setVisible(true);
        });
        backBtn.addActionListener(e ->{
        	clip.setFramePosition(0);
            clip.start();
            loginPanel.setVisible(true);
            joinPanel.setVisible(false);

            id_JoinText.setText("");
            pw_JoinText.setText("");
            name_JoinText.setText("");
            phoneNum_JoinText.setText("");
            email_JoinText.setText("");
        });
        
        registerBtn.addActionListener(e -> {
        	clip.setFramePosition(0);
            clip.start();
            register();
        });


    }
    public void register(){
        userVO = new UserVO();
        userVO.setUser_Id(id_JoinText.getText());
        userVO.setPassword(pw_JoinText.getText());
        userVO.setName(name_JoinText.getText());
        userVO.setPhoneNumber(phoneNum_JoinText.getText());
        userVO.setEmail(email_JoinText.getText());

        UserDAO dao = new UserDAO();
        if(dao.create(userVO)){
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
            userVO = dao.userData(id,password);
            JOptionPane.showMessageDialog(null, "로그인 성공");
            setVisible(false);

            MainFrame mf = new MainFrame(userVO);
        }else{
            JOptionPane.showMessageDialog(null, "로그인 정보를 확인하세요");
        }

    }

    private void loadAudio(String pathName) {
        try {
            clip = AudioSystem.getClip(); // 비어있는 오디오 클립 만들기
              File audioFile = new File(pathName); // 오디오 파일의 경로명
              AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile); // 오디오 파일로부터
              clip.open(audioStream); // 재생할 오디오 스트림 열기
          }
          catch (LineUnavailableException e) { e.printStackTrace(); }
          catch (UnsupportedAudioFileException e) { e.printStackTrace(); }
          catch (IOException e) { e.printStackTrace(); }

        }


    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
    }


}
