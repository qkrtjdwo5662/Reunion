package databases;

import java.sql.*;

public class ConnectDB {
    Connection connection = null;
    String url =  "jdbc:mysql://3.38.179.58:3306/?user=root";
    String id = "root";
    String password = "paul2858";

    Statement statement = null;
    public ConnectDB() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
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

    }

}
