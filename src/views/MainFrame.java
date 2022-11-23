package views;

import databases.UserVO;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame{
    private JPanel homePanel;
    private JPanel btnPanel;
    private ImageIcon icon;
    private JLabel imageLabel;
    private JLabel titleLabel;
    private JLabel welcomeLabel;
    private JLabel menuLabel;
    private JLabel infoLabel;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private String info;
    public MainFrame(UserVO vo) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);// window center

        //프레임 패널 생성
        homePanel = new JPanel();
        btnPanel = new JPanel();

        add(homePanel);

        homePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        homePanel.setLayout(null);
        btnPanel.setLayout(null);
        Font font = new Font("Arial", Font.BOLD, 20);

        //image
        icon = new ImageIcon("image1/rogo.jpg"); // 이미지 로딩
        imageLabel = new JLabel(icon); // 이미지 레이블 만들기

        //이미지 레이블의 크기와 위치 지정
        imageLabel.setSize(icon.getIconHeight(),icon.getIconWidth());
        imageLabel.setLocation(200,80);
        homePanel.add(imageLabel);

        //textlabel
        titleLabel = new JLabel("Reunion");
        titleLabel.setBounds(200, 10, 331, 50);
        homePanel.add(titleLabel);
        titleLabel.setFont(font);

        welcomeLabel = new JLabel(vo.getName()+"님 환영합니다");
        welcomeLabel.setBounds(40,80,150,20);
        homePanel.add(welcomeLabel);

        //menulabel
        menuLabel = new JLabel("MENU");
        menuLabel.setBounds(43, 10, 100, 20);
        btnPanel.add(menuLabel);

        infoLabel = new JLabel(info);
        infoLabel.setBounds(280,100,150,20);
        homePanel.add(infoLabel);
        //menubutton 생성
        btn1 = new JButton("Mentoring");
        btn2 = new JButton("Study");
        btn3 = new JButton("스터디룸 예약");
        btn4 = new JButton("Lecture");
        btn5 = new JButton("글쓰기");
        btn6 = new JButton("검색");

        //btnpanel panel에 추가
        btnPanel.setBounds(30, 115, 120, 210);
        btnPanel.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
        btnPanel.setBackground(Color.GRAY); // 배경색을 CYAN 색으로 변경
        homePanel.add(btnPanel);

        //멘토/멘티 버튼 설정
        btn1.setBounds(0, 50, 120, 30);
        btn1.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
        btn1.setBackground(Color.GRAY); // 배경색을 CYAN 색으로 변경
        btnPanel.add(btn1);

        //스터디 버튼 설정
        btn2.setBounds(0, 90, 120, 30);
        btn2.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
        btn2.setBackground(Color.GRAY); // 배경색을 CYAN 색으로 변경
        btnPanel.add(btn2);

        //스터디룸 버튼 설정
        btn3.setBounds(0, 130, 120, 30);
        btn3.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
        btn3.setBackground(Color.GRAY); // 배경색을 CYAN 색으로 변경
        btnPanel.add(btn3);

        //졸업생 버튼 설정
        btn4.setBounds(0, 170, 120, 30);
        btn4.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
        btn4.setBackground(Color.GRAY); // 배경색을 CYAN 색으로 변경
        btnPanel.add(btn4);

        //글쓰기 버튼 설정
        btn5.setBounds(30, 370, 120, 20);
        btn5.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
        btn5.setBackground(Color.WHITE); // 배경색을 CYAN 색으로 변경
        homePanel.add(btn5);

        //검색 버튼 설정
        btn6.setBounds(30, 390, 120, 20);
        btn6.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
        btn6.setBackground(Color.WHITE); // 배경색을 CYAN 색으로 변경
        homePanel.add(btn6);

        //프레임 조정
        homePanel.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
        homePanel.setBackground(Color.WHITE); // 배경색을 CYAN 색으로 변경


        setSize(500,500);
        setVisible(true);
        setResizable(false);

        btn1.addActionListener(e -> {
            //true -> false
            imageLabel.setVisible(false);
            //false -> true

            //modify text
            titleLabel.setText("Mentor");
            infoLabel.setText(btn1.getText());
        });
        btn2.addActionListener(e->{
            //true -> false
            imageLabel.setVisible(false);
            //false -> true

            //modify text
            titleLabel.setText("Study");
            infoLabel.setText(btn2.getText());
        });
        btn3.addActionListener(e->{

        });
        btn4.addActionListener(e->{

        });

    }
    public static void main(String[] args) {
        UserVO vo = new UserVO();
        MainFrame mainFrame = new MainFrame(vo);
    }
}