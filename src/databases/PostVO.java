package databases;

import java.util.Date;


public class PostVO {
    private int post_Id;
    private String content;
    private Date createDate;

    public PostVO(){

    }
    public PostVO(int post_Id, String content, Date createDate){
        this.post_Id = post_Id;
        this.content = content;
        this.createDate = createDate;
    }

    public int getPost_Id(){
        return post_Id;
    }
    public void setPost_Id(int post_Id){
        this.post_Id = post_Id;
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
}
