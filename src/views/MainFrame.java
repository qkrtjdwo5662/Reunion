package views;

import com.sun.tools.javac.Main;
import databases.PostDAO;
import databases.PostVO;
import databases.UserVO;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {
    private JPanel homePanel,btnPanel;
    private ImageIcon icon;
    private JLabel imageLabel,titleLabel,welcomeLabel,menuLabel,infoLabel;
    private JButton btn1,btn2,btn3,btn4,btn5,btn6;
    private String info;
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
        btnPanel = new JPanel();
        add(homePanel);

        homePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        homePanel.setLayout(null);
        btnPanel.setLayout(null);
        Font font = new Font("Arial", Font.BOLD, 20);

        icon = new ImageIcon("image1/rogo.jpg"); // 이미지 로딩
        imageLabel = new JLabel(icon); // 이미지 레이블 만들기

        imageLabel.setSize(icon.getIconHeight(),icon.getIconWidth());
        imageLabel.setLocation(200,80);
        homePanel.add(imageLabel);

        titleLabel = new JLabel("Reunion");
        titleLabel.setBounds(200, 10, 331, 50);
        homePanel.add(titleLabel);
        titleLabel.setFont(font);

        welcomeLabel = new JLabel(userVO.getName()+"님 환영합니다");
        welcomeLabel.setBounds(40,80,150,20);
        homePanel.add(welcomeLabel);

        menuLabel = new JLabel("MENU");
        menuLabel.setBounds(43, 10, 100, 20);
        btnPanel.add(menuLabel);

        infoLabel = new JLabel(info);
        infoLabel.setBounds(280,100,150,20);
        homePanel.add(infoLabel);

        btn1 = new JButton("Mentoring");
        btn2 = new JButton("Study");
        btn3 = new JButton("스터디룸 예약");
        btn4 = new JButton("Lecture");
        btn5 = new JButton("글쓰기");
        btn6 = new JButton("검색");

        //--------------------------------------------------------------------//
        btnPanel.setBounds(30, 115, 120, 210);
        btnPanel.setOpaque(true);
        btnPanel.setBackground(Color.GRAY);
        homePanel.add(btnPanel);


        btn1.setBounds(0, 50, 120, 30);
        btn1.setOpaque(true);
        btn1.setBackground(Color.GRAY);
        btnPanel.add(btn1);

        //스터디 버튼 설정
        btn2.setBounds(0, 90, 120, 30);
        btn2.setOpaque(true);
        btn2.setBackground(Color.GRAY);
        btnPanel.add(btn2);

        //스터디룸 버튼 설정
        btn3.setBounds(0, 130, 120, 30);
        btn3.setOpaque(true);
        btn3.setBackground(Color.GRAY);
        btnPanel.add(btn3);

        //졸업생 버튼 설정
        btn4.setBounds(0, 170, 120, 30);
        btn4.setOpaque(true);
        btn4.setBackground(Color.GRAY);
        btnPanel.add(btn4);

        btn5.setBounds(30, 370, 120, 20);
        btn5.setOpaque(true);
        btn5.setBackground(Color.WHITE);
        homePanel.add(btn5);


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
            for(int i=0; i<arrayList.size(); i++) {
                mentoringBtn[i] = new JButton(arrayList.get(i).getTitle());
                mentoringBtn[i].setBounds(150, 115 + 50 * i, 250, 50);
                homePanel.add(mentoringBtn[i]);
                mentoringBtn[i].setVisible(true);
                int finalI = i;
                mentoringBtn[i].addActionListener(e1 -> {
                    setVisible(false);
                    new PostFrame(userVO,arrayList.get(finalI));
                });
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
                int finalI = i;
                studyBtn[i].addActionListener(e1 -> {
                    setVisible(false);
                    new PostFrame(userVO,arrayList.get(finalI));
                });
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