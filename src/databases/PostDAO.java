package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PostDAO {
    private Connection connection = new ConnectDB().getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public PostDAO(){

    }
    public void databasesClose(){
        try {
            if(connection != null)
                connection.close();
            if(ps != null)
                ps.close();
            if(rs != null)
                rs.close();
        }catch (Exception e){
            System.out.println(e + "dbClose fail");
        }
    }
    public void create(PostVO postVO){

    }
    public void update(){

    }
    public void delete(){

    }
}
