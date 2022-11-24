package databases;

import java.sql.*;

public class PostDAO {
    private Connection connection = new ConnectDB().getConnection();
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    public boolean queryCheck = false;
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
    public boolean create(PostVO postVO){
        queryCheck = false;
        try {
            String sql = "INSERT INTO post VALUES (null, ?, ?, ?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1,postVO.getCategory());
            ps.setString(2,postVO.getTitle());
            ps.setString(3,postVO.getContent());
            ps.setInt(4,postVO.getLimit());
            ps.setString(5, postVO.getUser_Id());
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
    public void update(){

    }
    public void delete(){

    }
}
