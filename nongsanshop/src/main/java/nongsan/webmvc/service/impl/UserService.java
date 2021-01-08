package nongsan.webmvc.service.impl;

import nongsan.webmvc.dao.UserDao;
import nongsan.webmvc.model.User;

import javax.inject.Inject;

public class UserService implements nongsan.webmvc.service.UserService {

    @Inject
    private UserDao userDao;

    @Override
    public User findByUserNameAndPasswordAndStatus(String username, String password, Integer status) {
        return userDao.findByUserNameAndPasswordAndStatus(username,password,status);
    }
}
