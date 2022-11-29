package views;
import databases.UserVO;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PostFrame extends JFrame {
    public JPanel postPanel;
    private JButton postApplyBtn, postBackBtn;
    private JLabel postTitleLabel, postWriterLabel1, postWriterLabel2, postFixedNumberLabel1, postFixedNumberLabel2, postContentLabel;

    public PostFrame(UserVO userVO){

        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        postPanel = new postPanel();
        add(postPanel);
        postPanel.setLayout(null);

        postTitleLabel =new JLabel("**Title**",JLabel.CENTER);
        postTitleLabel.setBounds(150,50,200,60);
        postTitleLabel.setFont(new Font("Selif",Font.BOLD,30));
        postPanel.add(postTitleLabel);
        
        postWriterLabel1 = new JLabel("작성자 :");
        postWriterLabel1.setBounds(100,100,50,40);
        postWriterLabel1.setFont(new Font("Selif",Font.PLAIN,11));
        postWriterLabel1.setForeground(Color.GRAY);
        postPanel.add(postWriterLabel1);

        postWriterLabel2 = new JLabel("qkrtjdwo5662");
        postWriterLabel2.setBounds(150,100,100,40);
        postWriterLabel2.setFont(new Font("Selif",Font.PLAIN,11));
        postWriterLabel2.setForeground(Color.GRAY);
        postPanel.add(postWriterLabel2);

        postFixedNumberLabel1 = new JLabel("잔여인원 :");
        postFixedNumberLabel1.setBounds(280,100,50,40);
        postFixedNumberLabel1.setFont(new Font("Selif",Font.PLAIN,11));
        postFixedNumberLabel1.setForeground(Color.GRAY);
        postPanel.add(postFixedNumberLabel1);

        postFixedNumberLabel2 = new JLabel("1/3");
        postFixedNumberLabel2.setBounds(330,100,300,40);
        postFixedNumberLabel2.setFont(new Font("Selif",Font.PLAIN,11));
        postFixedNumberLabel2.setForeground(Color.GRAY);
        postPanel.add(postFixedNumberLabel2);


        postContentLabel = new JLabel("안녕하세요 객체지향언어2 유상미 교수님 강의듣는 2학년 학생입니다.",JLabel.CENTER);
        postContentLabel.setBounds(40, 75, 400, 200);
        postPanel.add(postContentLabel);

        postBackBtn = new JButton("뒤로가기");
        postBackBtn.setBounds(250, 400, 100, 30);
        postBackBtn.setBackground(Color.white);
        postPanel.add(postBackBtn);

        postApplyBtn = new JButton("신청하기");
        postApplyBtn.setBounds(150, 400, 100, 30);
        postApplyBtn.setBackground(Color.orange);
        postPanel.add(postApplyBtn);

        postPanel.setBackground(Color.white);

        setVisible(true);
        setResizable(false);

        postBackBtn.addActionListener(e->{
            MainFrame mf = new MainFrame(userVO);
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

    public static void main(String[] args) {
        UserVO userVO = new UserVO();
        PostFrame tf = new PostFrame(userVO);

    }

}