package nongsan.webmvc.dao.impl;

import nongsan.webmvc.mapper.UserMapper;
import nongsan.webmvc.model.User;

import java.util.List;

public class UserDao extends AbstractDao<User> implements nongsan.webmvc.dao.UserDao {
    @Override
    public User findByUserNameAndPasswordAndStatus(String username, String password, Integer status) {
        StringBuilder sql = new StringBuilder("SELECT * FROM user AS u");
        sql.append("INNER JOIN role AS r ON r.id = u.roleid");
        sql.append("WEHRE username = ? AND password = ? AND status = ?");
        List<User> users = query(sql.toString(),new UserMapper(),username,password,status);
        return users.isEmpty() ? null: users.get(0);
    }
}
