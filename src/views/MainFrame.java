package views;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import databases.PostDAO;
import databases.PostVO;
import databases.UserDAO;
import databases.UserVO;

public class MainFrame extends JFrame {
    private Clip clip;
    private String song = "sound/MP_Tiny-Button-Push.wav";
    private JPanel homePanel, menuPanel, postPanel;
    private ImageIcon icon, iconCoin, iconRoom1, iconRoom2, iconRoom3, iconRoom4;
    private JLabel coinLabel, imageLabel, imageLabel_coin, titleLabel, welcomeLabel, menuLabel, postTitleLabel, copyrightLabel;
    private JButton imageBtn1, imageBtn2, imageBtn3, imageBtn4, menuHomeBtn,menuMentoringBtn, menuStudyBtn, menuReserveBtn, menuLectureBtn, writeBtn,manageUserBtn,applyMentorBtn;
    //--------------------------------------------------------------------//
    public JPanel createPostPanel;
    private JTextField titleText, memberText;
    private JButton createBtn, backBtn;
    private JTextArea contentsArea;
    private JLabel room1Label, room2Label, room3Label, room4Label, categoryLabel, nameLabel, contentsLabel, memberLabel,title;
    //--------------------------------------------------------------------//
    String selectArray[] = {"스터디그룹","멘토링", "강의"};
    JComboBox<String> selectBox;
    String select;
    String seminar = "https://dorm.hansung.ac.kr/kor/dormitory/seminarroom.do";
    String group = "https://www.hansung.ac.kr/onestop/8952/subview.do";
    String study = "https://www.hansung.ac.kr/cncschool/7312/subview.do";
    String library = "https://hsel.hansung.ac.kr/guide_group_study.mir";

    PostVO postVO;
    PostDAO postDAO;
    ArrayList<PostVO> arrayList;
    JButton[] mentoringBtn = new JButton[10];
    JButton[] studyBtn = new JButton[10];
    JButton[] lectureBtn = new JButton[10];

    public MainFrame(UserVO userVO) {

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);// window center

        homePanel = new JPanel();
        menuPanel = new JPanel();
        postPanel = new JPanel();
        add(homePanel);

        homePanel.setLayout(null);
        menuPanel.setLayout(null);
        postPanel.setLayout(null);
        Font font = new Font("Arial", Font.BOLD, 20);

        icon = new ImageIcon("image1/logo.jpg"); // 이미지 로딩
        imageLabel = new JLabel(icon); // 이미지 레이블 만들기
        imageLabel.setBounds(0, 0, 375, 325);
        postPanel.add(imageLabel);

        title = new JLabel("제 목",JLabel.CENTER);
        title.setBounds(120,95,360,20);
        homePanel.add(title);
        title.setVisible(false);

//        iconCoin = new ImageIcon("image1/coin.jpg"); // 이미지 로딩
//        imageLabel_coin = new JLabel(iconCoin); // 이미지 레이블 만들기
//        imageLabel_coin.setSize(iconCoin.getIconHeight(), iconCoin.getIconWidth());
//        imageLabel_coin.setLocation(15, 80);
//        homePanel.add(imageLabel_coin);
//
//        //coinLabel
//        coinLabel = new JLabel(String.valueOf(userVO.getPoint()));
//        coinLabel.setBounds(38, 80, 100, 20);
//        homePanel.add(coinLabel);

        manageUserBtn = new JButton("회원관리");
        manageUserBtn.setBounds(15,80,100,20);
        homePanel.add(manageUserBtn);

//        if(userVO.getAuthority().equals("master")){
//            imageLabel_coin.setVisible(false);
//            coinLabel.setVisible(false);
//            test.setVisible(true);
//        }
//        else{
//            imageLabel_coin.setVisible(true);
//            coinLabel.setVisible(true);
//            test.setVisible(false);
//        }

