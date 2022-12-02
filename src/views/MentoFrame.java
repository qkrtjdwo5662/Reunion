package views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MentoFrame extends JFrame{
	private JPanel mainPanel;
	   private JTextField nameText, majorText, numberText, comentText;
	   private JTextArea bskillText,fskillText,dataText;
	   private JButton completionBtn, cancleBtn;
	   private JLabel titleLabel, nameLabel,majorLabel, numberLabel,comentLabel,skill1Label, skill2Label,bskillLabel,fskillLabel,dataLabel;
	   private JLabel imageLabel;
	   private ImageIcon icon;
	   
	public MentoFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        JFrame frame = new JFrame();
 	    Font font = new Font("Arial", Font.BOLD, 20);
        
        mainPanel = new JPanel();
        add(mainPanel);
        mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        mainPanel.setLayout(null);
        
        //imageLabel
        icon = new ImageIcon("image1/people.jpg"); // 이미지 로딩
        imageLabel = new JLabel(icon); // 이미지 레이블 만들기
        imageLabel.setSize(icon.getIconHeight(),icon.getIconWidth());
        imageLabel.setLocation(15,70);
        mainPanel.add(imageLabel);

        //textLabel
        titleLabel = new JLabel("Mento Intoduce");
        titleLabel.setBounds(175,10,331,50);
        mainPanel.add(titleLabel);
        titleLabel.setFont(font);
        
        //nameLabel
        nameLabel = new JLabel("성명:");
        nameLabel.setBounds(160,70,331,30);
        mainPanel.add(nameLabel);
        //nameText
        nameText = new JTextField();
        nameText.setBounds(205,75,100,25);
        mainPanel.add(nameText);
        nameText.setColumns(5);
        
        //majorLabel
        majorLabel = new JLabel("전공:");
        majorLabel.setBounds(160,100,50,30);
        mainPanel.add(majorLabel);
        //majorText
        majorText = new JTextField();
        majorText.setBounds(205,105,100,25);
        mainPanel.add(majorText);
        majorText.setColumns(15);
        
        //numberLabel
        numberLabel = new JLabel("연락처:");
        numberLabel.setBounds(160,130,331,30);
        mainPanel.add(numberLabel);
        //numberText
        numberText  = new JTextField();
        numberText.setBounds(205,135,100,25);
        mainPanel.add(numberText);
        numberText.setColumns(15);
        
        //comentLabel
        comentLabel = new JLabel("멘트:");
        comentLabel.setBounds(160,160,331,30);
        mainPanel.add(comentLabel);
        //comentText
        comentText  = new JTextField();
        comentText.setBounds(205,165,250,25);
        mainPanel.add(comentText);
        comentText.setColumns(30);
        
        //skill1Label
        skill1Label = new JLabel("Technical");
        skill1Label.setBounds(35,220,331,30);
        mainPanel.add(skill1Label);
        skill1Label.setFont(font);
        
        //skill2Label
        skill2Label = new JLabel("Skills");
        skill2Label.setBounds(35,250,331,30);
        mainPanel.add(skill2Label);
        skill2Label.setFont(font);
        
        //bskillLabel
        bskillLabel = new JLabel("Back-End Skills");
        bskillLabel.setBounds(160,210,331,30);
        mainPanel.add(bskillLabel);
        //bskillText
        bskillText  = new JTextArea();
        bskillText.setBounds(160,240,150,50);
        mainPanel.add(bskillText);
        
        //fskillLabel
        fskillLabel = new JLabel("Front-End Skills");
        fskillLabel.setBounds(160,290,331,30);
        mainPanel.add(fskillLabel);
        //fskillText
        fskillText  = new JTextArea();
        fskillText.setBounds(160,320,150,50);
        mainPanel.add(fskillText);
        
        //dataLabel
        dataLabel = new JLabel("Databases");
        dataLabel.setBounds(160,370,331,30);
        mainPanel.add(dataLabel);
        //dataText
        bskillText  = new JTextArea();
        bskillText.setBounds(160,400,150,50);
        mainPanel.add(bskillText);
        
        //completionBtn
        completionBtn = new JButton("완료");
        completionBtn.setBounds(330,430,70,20);
        completionBtn.setBackground(Color.yellow);
        mainPanel.add(completionBtn);
        
        //cancleBtn
        cancleBtn = new JButton("취소");
        cancleBtn.setBounds(405,430,70,20);
        cancleBtn.setBackground(Color.yellow);
        mainPanel.add(cancleBtn);
        
        //frame 설정
        frame.add(mainPanel);
        frame.setVisible(true);
        frame.setResizable(false); //frame 크기조정 x
        frame.setSize(500,500);
  
	}
	public static void main(String[] args) {
		new MentoFrame();
	}

}
