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
    public void create(PostVO postVO){
        queryCheck = false;
        try {
            String sql = "INSERT INTO post(post_Id, category, content, createDate, user_Id) VALUES (?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,postVO.getPost_Id());
            ps.setString(2,postVO.getCategory());
            ps.setString(3,postVO.getContent());
            ps.setDate(4, (Date) postVO.getCreateDate());
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
    }
    public void update(){

    }
    public void delete(){

    }
}
