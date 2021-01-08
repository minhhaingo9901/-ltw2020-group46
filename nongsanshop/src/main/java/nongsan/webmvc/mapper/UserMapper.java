package nongsan.webmvc.mapper;

import nongsan.webmvc.model.Role;
import nongsan.webmvc.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs) {
        try {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPhone(rs.getString("phone"));
            user.setCreated(rs.getString("created"));
            user.getRoleid(rs.getLong("roleid"));
            user.getStatus(rs.getString("status"));
            try {
                Role role = new Role();
                role.setCode(rs.getString("code"));
                role.setName(rs.getString("name"));
                user.setRole(role);

            }catch (Exception e) {
                System.out.print(e.getMessage());
            }
            return user;
        } catch (SQLException e) {
            return  null;
        }
    }
}
