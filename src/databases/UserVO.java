package databases;

public class UserVO {
    private String user_Id;
    private String password;
    private String name;
    private String phoneNumber;
    private String email;
    private String authority;
    private int point;
    public UserVO(){

    }
    public UserVO(String user_Id, String password, String name, String phoneNumber, String email, String authority, int point){
        this.user_Id = user_Id;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.authority = authority;
        this.point = point;
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
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getAuthority(){
        return authority;
    }
    public void setAuthority(String authority){
        this.authority = authority;
    }
    public int getPoint(){
        return point;
    }
    public void setPoint(int point){
        this.point = point;
    }


}
