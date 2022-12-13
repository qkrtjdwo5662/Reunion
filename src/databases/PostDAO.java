package databases;

import java.sql.*;
import java.util.ArrayList;

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
        }
        return queryCheck;
    }
    public ArrayList<PostVO> read(String category){
        ArrayList<PostVO> arrayList = new ArrayList<PostVO>();
        try {
            String sql = "SELECT * FROM post WHERE category=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,category);

            rs = ps.executeQuery();
            while (rs.next())
            {
                arrayList.add(new PostVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getInt(5),rs.getString(6)
                ));
            }


        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }
    public int countPosts(String uid){
        int count = 0;
        try {

            String sql = "select count(user_Id) as count from post where user_Id=?";
            ps = connection.prepareStatement(sql);


            ps.setString(1, uid);

            rs = ps.executeQuery();
            rs.next();


            count = rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }


    public void update(){

    }
    public void delete(){

    }
}
