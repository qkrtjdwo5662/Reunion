package databases;

import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import java.sql.*;

public class UserDAO {
    private Connection c =null; // db연결 정보
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public boolean queryCheck = false;

    public UserDAO(){

    }
    public void databasesClose() {
        try {
            if (c != null)
                c.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();
        } catch (Exception e) {
            System.out.println(e + ": dbClose fail");
        }
    }
    //CRUD
//    public void create(UserDTO userDTO){
//        try{
//            String sql = "INSERT INTO user(stu_id, password, name) values(?, ?, ?)";
//            ps = connection.prepareStatement(sql);
//            ps.setString(1,userDTO.getId());
//            ps.setString(2,userDTO.getPassword());
//            ps.setString(3,userDTO.getName());
//            ps.executeUpdate();
//        }catch(SQLException sqle){
//            sqle.printStackTrace();
//        }finally {
//            databasesClose();
//        }
//
//    }
    public boolean read(String uid, String pass){
       queryCheck = false;
        c = new ConnectDB().getConnection();
        try {

            String sql = "SELECT password FROM user WHERE id = ?";
            ps = c.prepareStatement(sql);

            ps.setString(1, uid);

            rs = ps.executeQuery();

            if(rs.next()){
                if(pass.equals(rs.getString("password"))){
                    queryCheck = true;
                }else{
                    throw new LoginException("로그인오류");
                }

            }else{
                throw new LoginException("로그인오류");
            }
        }catch (SQLException e){
            e.printStackTrace();
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }

        return queryCheck;
    }
    public void update() {

    }
    public void delete(){

    }
}
