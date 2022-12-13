package views;

import databases.UserDAO;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ManagerFrame extends JFrame {
    private Clip clip;
    private String song = "sound/MP_Tiny-Button-Push.wav";
    private JLabel titleLabel;
    UserDAO userDAO;
    public ManagerFrame() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);// window center

        titleLabel =new JLabel("회원관리",JLabel.CENTER);
        titleLabel.setBounds(100,0,300,50);
        titleLabel.setFont(new Font("Selif",Font.BOLD,20));
        add(titleLabel);

        String header[] ={"ID","Name","PhoneNumber","Email","Authority","ApplyMentor","1"};


        JTable jt = new JTable(userDAO.readAll().,header);
        setVisible(true);
        loadAudio(song);
        setResizable(false);
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
        new ManagerFrame();
    }
}