        //roomLabel
        room1Label = new JLabel("상빌 B1층 세미나실");
        homePanel.add(room1Label);
        room2Label = new JLabel("상상관 B2층 상상베이스");
        homePanel.add(room2Label);
        room3Label = new JLabel("상상플러스 스터디룸");
        homePanel.add(room3Label);
        room4Label = new JLabel("학술정보관 그룹스터디실");
        homePanel.add(room4Label);

        titleLabel = new JLabel("Reunion", JLabel.CENTER);
        titleLabel.setBounds(100, 10, 300, 50);
        titleLabel.setForeground(new Color(40, 40, 120, 255));
        titleLabel.setFont(font);
        homePanel.add(titleLabel);


        welcomeLabel = new JLabel(userVO.getName() + "님 환영합니다", JLabel.CENTER);
        welcomeLabel.setBounds(5, 60, 120, 20);
        homePanel.add(welcomeLabel);



        copyrightLabel = new JLabel("@2022 Team Reunion All Rights Reserved");
        copyrightLabel.setBounds(0, 450, 500, 15);
        copyrightLabel.setForeground(new Color(40, 40, 120, 255));
        homePanel.add(copyrightLabel);

        LabelThread lt = new LabelThread();
        lt.start();

        menuLabel = new JLabel("MENU", JLabel.CENTER);
        menuLabel.setBounds(0, 10, 120, 20);
        menuLabel.setForeground(new Color(255, 255, 255, 255));
        menuLabel.setFont(font);
        menuPanel.add(menuLabel);

        menuHomeBtn = new JButton("Home");
        menuStudyBtn = new JButton("스터디그룹");
        menuMentoringBtn = new JButton("멘토링");
        menuLectureBtn = new JButton("강의");
        menuReserveBtn = new JButton("스터디룸 예약");
        writeBtn = new JButton("글쓰기");
        applyMentorBtn = new JButton("멘토신청");

        //image
        iconRoom1 = new ImageIcon("image1/room1.jpg"); // 이미지 로딩      
        imageBtn1 = new JButton(iconRoom1); // 이미지 레이블 만들기
        homePanel.add(imageBtn1);
        iconRoom2 = new ImageIcon("image1/room2.jpg"); // 이미지 로딩      
        imageBtn2 = new JButton(iconRoom2); // 이미지 레이블 만들기
        homePanel.add(imageBtn2);
        iconRoom3 = new ImageIcon("image1/room3.jpg"); // 이미지 로딩      
        imageBtn3 = new JButton(iconRoom3); // 이미지 레이블 만들기
        homePanel.add(imageBtn3);
        iconRoom4 = new ImageIcon("image1/room4.jpg"); // 이미지 로딩      
        imageBtn4 = new JButton(iconRoom4); // 이미지 레이블 만들기
        homePanel.add(imageBtn4);
        //--------------------------------------------------------------------//
        menuPanel.setBounds(5, 115, 120, 325);
        menuPanel.setOpaque(true);
        menuPanel.setBackground(new Color(40, 40, 120, 255));
        homePanel.add(menuPanel);

        menuHomeBtn.setBounds(0,50,120,30);
        menuPanel.add(menuHomeBtn);

        menuStudyBtn.setBounds(0, 90, 120, 30);
        menuPanel.add(menuStudyBtn);

        menuMentoringBtn.setBounds(0, 130, 120, 30);
        menuPanel.add(menuMentoringBtn);

        menuLectureBtn.setBounds(0, 170, 120, 30);
        menuPanel.add(menuLectureBtn);

        menuReserveBtn.setBounds(0, 210, 120, 30);
        menuPanel.add(menuReserveBtn);

        writeBtn.setBounds(0, 250, 120, 30);
        menuPanel.add(writeBtn);

        applyMentorBtn.setBounds(0,290,120,30);
        menuPanel.add(applyMentorBtn);



        postPanel.setBounds(125, 115, 375, 325);
        postPanel.setOpaque(true);
        postPanel.setBackground(new Color(255, 255, 255, 255));
        homePanel.add(postPanel);

