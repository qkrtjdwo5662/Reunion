package databases;

public class UserVO {
    private String user_Id;
    private String password;
    private String name;

    public UserVO(){

    }
    public UserVO(String user_Id, String password, String name){
        this.user_Id = user_Id;
        this.password = password;
        this.name = name;
    }

    public String getUser_Id(){
        return user_Id;
    }
    public void setUser_Id(String user_Id){
        this.user_Id = user_Id;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

}
