package databases;

import java.time.LocalDateTime;
import java.util.Date;


public class PostVO {
    private int post_Id;
    private String category;
    private String title;
    private String content;
    private int limit;
    private String user_Id;

    public PostVO(){

    }
    public PostVO(int post_Id, String category, String title,String content, int limit, String user_Id){
        this.post_Id = post_Id;
        this.category = category;
        this.title = title;
        this.content = content;
        this.limit = limit;
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
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public int getLimit(){
        return limit;
    }
    public void setLimit(int limit){
        this.limit = limit;
    }
    public String getUser_Id(){
        return user_Id;
    }
    public void setUser_Id(String user_Id){
        this.user_Id = user_Id;
    }
}
