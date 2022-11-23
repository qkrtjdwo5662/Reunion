package databases;

import java.util.Date;


public class PostVO {
    private int post_Id;
    private String category;
    private String content;
    private Date createDate;
    private String user_Id;

    public PostVO(){

    }
    public PostVO(int post_Id, String category, String content, Date createDate, String user_Id){
        this.post_Id = post_Id;
        this.category = category;
        this.content = content;
        this.createDate = createDate;
        this.user_Id = user_Id;
    }

    public int getPost_Id(){
        return post_Id;
    }
    public void setPost_Id(int post_Id){
        this.post_Id = post_Id;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public Date getCreateDate(){
        return createDate;
    }
    public void setCreateDate(Date createDate){
        this.createDate = createDate;
    }
    public String getUser_Id(){
        return user_Id;
    }
    public void setUser_Id(String user_Id){
        this.user_Id = user_Id;
    }
}
