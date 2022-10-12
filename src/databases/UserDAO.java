package databases;

import java.sql.*;

public class UserDAO {
    Connection connection = null;
    PreparedStatement ps = null;

    ResultSet rs = null;
    Statement st = null;
    public UserDAO(){

    }
    public void databasesClose() {
        try {
            if (rs != null)
                rs.close();
            if (st != null)
                st.close();
            if (ps != null)
                ps.close();
        } catch (Exception e) {
            System.out.println(e + ": dbClose fail");
        }
    }
    //CRUD
    public void create(UserDTO userDTO){
        try{
            String sql = "INSERT INTO user(stu_id, password, name) values(?, ?, ?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1,userDTO.getId());
            ps.setString(2,userDTO.getPassword());
            ps.setString(3,userDTO.getName());
            ps.executeUpdate();
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }finally {
            databasesClose();
        }

    }
    public void read(UserDTO userDTO){
        String id = userDTO.getId();
        String sql = "SELECT password FROM user WHERE id='" + id + "'";

    }
    public void update() {

    }
    public void delete(){

    }
}
