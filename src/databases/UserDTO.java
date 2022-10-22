package databases;

public class UserDTO {
    private String id;
    private String password;
    private String name;

    public UserDTO(){

    }
    public UserDTO(String id, String password, String name){
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public String getId(){
        return id;
    }
    public void setId(){
        this.id = id;
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
