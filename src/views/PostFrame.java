package views;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PostFrame extends JFrame {
    public JPanel postPanel;
    private JButton postApplyBtn, postBackBtn;


    PostFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        postPanel = new postPanel();
        add(postPanel);
        postPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        postPanel.setLayout(null);

        JLabel titleLabel=new JLabel("**Title**",JLabel.CENTER);
        titleLabel.setBounds(150,50,200,60);
        titleLabel.setFont(new Font("Selif",Font.BOLD,30));
        postPanel.add(titleLabel);
        JLabel writerlabel1 = new JLabel("작성자 :");
        writerlabel1.setBounds(100,100,50,40);
        writerlabel1.setFont(new Font("Selif",Font.PLAIN,11));
        writerlabel1.setForeground(Color.GRAY);
        postPanel.add(writerlabel1);

        JLabel writerlabel2 = new JLabel("qkrtjdwo5662");
        writerlabel2.setBounds(150,100,100,40);
        writerlabel2.setFont(new Font("Selif",Font.PLAIN,11));
        writerlabel2.setForeground(Color.GRAY);
        postPanel.add(writerlabel2);

        JLabel memberlabel1 = new JLabel("잔여인원 :");
        memberlabel1.setBounds(280,100,50,40);
        memberlabel1.setFont(new Font("Selif",Font.PLAIN,11));
        memberlabel1.setForeground(Color.GRAY);
        postPanel.add(memberlabel1);

        JLabel memberlabel2 = new JLabel("1/3");
        memberlabel2.setBounds(330,100,300,40);
        memberlabel2.setFont(new Font("Selif",Font.PLAIN,11));
        memberlabel2.setForeground(Color.GRAY);
        postPanel.add(memberlabel2);


        JLabel contentslabel = new JLabel("안녕하세요 객체지향언어2 유상미 교수님 강의듣는 2학년 학생입니다.",JLabel.CENTER);
        contentslabel.setBounds(40, 75, 400, 200);
        postPanel.add(contentslabel);

        postBackBtn = new JButton("뒤로가기");
        postBackBtn.setBounds(250, 400, 100, 30);
        postBackBtn.setBackground(Color.white);
        postPanel.add(postBackBtn);

        postApplyBtn = new JButton("신청하기");
        postApplyBtn.setBounds(150, 400, 100, 30);
        postApplyBtn.setBackground(Color.orange);
        postPanel.add(postApplyBtn);

        postPanel.setBackground(Color.white);
        this.setSize(500,500);
        this.setVisible(true);
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
        PostFrame tf = new PostFrame();

    }

}