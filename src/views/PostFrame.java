package views;
import databases.*;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PostFrame extends JFrame {
	private Clip clip;
	private String song ="sound/MP_Tiny-Button-Push.wav";
    public JPanel postPanel;
    private JButton postApplyBtn, postBackBtn,postWriterButton;
    private JLabel postTitleLabel, postWriterLabel1, postWriterLabel2, postFixedNumberLabel1, postFixedNumberLabel2, postContentLabel;

    UserVO userVO;
    UserDAO userDAO;
    PostDAO postDAO;
    private int count;
    public PostFrame(UserVO userVO, PostVO postVO){

        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        postPanel = new postPanel();
        add(postPanel);
        postPanel.setLayout(null);

        postTitleLabel =new JLabel(postVO.getTitle(),JLabel.CENTER);
        postTitleLabel.setBounds(100,50,300,60);
        postTitleLabel.setFont(new Font("Selif",Font.BOLD,30));
        postPanel.add(postTitleLabel);
        
        postWriterLabel1 = new JLabel("작성자 :");
        postWriterLabel1.setBounds(100,100,50,40);
        postWriterLabel1.setFont(new Font("Selif",Font.PLAIN,11));
        postWriterLabel1.setForeground(Color.GRAY);
        postPanel.add(postWriterLabel1);

//        postWriterLabel2 = new JLabel(postVO.getUser_Id());
//        postWriterLabel2.setBounds(150,100,100,40);
//        postWriterLabel2.setFont(new Font("Selif",Font.PLAIN,11));
//        postWriterLabel2.setForeground(Color.GRAY);
//        postPanel.add(postWriterLabel2);
        postWriterButton = new JButton(postVO.getUser_Id());
        postWriterButton.setBounds(150,100,100,40);
        postWriterButton.setFont(new Font("Selif", Font.PLAIN,11));
        postWriterButton.setForeground(Color.GRAY);
        postPanel.add(postWriterButton);

        postFixedNumberLabel1 = new JLabel("신청가능인원:");
        postFixedNumberLabel1.setBounds(280,100,70,40);
        postFixedNumberLabel1.setFont(new Font("Selif",Font.PLAIN,11));
        postFixedNumberLabel1.setForeground(Color.GRAY);
        postPanel.add(postFixedNumberLabel1);

        postFixedNumberLabel2 = new JLabel(String.valueOf(postVO.getLimit()));
        postFixedNumberLabel2.setBounds(350,100,300,40);
        postFixedNumberLabel2.setFont(new Font("Selif",Font.PLAIN,11));
        postFixedNumberLabel2.setForeground(Color.GRAY);
        postPanel.add(postFixedNumberLabel2);


        postContentLabel = new JLabel(postVO.getContent(),JLabel.CENTER);
        postContentLabel.setBounds(40, 75, 400, 200);
        postPanel.add(postContentLabel);

        postBackBtn = new JButton("뒤로가기");
        postBackBtn.setBounds(260, 400, 100, 30);
        postBackBtn.setBackground(Color.white);
        postPanel.add(postBackBtn);

        postApplyBtn = new JButton("신청하기");
        postApplyBtn.setBounds(140, 400, 100, 30);
        postApplyBtn.setBackground(Color.orange);
        postPanel.add(postApplyBtn);

        postPanel.setBackground(Color.white);

        setVisible(true);
        loadAudio(song);
        setResizable(false);

        postWriterButton.addActionListener(e->{
            clip.setFramePosition(0);
            clip.start();
            userDAO = new UserDAO();
            postDAO = new PostDAO();
            count = postDAO.countPosts(postWriterButton.getText());
            new UserInfoFrame(userInfo(postWriterButton),count);
        });
        postApplyBtn.addActionListener(e->{
        	clip.setFramePosition(0);
            clip.start();
            ApplyDAO applyDAO = new ApplyDAO();
            if(!userVO.getUser_Id().equals(postVO.getUser_Id())){
                if(applyDAO.apply(postVO)){
                    JOptionPane.showMessageDialog(null, "신청이 완료되었습니다.");
                }else{
                    JOptionPane.showMessageDialog(null, "신청이 완료되지 않았습니다.");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "자신의 게시물에는 산청할 수 없습니다.");
            }

            
        });
        postBackBtn.addActionListener(e->{
        	clip.setFramePosition(0);
            clip.start();
            new MainFrame(userVO);
            setVisible(false);
        });
        
    }
    class postPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.lightGray);
            g.drawLine(0, 140, 500, 140);

            g.setColor(Color.lightGray);
            g.drawLine(250, 114, 250, 126);

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
    public UserVO userInfo(JButton jButton){
        UserDAO userDAO = new UserDAO();
        userVO = userDAO.userInfoData(jButton.getText());

        return userVO;
    }
    public static void main(String[] args) {
        UserVO userVO = new UserVO();
        PostVO postVO = new PostVO();
        PostFrame tf = new PostFrame(userVO,postVO);

    }

}