package nongsan.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import nongsan.webmvc.model.User;

public class RegisterDaoImpl {
    Connection con;
    public RegisterDaoImpl(Connection con)
    {
        this.con =con;
    }
    public boolean RegisterUser (User user)
    {
        boolean set = false;
        try
        {
            String sql = "INSERT INTO user (roleid,name,email,phone,username,password,status,created) values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            preparedStatement.setInt(1,user.getRoleid());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getName());
            preparedStatement.setInt(7, user.getStatus());
            preparedStatement.setString(8, user.getCreated());
            preparedStatement.executeUpdate();

            set = true;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return set;  // On failure, send a message from here.
    }
}
