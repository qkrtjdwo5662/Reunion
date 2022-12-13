package databases;

public class ApplyVO {
    private int apply_Id;
    private int post_Id;
    private String user_Id;

    public ApplyVO(){

    }
    public ApplyVO(int apply_Id, int post_Id, String user_Id){
        this.apply_Id = apply_Id;
        this.post_Id = post_Id;
        this.user_Id = user_Id;
    }

    public int getApply_Id(){
        return apply_Id;
    }
    public void setApply_Id(int apply_Id){
        this.apply_Id = apply_Id;
    }
    public int getPost_Id(){
        return post_Id;
    }
    public void setPost_Id(int post_Id){
        this.post_Id = post_Id;
    }
    public String getUser_Id(){
        return user_Id;
    }
    public void setUser_Id(String user_Id){
        this.user_Id = user_Id;
    }
}