        postTitleLabel = new JLabel("제목", JLabel.CENTER);
        postTitleLabel.setBounds(0, 10, 375, 20);
        postPanel.add(postTitleLabel);
        postTitleLabel.setVisible(false);

        homePanel.setOpaque(true);
        homePanel.setBackground(Color.WHITE);

        //--------------------------------------------------------------------//
        createPostPanel = new JPanel();
        add(createPostPanel);
        createPostPanel.setLayout(null);

        categoryLabel = new JLabel("분류");
        categoryLabel.setBounds(50, 25, 100, 25);
        createPostPanel.add(categoryLabel);

        selectBox = new JComboBox<>(selectArray);
        selectBox.setBounds(45, 45, 150, 25);
        createPostPanel.add(selectBox);

        nameLabel = new JLabel("제목");
        nameLabel.setBounds(50, 85, 100, 25);
        createPostPanel.add(nameLabel);

        contentsLabel = new JLabel("내용");
        contentsLabel.setBounds(50, 150, 100, 25);
        createPostPanel.add(contentsLabel);

        memberLabel = new JLabel("참여 인원 수");
        memberLabel.setBounds(50, 310, 100, 25);
        createPostPanel.add(memberLabel);

        titleText = new JTextField();
        titleText.setBounds(45, 105, 240, 30);
        createPostPanel.add(titleText);
        titleText.setColumns(25);

        contentsArea = new JTextArea("", 10, 10);
        contentsArea.setLineWrap(true);//글쓰기 자동 줄 바꿈
        createPostPanel.add(contentsArea);
        contentsArea.setBounds(45, 170, 240, 120);
        contentsArea.setColumns(25);

        memberText = new JTextField();
        memberText.setBounds(45, 330, 40, 30);
        createPostPanel.add(memberText);
        memberText.setColumns(25);

        createBtn = new JButton("만들기");
        createBtn.setBounds(140, 400, 100, 30);
        createPostPanel.add(createBtn);

        backBtn = new JButton("뒤로가기");
        backBtn.setBounds(260, 400, 100, 30);
        createPostPanel.add(backBtn);

        //--------------------------------------------------------------------//


        setVisible(true);
        loadAudio(song);
        setResizable(false);

        add(homePanel);
        createPostPanel.setVisible(false);

