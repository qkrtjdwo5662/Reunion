package views;

import databases.PostDAO;
import databases.PostVO;
import databases.UserVO;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame{
    private JPanel homePanel,btnPanel;
    private ImageIcon icon;
    private JLabel imageLabel,titleLabel,welcomeLabel,menuLabel,infoLabel;
    private JButton btn1,btn2,btn3,btn4,btn5,btn6;
    private String info;

    public JPanel createPost_Panel;
    private JTextField titleText, memberText;
    private JButton createBtn, backBtn;
    private JTextArea contentsArea,TextArea;
    String selectArray[] = {"Mentoring","Study","Lecture"};
    JComboBox<String> selectBox;
    String select;
    private JLabel categoryLabel, nameLabel, contentsLabel,memberLabel;
    PostVO postVO;
    PostDAO postDAO;
    ArrayList<PostVO> arrayList;
    JButton[] mentoringBtn = new JButton[10];
    JButton[] studyBtn = new JButton[10];
    JButton[] lectureBtn = new JButton[10];

    private JButton study;
    public MainFrame(UserVO vo) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);// window center


        //프레임 패널 생성
        homePanel = new JPanel();
        btnPanel = new JPanel();
        JPanel test = new JPanel();
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

        //write 패널
        createPost_Panel = new JPanel();
        add(createPost_Panel);
        createPost_Panel.setLayout(null);
        

        categoryLabel = new JLabel("분류");
        categoryLabel.setBounds(50, 25,100,25);
        createPost_Panel.add(categoryLabel);

        selectBox = new JComboBox<>(selectArray);
        selectBox.setBounds(45,45, 150, 25);
        createPost_Panel.add(selectBox);

        nameLabel = new JLabel("제목");
        nameLabel.setBounds(50, 85,100,25);
        createPost_Panel.add(nameLabel);

        contentsLabel = new JLabel("내용");
        contentsLabel.setBounds(50,150,100,25);
        createPost_Panel.add(contentsLabel);

        memberLabel = new JLabel("참여 인원 수");
        memberLabel.setBounds(50,310,100,25);
        createPost_Panel.add(memberLabel);

        titleText = new JTextField();
        titleText.setBounds(45, 105, 240, 30);
        createPost_Panel.add(titleText);
        titleText.setColumns(25);
        
        contentsArea = new JTextArea("",10,10);
        createPost_Panel.add(contentsArea);
        contentsArea.setBounds(45, 170, 240, 120);
        contentsArea.setColumns(25);

        memberText = new JTextField();
        memberText.setBounds(45, 330, 40, 30);
        createPost_Panel.add(memberText);
        memberText.setColumns(25);

        createBtn = new JButton("만들기");
        createBtn.setBounds(150, 400, 100, 30);
        createPost_Panel.add(createBtn);

        backBtn = new JButton("뒤로가기");
        backBtn.setBounds(250, 400, 100, 30);
        createPost_Panel.add(backBtn);

        setSize(500,500);
        setVisible(true);
        setResizable(false);

        add(homePanel);
        createPost_Panel.setVisible(false);

        for(int i=0; i<10; i++){
            mentoringBtn[i] = new JButton();
            studyBtn[i] = new JButton();
            lectureBtn[i] = new JButton();
            homePanel.add(mentoringBtn[i]);
            homePanel.add(studyBtn[i]);
            homePanel.add(lectureBtn[i]);

        }
        btn1.addActionListener(e -> {
            btn1.setEnabled(false);
            btn2.setEnabled(true);
            btn4.setEnabled(true);
            //true -> false
            imageLabel.setVisible(false);
            //false -> true

            //modify text
            titleLabel.setText("Mentoring");
            infoLabel.setText(btn1.getText());
            postDAO = new PostDAO();
            arrayList =new ArrayList<PostVO>();
            arrayList = postDAO.read(btn1.getText());

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
            for(int i=0; i<arrayList.size(); i++)
            {
                mentoringBtn[i] = new JButton(arrayList.get(i).getTitle());
                mentoringBtn[i].setBounds(150, 115+50*i, 250, 50);
                homePanel.add(mentoringBtn[i]);
                mentoringBtn[i].setVisible(true);

            }





        });
        btn2.addActionListener(e->{
            btn1.setEnabled(true);
            btn2.setEnabled(false);
            btn4.setEnabled(true);
            //true -> false
            imageLabel.setVisible(false);
            //false -> true

            //modify text
            titleLabel.setText("Study");
            infoLabel.setText(btn2.getText());
            postDAO = new PostDAO();
            arrayList =new ArrayList<PostVO>();
            arrayList = postDAO.read(btn2.getText());



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
                studyBtn[i].setBounds(150, 115+50*i, 250, 50);
                homePanel.add(studyBtn[i]);
                studyBtn[i].setVisible(true);
            }



        });
        btn3.addActionListener(e->{

        });
        btn4.addActionListener(e->{
            btn1.setEnabled(true);
            btn2.setEnabled(true);
            btn4.setEnabled(false);
            //true -> false
            imageLabel.setVisible(false);
            //false -> true

            //modify text
            titleLabel.setText("Lecture");
            infoLabel.setText(btn4.getText());
            postDAO = new PostDAO();
            arrayList =new ArrayList<PostVO>();
            arrayList = postDAO.read(btn4.getText());


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
                lectureBtn[i].setBounds(150, 115+50*i, 250, 50);
                homePanel.add(lectureBtn[i]);
                lectureBtn[i].setVisible(true);
            }



        });
        btn5.addActionListener(e->{
            homePanel.setVisible(false);
            createPost_Panel.setVisible(true);
            System.out.println(vo.getUser_Id());
        });

        createBtn.addActionListener(e->{
            select = selectBox.getSelectedItem().toString();
            System.out.println(select);
            try {
                create(vo);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        });
        backBtn.addActionListener(e->{
            homePanel.setVisible(true);
            createPost_Panel.setVisible(false);
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
            createPost_Panel.setVisible(false);
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