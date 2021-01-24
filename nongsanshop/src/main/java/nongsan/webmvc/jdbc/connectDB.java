package nongsan.webmvc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
    public connectDB(){
        super();
    }
    public static Connection getConnect(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3307/qlns?useUnicode=true&characterEncoding=UTF-8","root","");
            System.out.println("KN thành công!");
        } catch (RuntimeException | ClassNotFoundException | SQLException e) {
            System.out.println("KN thất bại!"+e.getMessage());
        }
        return connection;
    }
    public static void main(String[] args) {
        System.out.println(getConnect());
    }
}
