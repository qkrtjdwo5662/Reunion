package databases;

import java.sql.*;

public class ConnectDB {
    private Connection connection = null; // db연결 정보
//    private PreparedStatement ps = null;
//    private ResultSet rs = null;
    private String url =  "jdbc:mysql://127.0.0.1:3306/reunion";
    private String id = "root";
    private String password = "1111";

    public ConnectDB() {

    }
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //driver loading
            connection = DriverManager.getConnection(url,id,password);
            //db 연결
            System.out.println("Connection Complete");



        }catch (ClassNotFoundException cnfe){
            System.out.println("DB 드라이버 로딩 실패 :" + cnfe.toString());
        }catch (SQLException sqle) {
            System.out.println("DB 접속실패 : " + sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }

        return connection;
    }
    public void closeConnection(Connection c, PreparedStatement ps, ResultSet rs){
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

}
