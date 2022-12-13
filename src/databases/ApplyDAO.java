package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public boolean apply(PostVO postVO,UserVO userVO){
        queryCheck = false;
        try {
            String sql = "INSERT INTO applied VALUES (null, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1,postVO.getPost_Id());
            ps.setString(2, userVO.getUser_Id());
            int r = ps.executeUpdate();
            if(r>0){ //query
                queryCheck = true;
            }
        }catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return queryCheck;
    }
    public int countApply(int postId){
        int count =0;
        try {
            String sql = "select count(user_Id) as count from applied where post_Id=?";
            ps = connection.prepareStatement(sql);


            ps.setInt(1, postId);

            rs = ps.executeQuery();
            rs.next();


            count = rs.getInt(1);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return count;
    }
    public ArrayList<String> checkDuplicate(int postId){
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            String sql = "select user_Id from applied where post_Id=?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, postId);

            rs = ps.executeQuery();
            while (rs.next())
            {
                arrayList.add(rs.getString(1));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;

    }
}
