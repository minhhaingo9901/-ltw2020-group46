package nongsan.webmvc.dao;
import nongsan.webmvc.model.User;
import java.util.List;
public interface UserDao {




    void insert(User user);

        void edit(User user);

        void delete(int id);

        User get(String name);

        User get(int id);

        List<User> getAll();

        List<User> getUserList();

        List<User> getAdminList();

        // Kiem tra dang nhap role client
        public boolean checkLogin(String Username, String Password, int Roleid, int Status);

        // Kiem tra dang nhap role admin
        public boolean checkLogin1(String Username, String Password, int Roleid, int Status);




    }

