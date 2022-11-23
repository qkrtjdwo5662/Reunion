package views;
import javax.swing.*;

public class CreatePost extends JPanel {
   public JPanel createPost_Panel;
   private JTextField titleText, contentsText, memberText;
   private JButton makeBtn, backBtn;
   String selectArray[] = {"Mentoring","Study","Lecture"};
   JComboBox<String> selectBox;
   String select;
   private JLabel categoryLabel;
   private JLabel nameLabel;
   private JLabel contentsLabel;
   private JLabel memberLabel;
   public CreatePost() {

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
        
      contentsText = new JTextField();
      contentsText.setBounds(45, 170, 240, 120);
      createPost_Panel.add(contentsText);
      contentsText.setColumns(25);
        
      memberText = new JTextField();
      memberText.setBounds(45, 330, 40, 30);
      createPost_Panel.add(memberText);
      memberText.setColumns(25);
        
      makeBtn = new JButton("만들기");
      makeBtn.setBounds(150, 400, 100, 30);
      createPost_Panel.add(makeBtn);
        
      backBtn = new JButton("뒤로가기");
      backBtn.setBounds(250, 400, 100, 30);
      createPost_Panel.add(backBtn);


      setSize(500,500);
      setVisible(true);

      makeBtn.addActionListener(e->{
         select = selectBox.getSelectedItem().toString();
      });

}

   public static void main(String[] args) {
      CreatePost cp = new CreatePost();
   
   }

}