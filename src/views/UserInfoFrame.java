package views;

import databases.PostVO;
import databases.UserVO;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class UserInfoFrame extends JFrame {
    private Clip clip;
    private String song = "sound/MP_Tiny-Button-Push.wav";
    public JPanel linePanel;
    private JLabel titleLabel,profileLabel, idLabel, nameLabel, phoneNumberLabel, authorityLabel,countLabel;
    private JLabel user_IdLabel, user_NameLabel, user_PhoneNumberLabel,user_AuthorityLabel,user_CountPostsLabel;
    private JButton backBtn;
    private ImageIcon icon;
    private UserVO userVO = new UserVO();
    private PostVO postVO = new PostVO();
    public UserInfoFrame(UserVO userVO, int count){
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        titleLabel =new JLabel("User Infomation",JLabel.CENTER);
        titleLabel.setBounds(100,0,300,60);
        titleLabel.setFont(new Font("Selif",Font.BOLD,30));
        add(titleLabel);

        icon = new ImageIcon("image1/images.jpeg"); // 이미지 로딩
        profileLabel = new JLabel(icon); // 이미지 레이블 만들기
        profileLabel.setBounds(200, 60,80 , 80);
        add(profileLabel);

        idLabel = new JLabel("UserId :",JLabel.RIGHT);
        idLabel.setBounds(0,145,150,30);
        add(idLabel);

        user_IdLabel = new JLabel(userVO.getUser_Id(),JLabel.LEFT);
        user_IdLabel.setBounds(160,145,150,30);
        add(user_IdLabel);

        nameLabel = new JLabel("Name :",JLabel.RIGHT);
        nameLabel.setBounds(0,180,150,30);
        add(nameLabel);

        user_NameLabel = new JLabel(userVO.getName(),JLabel.LEFT);
        user_NameLabel.setBounds(160,180,150,30);
        add(user_NameLabel);

        phoneNumberLabel = new JLabel("PhoneNumber :",JLabel.RIGHT);
        phoneNumberLabel.setBounds(0,215,150,30);
        add(phoneNumberLabel);

        user_PhoneNumberLabel = new JLabel(userVO.getPhoneNumber(),JLabel.LEFT);
        user_PhoneNumberLabel.setBounds(160,215,150,30);
        add(user_PhoneNumberLabel);

        authorityLabel = new JLabel("Authority :",JLabel.RIGHT);
        authorityLabel.setBounds(0,250,150,30);
        add(authorityLabel);

        user_AuthorityLabel = new JLabel(userVO.getAuthority(),JLabel.LEFT);
        user_AuthorityLabel.setBounds(160,250,150,30);
        add(user_AuthorityLabel);

        countLabel = new JLabel("Number Of Posts :",JLabel.RIGHT);
        countLabel.setBounds(0,285,150,30);
        add(countLabel);

        user_CountPostsLabel = new JLabel(String.valueOf(count),JLabel.LEFT);
        user_CountPostsLabel.setBounds(160,285,150,30);
        add(user_CountPostsLabel);

        backBtn = new JButton("뒤로가기");
        backBtn.setBounds(200, 400, 100, 30);
        add(backBtn);

        linePanel = new linePanel();
        add(linePanel);

        setVisible(true);
        loadAudio(song);
        setResizable(false);

        backBtn.addActionListener(e->{
            setVisible(false);

        });
    }
    class linePanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.lightGray);
            g.drawLine(0, 145, 500, 145);
            g.setColor(Color.lightGray);
            g.drawLine(0, 180, 500, 180);
            g.setColor(Color.lightGray);
            g.drawLine(0, 215, 500, 215);
            g.setColor(Color.lightGray);
            g.drawLine(0, 250, 500, 250);
            g.setColor(Color.lightGray);
            g.drawLine(0, 285, 500, 285);
            g.setColor(Color.lightGray);
            g.drawLine(0, 320, 500, 320);
        }
    }
    private void loadAudio(String pathName) {
        try {
            clip = AudioSystem.getClip(); // 비어있는 오디오 클립 만들기
            File audioFile = new File(pathName); // 오디오 파일의 경로명
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile); // 오디오 파일로부터
            clip.open(audioStream); // 재생할 오디오 스트림 열기
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        UserVO userVO = new UserVO();
        int count=0;
        UserInfoFrame uf = new UserInfoFrame(userVO, count);
    }
}
