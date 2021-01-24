package nongsan.webmvc.controller.admin;

import nongsan.webmvc.model.User;
import nongsan.webmvc.service.UserService;
import nongsan.webmvc.service.impl.UserServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listUser", urlPatterns = "/admin/user/list")
public class UserListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserService userService = new UserServicesImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userService.getUserList();
        request.setAttribute("userList", users);
        RequestDispatcher dispatcherUser  = request.getRequestDispatcher("/view/admin/user.jsp");
        dispatcherUser.forward(request, response);
    }
}
