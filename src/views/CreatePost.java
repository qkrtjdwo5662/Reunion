package views;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CreatePost extends JFrame {
   public JPanel writePanel;
   private JTextField titleText, contentsText, memberText,searchText;
   private JButton makeBtn, backBtn;
   
   public CreatePost() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      
      //write 패널
      writePanel = new JPanel();
        add(writePanel);
        writePanel.setLayout(null);
        
        JLabel titlelabel = new JLabel("제목");
        titlelabel.setBounds(80, 40,160,40);
        writePanel.add(titlelabel);
        
        JLabel contentslabel = new JLabel("내용");
        contentslabel.setBounds(80,180,160,40);
        writePanel.add(contentslabel);
        
        JLabel memberlabel = new JLabel("참여 인원 수");
        memberlabel.setBounds(80,470,160,40);
        writePanel.add(memberlabel);
        
        titleText = new JTextField();
        titleText.setBounds(80, 90, 400, 50);
        writePanel.add(titleText);
        titleText.setColumns(30);
        
        contentsText = new JTextField();
        contentsText.setBounds(80, 230, 400, 200);
        writePanel.add(contentsText);
        contentsText.setColumns(30);
        
        memberText = new JTextField();
        memberText.setBounds(80, 520, 400, 50);
        writePanel.add(memberText);
        memberText.setColumns(30);
        
        makeBtn = new JButton("만들기");
        makeBtn.setBounds(250, 660, 160, 48);
        writePanel.add(makeBtn);
        
        backBtn = new JButton("뒤로가기");
        backBtn.setBounds(450, 660, 160, 48);
        writePanel.add(backBtn);
        
        searchText = new JTextField();
        searchText.setBounds(500, 600, 50, 50);
        writePanel.add(searchText);
        memberText.setColumns(30);
        
        setSize(800,800);
        setVisible(true);
        
        makeBtn.addActionListener(e-> {
        	if(searchText.isEnabled()==true) {
        		searchText.setVisible(false);
        	}else {
        		searchText.setVisible(true);
        	}
        	
            
        });
}

   public static void main(String[] args) {
      CreatePost cp = new CreatePost();
   
   }

}