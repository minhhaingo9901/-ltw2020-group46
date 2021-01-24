package nongsan.webmvc.service.impl;


import nongsan.webmvc.dao.UserDao;
import nongsan.webmvc.dao.impl.UserDaoImpl;
import nongsan.webmvc.model.User;
import nongsan.webmvc.service.UserService;

import java.util.List;

public class UserServicesImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void edit(User newUser) {
        User oldUSer = userDao.get(newUser.getId());
        oldUSer.setName(newUser.getName());
        oldUSer.setEmail(newUser.getEmail());
        oldUSer.setPhone(newUser.getPhone());
        oldUSer.setUsername(newUser.getUsername());
        oldUSer.setPassword(newUser.getPassword());
        oldUSer.setCreated(newUser.getCreated());
        userDao.edit(oldUSer);

    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public boolean checkLogin(String Username, String Password, int Roleid, int Status) {

        return userDao.checkLogin(Username,Password,Roleid,Status);
    }

    @Override
    public boolean checkLogin1(String Username, String Password, int Roleid, int Status) {
        return userDao.checkLogin1(Username,Password,Roleid,Status);
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public List<User> getAdminList() {
        return userDao.getAdminList();
    }


    @Override
    public void delete(int id) {
        userDao.delete(id);

    }

    @Override
    public User get(int id) {
        return userDao.get(id);
    }

    @Override
    public User get(String name) {
        // TODO Auto-generated method stub
        return null;
    }


}