        for (int i = 0; i < 10; i++) {
            mentoringBtn[i] = new JButton();
            studyBtn[i] = new JButton();
            lectureBtn[i] = new JButton();
            homePanel.add(mentoringBtn[i]);
            homePanel.add(studyBtn[i]);
            homePanel.add(lectureBtn[i]);

        }
        menuHomeBtn.addActionListener(e->{
            clip.setFramePosition(0);
            clip.start();
            for (int i = 0; i < 10; i++) {
                mentoringBtn[i].setVisible(false);
                studyBtn[i].setVisible(false);
                lectureBtn[i].setVisible(false);
            }
            title.setVisible(false);
            imageLabel.setVisible(true);
            imageBtn1.setVisible(false);
            imageBtn2.setVisible(false);
            imageBtn3.setVisible(false);
            imageBtn4.setVisible(false);
            room1Label.setVisible(false);
            room2Label.setVisible(false);
            room3Label.setVisible(false);
            room4Label.setVisible(false);

            titleLabel.setText("Reunion");

            menuHomeBtn.setEnabled(false);
            menuMentoringBtn.setEnabled(true);
            menuStudyBtn.setEnabled(true);
            menuLectureBtn.setEnabled(true);
            menuReserveBtn.setEnabled(true);
        });
        menuMentoringBtn.addActionListener(e -> {
            clip.setFramePosition(0);
            clip.start();

            title.setVisible(true);
            menuHomeBtn.setEnabled(true);
            menuMentoringBtn.setEnabled(false);
            menuStudyBtn.setEnabled(true);
            menuLectureBtn.setEnabled(true);
            menuReserveBtn.setEnabled(true);
            //true -> false
            imageLabel.setVisible(false);
            imageBtn1.setVisible(false);
            imageBtn2.setVisible(false);
            imageBtn3.setVisible(false);
            imageBtn4.setVisible(false);
            room1Label.setVisible(false);
            room2Label.setVisible(false);
            room3Label.setVisible(false);
            room4Label.setVisible(false);
            //false -> true

            //modify text
            titleLabel.setText("Mentoring");
            postDAO = new PostDAO();
            arrayList = new ArrayList<PostVO>();
            arrayList = postDAO.read(menuMentoringBtn.getText());

            for (int i = 0; i < studyBtn.length; i++) {
                studyBtn[i].setVisible(false);
                homePanel.remove(studyBtn[i]);
            }

            for (int i = 0; i < lectureBtn.length; i++) {
                lectureBtn[i].setVisible(false);
                homePanel.remove(lectureBtn[i]);
            }
            for (int i = 0; i < arrayList.size(); i++) {
                mentoringBtn[i] = new JButton(arrayList.get(i).getTitle());
                mentoringBtn[i].setBounds(0, 0 + 50 * i, 360, 50);
                mentoringBtn[i].setBorder(new LineBorder(new Color(40, 40, 120, 255),1,true));
                postPanel.add(mentoringBtn[i]);
                mentoringBtn[i].setVisible(true);
                int finalI = i;
                mentoringBtn[i].addActionListener(e1 -> {
                    clip.setFramePosition(0);
                    clip.start();
                    setVisible(false);
                    new PostFrame(userVO, arrayList.get(finalI));
                });
            }


        });
        menuStudyBtn.addActionListener(e -> {
            clip.setFramePosition(0);
            clip.start();

            title.setVisible(true);
            menuHomeBtn.setEnabled(true);
            menuMentoringBtn.setEnabled(true);
            menuStudyBtn.setEnabled(false);
            menuLectureBtn.setEnabled(true);
            menuReserveBtn.setEnabled(true);
            //true -> false
            imageLabel.setVisible(false);
            imageBtn1.setVisible(false);
            imageBtn2.setVisible(false);
            imageBtn3.setVisible(false);
            imageBtn4.setVisible(false);
            room1Label.setVisible(false);
            room2Label.setVisible(false);
            room3Label.setVisible(false);
            room4Label.setVisible(false);
            //false -> true

            //modify text
            titleLabel.setText("Study");
            postDAO = new PostDAO();
            arrayList = new ArrayList<PostVO>();
            arrayList = postDAO.read(menuStudyBtn.getText());


            for (int i = 0; i < mentoringBtn.length; i++) {
                mentoringBtn[i].setVisible(false);
                homePanel.remove(mentoringBtn[i]);

            }

            for (int i = 0; i < lectureBtn.length; i++) {
                lectureBtn[i].setVisible(false);
                homePanel.remove(lectureBtn[i]);

            }
            for (int i = 0; i < arrayList.size(); i++) {
                studyBtn[i] = new JButton(arrayList.get(i).getTitle());
                studyBtn[i].setBounds(0, 0+ 50 * i, 360, 50);
                studyBtn[i].setBorder(new LineBorder(new Color(40, 40, 120, 255),1,true));
                postPanel.add(studyBtn[i]);
                studyBtn[i].setVisible(true);
                int finalI = i;
                studyBtn[i].addActionListener(e1 -> {
                    clip.setFramePosition(0);
                    clip.start();
                    setVisible(false);
                    new PostFrame(userVO, arrayList.get(finalI));
                });
            }


        });
        menuLectureBtn.addActionListener(e -> {
            clip.setFramePosition(0);
            clip.start();

            title.setVisible(true);
            menuHomeBtn.setEnabled(true);
            menuMentoringBtn.setEnabled(true);
            menuStudyBtn.setEnabled(true);
            menuLectureBtn.setEnabled(false);
            menuReserveBtn.setEnabled(true);
            //true -> false
            imageLabel.setVisible(false);
            imageBtn1.setVisible(false);
            imageBtn2.setVisible(false);
            imageBtn3.setVisible(false);
            imageBtn4.setVisible(false);
            room1Label.setVisible(false);
            room2Label.setVisible(false);
            room3Label.setVisible(false);
            room4Label.setVisible(false);
            //false -> true

            //modify text
            titleLabel.setText("Lecture");
            postDAO = new PostDAO();
            arrayList = new ArrayList<PostVO>();
            arrayList = postDAO.read(menuLectureBtn.getText());


            for (int i = 0; i < mentoringBtn.length; i++) {
                mentoringBtn[i].setVisible(false);
                homePanel.remove(mentoringBtn[i]);

            }

            for (int i = 0; i < studyBtn.length; i++) {
                studyBtn[i].setVisible(false);
                homePanel.remove(studyBtn[i]);

            }
            for (int i = 0; i < arrayList.size(); i++) {
                lectureBtn[i] = new JButton(arrayList.get(i).getTitle());
                lectureBtn[i].setBounds(0, 0 + 50 * i, 360, 50);
                lectureBtn[i].setBorder(new LineBorder(new Color(40, 40, 120, 255),1,true));
                postPanel.add(lectureBtn[i]);
                lectureBtn[i].setVisible(true);
                int finalI = i;
                lectureBtn[i].addActionListener(e1 -> {
                    clip.setFramePosition(0);
                    clip.start();

                    setVisible(false);
                    new PostFrame(userVO, arrayList.get(finalI));
                });
            }


        });
        menuReserveBtn.addActionListener(e -> {
            clip.setFramePosition(0);
            clip.start();

            menuHomeBtn.setEnabled(true);
            menuMentoringBtn.setEnabled(true);
            menuStudyBtn.setEnabled(true);
            menuLectureBtn.setEnabled(true);
            menuReserveBtn.setEnabled(false);

            title.setVisible(false);
            imageLabel.setVisible(false);
            imageBtn1.setVisible(true);
            imageBtn2.setVisible(true);
            imageBtn3.setVisible(true);
            imageBtn4.setVisible(true);
            room1Label.setVisible(true);
            room2Label.setVisible(true);
            room3Label.setVisible(true);
            room4Label.setVisible(true);

            imageBtn1.setSize(130, 130);
            imageBtn1.setLocation(160, 115);
            room1Label.setBounds(170, 240, 200, 50);

            imageBtn2.setSize(130, 130);
            imageBtn2.setLocation(330, 115);
            room2Label.setBounds(325, 240, 200, 50);

            imageBtn3.setSize(130, 130);
            imageBtn3.setLocation(160, 290);
            room3Label.setBounds(170, 410, 200, 50);

            imageBtn4.setSize(130, 130);
            imageBtn4.setLocation(330, 290);
            room4Label.setBounds(325, 410, 200, 50);

            titleLabel.setText("Reservation");
            for (int i = 0; i < 10; i++) {
                mentoringBtn[i].setVisible(false);
                studyBtn[i].setVisible(false);
                lectureBtn[i].setVisible(false);
            }

        });



