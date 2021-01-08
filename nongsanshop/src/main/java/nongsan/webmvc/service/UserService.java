package nongsan.webmvc.service;

import nongsan.webmvc.model.User;

public interface UserService {
    User findByUserNameAndPasswordAndStatus(String username, String password, Integer status);
}
