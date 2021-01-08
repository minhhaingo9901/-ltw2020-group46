package nongsan.webmvc.dao;

import nongsan.webmvc.model.User;

public interface UserDao extends GenericDao<User> {
    User findByUserNameAndPasswordAndStatus(String username, String password, Integer status);
}
