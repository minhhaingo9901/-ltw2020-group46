package nongsan.webmvc.controller.admin;

import nongsan.webmvc.service.UserService;
import nongsan.webmvc.service.impl.UserServicesImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteUser", urlPatterns = "/admin/user/delete")
public class UserDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserService userService = new UserServicesImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int user_id = Integer.parseInt(request.getParameter("user-id"));
        userService.delete(user_id);
        request.setAttribute("userList", userService.getUserList());
        RequestDispatcher dispatcherUser  = request.getRequestDispatcher("/view/admin/user.jsp");
        dispatcherUser.forward(request, response);
    }
}
