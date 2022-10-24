package databases;

import javax.security.auth.login.LoginException;
import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
    private Connection connection =new ConnectDB().getConnection();; // db연결 정보
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public boolean queryCheck = false;

    public UserDAO(){

    }
    public void databasesClose() {
        try {
            if (connection != null)
                connection.close();
            if (ps != null)
                ps.close();
            if (rs != null)
                rs.close();
        } catch (Exception e) {
            System.out.println(e + ": dbClose fail");
        }
    }
    //CRUD
    public boolean create(UserVO userDTO){
        queryCheck = false;
        try{
            String sql = "INSERT INTO user(id, password, name) VALUES (?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1,userDTO.getId());
            ps.setString(2,userDTO.getPassword());
            ps.setString(3,userDTO.getName());
            int r = ps.executeUpdate();
            if(r>0){
                queryCheck =true;
            }

        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally {
            databasesClose();
        }
        return queryCheck;
    }
    public boolean login(String uid, String pass){
       queryCheck = false;
        try {

            String sql = "SELECT password FROM user WHERE id = ?";
            ps = connection.prepareStatement(sql);


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
    public UserVO userData(String uid, String password){
        UserVO vo= new UserVO();
        try {

            String sql = "SELECT id, password, name FROM user WHERE id = ? and password=?";
            ps = connection.prepareStatement(sql);


            ps.setString(1, uid);
            ps.setString(2,password);

            rs = ps.executeQuery();
            rs.next();

            vo.setId(rs.getString(1));
            vo.setPassword(rs.getString(2));
            vo.setName(rs.getString(3));
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            databasesClose();
        }

        return vo;
    }
    public void update() {

    }
    public void delete(){

    }
}
