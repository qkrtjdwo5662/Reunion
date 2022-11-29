package views;

import databases.PostDAO;
import databases.PostVO;
import databases.UserVO;

import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.*;

public class MainFrame extends JFrame {
    private JPanel homePanel, menuPanel, postPanel;
    private ImageIcon icon;
    private JLabel imageLabel,titleLabel,welcomeLabel,menuLabel,postTitleLabel,copyrightLabel;
    private JButton menuMentoringBtn, menuStudyBtn, menuReserveBtn, menuLectureBtn,btn5;
    //--------------------------------------------------------------------//
    public JPanel createPostPanel;
    private JTextField titleText, memberText;
    private JButton createBtn, backBtn;
    private JTextArea contentsArea;
    private JLabel categoryLabel, nameLabel, contentsLabel,memberLabel;
    //--------------------------------------------------------------------//
    String selectArray[] = {"Mentoring","Study","Lecture"};
    JComboBox<String> selectBox;
    String select;

    PostVO postVO;
    PostDAO postDAO;
    ArrayList<PostVO> arrayList;
    JButton[] mentoringBtn = new JButton[10];
    JButton[] studyBtn = new JButton[10];
    JButton[] lectureBtn = new JButton[10];

    public MainFrame(UserVO userVO) {

        setSize(500,500);
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

        icon = new ImageIcon("image1/rogo.jpg"); // 이미지 로딩
        imageLabel = new JLabel(icon); // 이미지 레이블 만들기
        imageLabel.setBounds(0,0,375,325);
        postPanel.add(imageLabel);

        titleLabel = new JLabel("Reunion",JLabel.CENTER);
        titleLabel.setBounds(100, 10, 300, 50);
        titleLabel.setFont(font);
        homePanel.add(titleLabel);

        welcomeLabel = new JLabel(userVO.getName()+"님 환영합니다",JLabel.CENTER);
        welcomeLabel.setBounds(5,80,120,20);
        homePanel.add(welcomeLabel);

        copyrightLabel = new JLabel("@2022 Team Reunion All Rights Reserved",JLabel.CENTER);
        copyrightLabel.setBounds(10,450,500,15);
        homePanel.add(copyrightLabel);


        menuLabel = new JLabel("MENU",JLabel.CENTER);
        menuLabel.setBounds(0, 10, 120, 20);
        menuPanel.add(menuLabel);

        menuMentoringBtn = new JButton("Mentoring");
        menuStudyBtn = new JButton("Study");
        menuReserveBtn = new JButton("스터디룸 예약");
        menuLectureBtn = new JButton("Lecture");
        btn5 = new JButton("글쓰기");

        //--------------------------------------------------------------------//
        menuPanel.setBounds(5, 115, 120, 325);
        menuPanel.setOpaque(true);
        menuPanel.setBackground(new Color(165, 229, 252, 255));
        homePanel.add(menuPanel);

        menuMentoringBtn.setBounds(0, 50, 120, 30);
        menuPanel.add(menuMentoringBtn);

        menuStudyBtn.setBounds(0, 90, 120, 30);
        menuPanel.add(menuStudyBtn);

        menuLectureBtn.setBounds(0, 130, 120, 30);
        menuPanel.add(menuLectureBtn);

        menuReserveBtn.setBounds(0, 250, 120, 30);
        menuPanel.add(menuReserveBtn);

        btn5.setBounds(0, 290, 120, 30);
        menuPanel.add(btn5);

        postPanel.setBounds(125,115,375,325);
        postPanel.setOpaque(true);
        postPanel.setBackground(new Color(255, 255, 255, 255));
        homePanel.add(postPanel);

        postTitleLabel = new JLabel("제목",JLabel.CENTER);
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
        categoryLabel.setBounds(50, 25,100,25);
        createPostPanel.add(categoryLabel);

        selectBox = new JComboBox<>(selectArray);
        selectBox.setBounds(45,45, 150, 25);
        createPostPanel.add(selectBox);

        nameLabel = new JLabel("제목");
        nameLabel.setBounds(50, 85,100,25);
        createPostPanel.add(nameLabel);

        contentsLabel = new JLabel("내용");
        contentsLabel.setBounds(50,150,100,25);
        createPostPanel.add(contentsLabel);

        memberLabel = new JLabel("참여 인원 수");
        memberLabel.setBounds(50,310,100,25);
        createPostPanel.add(memberLabel);

        titleText = new JTextField();
        titleText.setBounds(45, 105, 240, 30);
        createPostPanel.add(titleText);
        titleText.setColumns(25);
        
        contentsArea = new JTextArea("",10,10);
        createPostPanel.add(contentsArea);
        contentsArea.setBounds(45, 170, 240, 120);
        contentsArea.setColumns(25);

        memberText = new JTextField();
        memberText.setBounds(45, 330, 40, 30);
        createPostPanel.add(memberText);
        memberText.setColumns(25);

        createBtn = new JButton("만들기");
        createBtn.setBounds(150, 400, 100, 30);
        createPostPanel.add(createBtn);

        backBtn = new JButton("뒤로가기");
        backBtn.setBounds(250, 400, 100, 30);
        createPostPanel.add(backBtn);

        //--------------------------------------------------------------------//



        setVisible(true);
        setResizable(false);

        add(homePanel);
        createPostPanel.setVisible(false);

        for(int i=0; i<10; i++){
            mentoringBtn[i] = new JButton();
            studyBtn[i] = new JButton();
            lectureBtn[i] = new JButton();
            homePanel.add(mentoringBtn[i]);
            homePanel.add(studyBtn[i]);
            homePanel.add(lectureBtn[i]);

        }
        menuMentoringBtn.addActionListener(e -> {
            menuMentoringBtn.setEnabled(false);
            menuStudyBtn.setEnabled(true);
            menuLectureBtn.setEnabled(true);
            //true -> false
            imageLabel.setVisible(false);
            //false -> true

            //modify text
            titleLabel.setText("Mentoring");
            postDAO = new PostDAO();
            arrayList =new ArrayList<PostVO>();
            arrayList = postDAO.read(menuMentoringBtn.getText());

            for(int i=0; i<studyBtn.length; i++)
            {
                studyBtn[i].setVisible(false);
                homePanel.remove(studyBtn[i]);
            }

            for(int i=0; i<lectureBtn.length; i++)
            {
                lectureBtn[i].setVisible(false);
                homePanel.remove(lectureBtn[i]);
            }
            for(int i=0; i<arrayList.size(); i++) {
                mentoringBtn[i] = new JButton(arrayList.get(i).getTitle());
                mentoringBtn[i].setBounds(140, 115 + 50 * i, 330, 50);
                homePanel.add(mentoringBtn[i]);
                mentoringBtn[i].setVisible(true);
                int finalI = i;
                mentoringBtn[i].addActionListener(e1 -> {
                    setVisible(false);
                    new PostFrame(userVO,arrayList.get(finalI));
                });
            }


        });
        menuStudyBtn.addActionListener(e->{
            menuMentoringBtn.setEnabled(true);
            menuStudyBtn.setEnabled(false);
            menuLectureBtn.setEnabled(true);
            //true -> false
            imageLabel.setVisible(false);
            //false -> true

            //modify text
            titleLabel.setText("Study");
            postDAO = new PostDAO();
            arrayList =new ArrayList<PostVO>();
            arrayList = postDAO.read(menuStudyBtn.getText());



            for(int i=0; i<mentoringBtn.length; i++)
            {
                mentoringBtn[i].setVisible(false);
                homePanel.remove(mentoringBtn[i]);

            }

            for(int i=0; i<lectureBtn.length; i++)
            {
                lectureBtn[i].setVisible(false);
                homePanel.remove(lectureBtn[i]);

            }
            for(int i=0; i<arrayList.size(); i++)
            {
                studyBtn[i] = new JButton(arrayList.get(i).getTitle());
                studyBtn[i].setBounds(150, 115+50*i, 350, 50);
                homePanel.add(studyBtn[i]);
                studyBtn[i].setVisible(true);
                int finalI = i;
                studyBtn[i].addActionListener(e1 -> {
                    setVisible(false);
                    new PostFrame(userVO,arrayList.get(finalI));
                });
            }



        });
        menuReserveBtn.addActionListener(e->{

        });
        menuLectureBtn.addActionListener(e->{
            menuMentoringBtn.setEnabled(true);
            menuStudyBtn.setEnabled(true);
            menuLectureBtn.setEnabled(false);
            //true -> false
            imageLabel.setVisible(false);
            //false -> true

            //modify text
            titleLabel.setText("Lecture");
            postDAO = new PostDAO();
            arrayList =new ArrayList<PostVO>();
            arrayList = postDAO.read(menuLectureBtn.getText());


            for(int i=0; i<mentoringBtn.length; i++)
            {
                mentoringBtn[i].setVisible(false);
                homePanel.remove(mentoringBtn[i]);

            }

            for(int i=0; i<studyBtn.length; i++)
            {
                studyBtn[i].setVisible(false);
               homePanel.remove(studyBtn[i]);

            }
            for(int i=0; i<arrayList.size(); i++)
            {
                lectureBtn[i] = new JButton(arrayList.get(i).getTitle());
                lectureBtn[i].setBounds(150, 115+50*i, 350, 50);
                homePanel.add(lectureBtn[i]);
                lectureBtn[i].setVisible(true);
                int finalI = i;
                lectureBtn[i].addActionListener(e1 -> {

                    setVisible(false);
                    new PostFrame(userVO,arrayList.get(finalI));
                });
            }



        });
        btn5.addActionListener(e->{
            homePanel.setVisible(false);
            createPostPanel.setVisible(true);
        });

        createBtn.addActionListener(e->{
            select = selectBox.getSelectedItem().toString();
            System.out.println(select);
            try {
                create(userVO);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        });
        backBtn.addActionListener(e->{
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
        if(postDAO.create(postVO)){
            JOptionPane.showMessageDialog(null,"글생성완료");
            createPostPanel.setVisible(false);
            homePanel.setVisible(true);
        }else {
            JOptionPane.showMessageDialog(null,"글생성실패");
        }
    }

    public static void main(String[] args) {
        UserVO vo = new UserVO();
        MainFrame mainFrame = new MainFrame(vo);
    }
}