        manageUserBtn.addActionListener(e->{
            if(!userVO.getAuthority().equals("master")){
                JOptionPane.showMessageDialog(null, "권한이 없습니다.");
            }else{
                return;
            }
        });

        applyMentorBtn.addActionListener(e->{
            if(userVO.getAuthority().equals("mentee")){
                UserDAO userDAO;
                userDAO = new UserDAO();
                if(userDAO.updateAuthority(userVO.getUser_Id())) {
                    JOptionPane.showMessageDialog(null, "신청이 완료되었습니다.");
                    userVO.setAuthority("mentor");
                }else{
                    JOptionPane.showMessageDialog(null, "신청이 완료되지 않았습니다.");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "멘티만 신청이 가능합니다.");
            }
        });


        imageBtn1.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI(seminar));
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        });

        imageBtn2.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI(group));
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        });

        imageBtn3.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI(study));
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        });
        imageBtn4.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI(library));
            } catch (IOException | URISyntaxException e1) {
                e1.printStackTrace();
            }
        });
        writeBtn.addActionListener(e -> {
            clip.setFramePosition(0);
            clip.start();
            homePanel.setVisible(false);
            createPostPanel.setVisible(true);
        });

        createBtn.addActionListener(e -> {
            clip.setFramePosition(0);
            clip.start();
            select = selectBox.getSelectedItem().toString();
            System.out.println(select);
            try {
                create(userVO);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(null, "형식에 맞게 다시 작성해주세요");
                throw new RuntimeException(ex);
            }
        });
        backBtn.addActionListener(e -> {
            clip.setFramePosition(0);
            clip.start();
            homePanel.setVisible(true);
            createPostPanel.setVisible(false);
            titleText.setText("");
            contentsArea.setText("");
            memberText.setText("");
        });


    }

    public void create(UserVO vo) throws ParseException {

        postVO = new PostVO();
        postVO.setCategory(selectBox.getSelectedItem().toString());
        postVO.setTitle(titleText.getText());
        postVO.setContent(contentsArea.getText());
        postVO.setLimit(Integer.parseInt(memberText.getText()));
        postVO.setUser_Id(vo.getUser_Id());

        PostDAO postDAO = new PostDAO();
        if(selectBox.getSelectedItem().toString().equals("멘토링")){
            if(vo.getAuthority().equals("mentor")||vo.getAuthority().equals("master")){
                if (postDAO.create(postVO)) {
                    JOptionPane.showMessageDialog(null, "글생성완료");
                    createPostPanel.setVisible(false);
                    homePanel.setVisible(true);
                    titleText.setText("");
                    contentsArea.setText("");
                    memberText.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "글생성실패");
                    titleText.setText("");
                    contentsArea.setText("");
                    memberText.setText("");
                }
            }else{
                JOptionPane.showMessageDialog(null, "권한이 없습니다.");
                createPostPanel.setVisible(false);
                homePanel.setVisible(true);
                titleText.setText("");
                contentsArea.setText("");
                memberText.setText("");
            }
        }else if(selectBox.getSelectedItem().toString().equals("강의")){
            if(vo.getAuthority().equals("master")){
                if (postDAO.create(postVO)) {
                    JOptionPane.showMessageDialog(null, "글생성완료");
                    createPostPanel.setVisible(false);
                    homePanel.setVisible(true);
                    titleText.setText("");
                    contentsArea.setText("");
                    memberText.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "글생성실패");
                    titleText.setText("");
                    contentsArea.setText("");
                    memberText.setText("");
                }
            }else{
                JOptionPane.showMessageDialog(null, "권한이 없습니다.");
                createPostPanel.setVisible(false);
                homePanel.setVisible(true);
            }
        }else {
            if (postDAO.create(postVO)) {
                JOptionPane.showMessageDialog(null, "글생성완료");
                createPostPanel.setVisible(false);
                homePanel.setVisible(true);
                titleText.setText("");
                contentsArea.setText("");
                memberText.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "글생성실패");
                titleText.setText("");
                contentsArea.setText("");
                memberText.setText("");
            }
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

    class LabelThread extends Thread {
        @Override
        public void run() {
            int idx = 0;
            int pos = 5;
            while (true) {
                idx = idx + 1;
                try {
                    Thread.sleep(100);
                    int x = copyrightLabel.getX();
                    int y = copyrightLabel.getY();
                    if (x < 10) {
                        pos = 5;
                    } else if (x > 500) {
                        x = 0;
                    }
                    copyrightLabel.setLocation(x + pos, y);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        UserVO vo = new UserVO();
        MainFrame mainFrame = new MainFrame(vo);
    }
}