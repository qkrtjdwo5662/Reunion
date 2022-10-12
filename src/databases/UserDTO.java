package databases;

public class UserDTO {
    private String stu_id;
    private String password;
    private String name;

    public UserDTO(){

    }
    public UserDTO(String stu_id, String password, String name){
        this.stu_id = stu_id;
        this.password = password;
        this.name = name;
    }

    public String getId(){
        return stu_id;
    }
    public void setId(){
        this.stu_id = stu_id;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(){
        this.password = password;
    }
    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }

}
