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

@WebServlet(name = "deleteAdmin", urlPatterns = "/admin/admin/delete")
public class AdminDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserService userService = new UserServicesImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int admin_id = Integer.parseInt(request.getParameter("admin-id"));
        userService.delete(admin_id);
        request.setAttribute("adminlist", userService.getAdminList());
        RequestDispatcher dispatcherUser  = request.getRequestDispatcher("/view/admin/admin.jsp");
        dispatcherUser.forward(request, response);

    }
}
