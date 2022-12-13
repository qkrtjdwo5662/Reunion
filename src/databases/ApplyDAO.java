package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplyDAO {
    private Connection connection = new ConnectDB().getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    public boolean queryCheck = false;
    public ApplyDAO(){

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
    public boolean apply(PostVO postVO){
        queryCheck = false;
        try {
            String sql = "INSERT INTO applied VALUES (null, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,postVO.getPost_Id());
            ps.setString(2, postVO.getUser_Id());
            int r = ps.executeUpdate();
            if(r>0){ //query
                queryCheck = true;
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }finally {
            databasesClose();
        }
        return queryCheck;
    }

}
