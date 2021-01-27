package nongsan.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import nongsan.webmvc.jdbc.connectDB;
import nongsan.webmvc.model.User;

public class RegisterDaoImpl {
    Connection con;
    public RegisterDaoImpl(Connection con)
    {
        this.con =con;
    }

    public RegisterDaoImpl() {

    }

    public boolean RegisterUser (User user)
    {
        boolean set = false;
        try
        {
            String sql = "INSERT INTO user (roleid,name,email,phone,username,password,status,created) values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            preparedStatement.setInt(1,user.getRoleid());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getName());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setString(5, user.getUsername());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.setInt(7, user.getStatus());
            preparedStatement.setString(8, user.getCreated());
            preparedStatement.executeUpdate();

            set = true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return set;
    }
    public boolean checkRegister(String email, String phone, String username) {
        boolean  check = false;
        Connection conn = connectDB.getConnect();
        String sql = "SELECT * FROM user WHERE email ='" + email + "'or phone='" + phone +"'or username =' "+ username + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return check;
    }
}
