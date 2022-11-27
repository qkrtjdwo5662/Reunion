package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class StudyFrame extends JFrame{
    StudyFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);// window center

        //프레임 패널 생성
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JPanel btnpanel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setLayout(null);
        btnpanel.setLayout(null);
        Font font = new Font("Arial", Font.BOLD, 20);

        //textlabel
        JLabel Text_label = new JLabel("Study");
        Text_label.setBounds(200, 10, 331, 50);
        panel.add(Text_label);
        Text_label.setFont(font);

        //menulabel
        JLabel menu_label = new JLabel("MENU");
        menu_label.setBounds(43, 10, 100, 20);
        btnpanel.add(menu_label);

        //menubutton 생성
        JButton btn1 = new JButton("멘토/멘티");
        JButton btn2 = new JButton("스터디");
        JButton btn3 = new JButton("스터디룸 예약");
        JButton btn4 = new JButton("졸업생 강연");
        JButton btn5 = new JButton("글쓰기");
        JButton btn6 = new JButton("검색");

        //studybutton 생성
        JButton study1 = new JButton("C언어 스터디 사람 모집!");
        JButton study2 = new JButton("JAVA 스터디 사람 구해요.");
        JButton study3 = new JButton("웹프 스터디 할분 !!");

        //study 인원수 버튼 생성
        JButton study_m1 = new JButton("3/1");
        JButton study_m2 = new JButton("4/3");
        JButton study_m3 = new JButton("5/2");

        //btnpanel panel에 추가
        btnpanel.setBounds(30, 115, 120, 210);
        btnpanel.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
        btnpanel.setBackground(Color.GRAY); // 배경색을 CYAN 색으로 변경
        panel.add(btnpanel);

        //멘토,멘티 버튼 설정
        btn1.setBounds(0, 50, 120, 30);
        btn1.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
        btn1.setBackground(Color.GRAY); // 배경색을 CYAN 색으로 변경
        btnpanel.add(btn1);

        //스터디 버튼 설정
        btn2.setBounds(0, 90, 120, 30);
        btn2.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
        btn2.setBackground(Color.GRAY); // 배경색을 CYAN 색으로 변경
        btnpanel.add(btn2);
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //버튼 클릭시 메뉴 버튼 색 변경
                btn2.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
                btn2.setBackground(Color.WHITE); // 배경색을 CYAN 색으로 변경

                //버튼 클릭시 글 생성
                study1.setBounds(150, 115, 250, 50);
                study1.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
                study1.setBackground(Color.WHITE); // 배경색을 CYAN 색으로 변경
                panel.add(study1);
                study_m1.setBounds(400, 115, 60, 50);
                study_m1.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
                study_m1.setBackground(Color.WHITE); // 배경색을 CYAN 색으로 변경
                panel.add(study_m1);

                study2.setBounds(150, 165, 250, 50);
                study2.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
                study2.setBackground(Color.WHITE); // 배경색을 CYAN 색으로 변경
                panel.add(study2);
                study_m2.setBounds(400, 165, 60, 50);
                study_m2.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
                study_m2.setBackground(Color.WHITE); // 배경색을 CYAN 색으로 변경
                panel.add(study_m2);

                study3.setBounds(150, 215, 250, 50);
                study3.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
                study3.setBackground(Color.WHITE); // 배경색을 CYAN 색으로 변경
                panel.add(study3);
                study_m3.setBounds(400, 215, 60, 50);
                study_m3.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
                study_m3.setBackground(Color.WHITE); // 배경색을 CYAN 색으로 변경
                panel.add(study_m3);

            }
        });

        //스터디룸 버튼 설정
        btn3.setBounds(0, 130, 120, 30);
        btn3.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
        btn3.setBackground(Color.GRAY); // 배경색을 CYAN 색으로 변경
        btnpanel.add(btn3);

        //졸업생 버튼 설정
        btn4.setBounds(0, 170, 120, 30);
        btn4.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
        btn4.setBackground(Color.GRAY); // 배경색을 CYAN 색으로 변경
        btnpanel.add(btn4);

        //글쓰기 버튼 설정
        btn5.setBounds(30, 370, 120, 20);
        btn5.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
        btn5.setBackground(Color.WHITE); // 배경색을 CYAN 색으로 변경
        panel.add(btn5);

        //검색 버튼 설정
        btn6.setBounds(30, 390, 120, 20);
        btn6.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
        btn6.setBackground(Color.WHITE); // 배경색을 CYAN 색으로 변경
        panel.add(btn6);

        //프레임 조정
        panel.setOpaque(true); // 배경색이 보이록 불투명 속성 설정
        panel.setBackground(Color.WHITE); // 배경색을 CYAN 색으로 변경
        frame.add(panel);
        frame.setVisible(true);
        frame.setResizable(false); //frame 크기조정 x
        frame.setSize(500,500);
    }
    public static void main(String[] args) {
        StudyFrame sf= new StudyFrame();
    }

}
