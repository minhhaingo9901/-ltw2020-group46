package nongsan.webmvc.dao.impl;

import nongsan.webmvc.jdbc.connectDB;
import nongsan.webmvc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ForgotPasswordDaoImpl {
    Connection con;
    public ForgotPasswordDaoImpl(Connection con)
    {
        this.con =con;
    }

    public ForgotPasswordDaoImpl() {

    }

    public boolean checkEmail(String email) {
        boolean  check = false;
        Connection conn = connectDB.getConnect();
        String sql = "SELECT * FROM user WHERE email ='" + email + "'";
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
