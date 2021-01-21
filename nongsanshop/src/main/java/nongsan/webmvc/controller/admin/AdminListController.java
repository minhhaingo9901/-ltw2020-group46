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

@WebServlet(name = "listAdmin", urlPatterns = "/admin/admin/list")
public class AdminListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserService userService = new UserServicesImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> adminList = userService.getAdminList();
        request.setAttribute("adminlist", adminList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/admin.jsp");
        dispatcher.forward(request, response);
    }
}
