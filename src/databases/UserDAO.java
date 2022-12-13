package databases;

import javax.security.auth.login.LoginException;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class UserDAO {
    private Connection connection =new ConnectDB().getConnection(); // db연결 정보
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
    public boolean create(UserVO userVO){
        queryCheck = false;
        try{
            String sql = "INSERT INTO user(user_Id, password, name,phoneNumber,email,authority,point) VALUES (?, ?, ?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1,userVO.getUser_Id());
            ps.setString(2,userVO.getPassword());
            ps.setString(3,userVO.getName());
            ps.setString(4,userVO.getPhoneNumber());
            ps.setString(5,userVO.getEmail());
            ps.setString(6,"mentee");
            ps.setInt(7,0);
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

            String sql = "SELECT password FROM user WHERE user_Id = ?";
            ps = connection.prepareStatement(sql);


            ps.setString(1, uid);

            rs = ps.executeQuery();

            if(rs.next()){
                if(pass.equals(rs.getString("password"))){
                    queryCheck = true;
                }else{
                    JOptionPane.showMessageDialog(null, "로그인 정보를 확인하세요");
                    throw new LoginException("로그인오류");

                }

            }else{
                JOptionPane.showMessageDialog(null, "로그인 정보를 확인하세요");
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
        UserVO userVO= new UserVO();
        try {

            String sql = "SELECT * FROM user WHERE user_Id = ? and password=?";
            ps = connection.prepareStatement(sql);


            ps.setString(1, uid);
            ps.setString(2,password);

            rs = ps.executeQuery();
            rs.next();

            userVO.setUser_Id(rs.getString(1));
            userVO.setPassword(rs.getString(2));
            userVO.setName(rs.getString(3));
            userVO.setPhoneNumber(rs.getString(4));
            userVO.setEmail(rs.getString(5));
            userVO.setAuthority(rs.getString(6));
            userVO.setPoint(rs.getInt(7));
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            databasesClose();
        }

        return userVO;
    }
    public UserVO userInfoData(String uid){
        UserVO userVO= new UserVO();
        try {

            String sql = "SELECT * FROM user WHERE user_Id = ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, uid);

            rs = ps.executeQuery();
            rs.next();

            userVO.setUser_Id(rs.getString(1));
            userVO.setPassword(rs.getString(2));
            userVO.setName(rs.getString(3));
            userVO.setPhoneNumber(rs.getString(4));
            userVO.setEmail(rs.getString(5));
            userVO.setAuthority(rs.getString(6));
            userVO.setPoint(rs.getInt(7));
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            databasesClose();
        }

        return userVO;
    }
    public ArrayList<UserVO> readAll(){
        ArrayList<UserVO> arrayList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM user";
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next())
            {
                arrayList.add(new UserVO(rs.getString(1),rs.getString(2), rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7)
                ));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            databasesClose();
        }

        return arrayList;
    }
    public void update() {

    }
    public void delete(){

    }
}
